/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.lexer;

import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerInput;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.netbeans.spi.lexer.TokenFactory;

/**
 *
 * @author Calvin Ashmore
 */
public class FnLexer implements Lexer<FnTokenId> {

    // Lexer internal states: small integers for compact token stuff
    private static final int EOF = LexerInput.EOF;
    private static final int ISI_INIT = 0;
    private static final int ISI_ERROR = 100;
    private static final int ISA_INIT_PACKAGE_1 = 200; // after "package"
    private static final int ISA_INIT_PACKAGE_2 = 201; // after "package package.name" 
    private static final int ISA_INIT_PACKAGE_3 = 203; // after "package package.name;"
    private static final int ISA_INIT_GROUP_1 = 210;
    private static final int ISA_INIT_GROUP_2 = 211;
    private static final int ISA_INIT_GROUP_3 = 212;
    private static final int ISA_INIT_TYPE_1 = 220;
    private static final int ISA_INIT_TYPE_2 = 221; // instead of TYPE_3, top is used.
    private static final int ISI_TOP = 250;
    private static final int ISA_IMPORT_1 = 251; // after "import"
    private static final int ISA_IMPORT_2 = 252; // after "import import.name"
    private static final int ISA_DESCRIPTION_1 = 261; // after "description"
    private static final int ISA_DESCRIPTION_2 = 262; // after "description "..""
    private static final int ISA_FN = 301;
    private static final int ISA_FN_NAME = 302;
    private static final int ISI_FN_BODY = 304;
    private static final int ISA_FN_BLOCK_KEYWORD_1 = 310; // after "exec"
    private static final int ISA_FN_BLOCK_KEYWORD_2 = 311; // after "exec {"
    private static final int ISA_FN_BLOCK_KEYWORD_3 = 312; // after "exec {..."
    private static final int ISA_FN_PHRASE_KEYWORD_1 = 320; // after "in"
    private static final int ISA_FN_PHRASE_KEYWORD_2 = 321; // after "in ..."
    private LexerInput input;
    private TokenFactory<FnTokenId> tokenFactory;
    private int state;

    FnLexer(LexerRestartInfo info) {
        this.input = info.input();
        this.tokenFactory = info.tokenFactory();
        this.state = (info.state() != null) ? (Integer) info.state() : ISI_INIT;
    }

    /**
     * The workhorse implementation of the lexer. Returns the next token given
     * the current lexer input and state.
     * @return
     */
    public Token<FnTokenId> nextToken() {

        // handle whitespace if any exists
        int c = input.read();
        if (Character.isWhitespace(c)) {
            return finishWhitespace();
        }

        // terminate if we are at the end of the file.
        if (c == EOF) {
            return null;
        }

        // check for comments
        if (c == '/') {
            int c1 = input.read();
            if (c1 == '/') {
                return finishLineComment();
            }
            if (c1 == '*') {
                return finishBlockComment();
            }
            input.backup(1);
        }

        // we are not at whitespace:
        // go through states and see what happens.
        switch (state) {

            // **********************
            // *** READ Fn HEADER ***
            // **********************

            // at top, we want package
            case ISI_INIT: {
                input.backup(1);
                if (readString("package")) {
                    return keywordOrError(FnTokenId.PACKAGE, ISA_INIT_PACKAGE_1);
                } else {
                    return finishError(ISI_TOP);
                }
            }

            // after "package"
            // read package.name
            case ISA_INIT_PACKAGE_1: {
                return finishDottedName(c, ISA_INIT_PACKAGE_2);
            }

            // after "package package.name"
            // read ;
            case ISA_INIT_PACKAGE_2: {
                if (c == ';') {
                    state = ISA_INIT_PACKAGE_3;
                    return token(FnTokenId.SYMBOL);
                } else {
                    return token(FnTokenId.ERROR);
                }
            }

            // after "package package.name;"
            // read group
            case ISA_INIT_PACKAGE_3: {
                input.backup(1);
                if (readString("group")) {
                    return keywordOrError(FnTokenId.GROUP, ISA_INIT_GROUP_1);
                } else {
                    return finishError(ISI_TOP);
                }
            }

            // after "group"
            // read groupName
            case ISA_INIT_GROUP_1: {
                state = ISA_INIT_GROUP_2;
                return finishIdentifier(c, FnTokenId.NAME);
            }

            // after "group groupName"
            // read ;
            case ISA_INIT_GROUP_2: {
                if (c == ';') {
                    state = ISA_INIT_GROUP_3;
                    return token(FnTokenId.SYMBOL);
                } else {
                    return token(FnTokenId.ERROR);
                }
            }

            // after "group groupName;"
            // read type
            case ISA_INIT_GROUP_3: {
                input.backup(1);
                if (readString("type")) {
                    return keywordOrError(FnTokenId.TYPE, ISA_INIT_TYPE_1);
                } else {
                    return finishError(ISI_TOP);
                }
            }

            // after "type"
            // read typeName
            case ISA_INIT_TYPE_1: {
                input.backup(1);
                if (readString("Expression") ||
                        readString("Statement") ||
                        readString("Command") ||
                        readString("Accessor")) {
                    return keywordOrError(FnTokenId.TYPE_VALUE, ISA_INIT_TYPE_2);
                }

                return finishError(ISA_INIT_TYPE_2);
            //return token(FnTokenId.ERROR);
            //state = ISA_INIT_TYPE_2;
            //return finishIdentifier(c);
            }

            // after "type typeName"
            // read ;
            case ISA_INIT_TYPE_2: {
                if (c == ';') {
                    state = ISI_TOP;
                    return token(FnTokenId.SYMBOL);
                } else {
                    return token(FnTokenId.ERROR);
                }
            }

            // ********************
            // *** Fn TOP STATE ***
            // ********************

            // at the top of the body of the fn file.
            // we read both fn and imports here, even though imports are supposed to be at the top.
            case ISI_TOP: {
                input.backup(1);
                if (readString("fn")) {
                    return keywordOrError(FnTokenId.FN, ISA_FN);
                } else if (readString("import")) {
                    return keywordOrError(FnTokenId.IMPORT, ISA_IMPORT_1);
                } else if (readString("description")) {
                    return keywordOrError(FnTokenId.DESCRIPTION, ISA_DESCRIPTION_1);
                } else {
                    return finishError(ISI_TOP);
                }
            }

            // after "import"
            // read import.name
            case ISA_IMPORT_1: {
                return finishDottedName(c, ISA_IMPORT_2);
            }

            // after "import import.name"
            // may trail with a ".", but still need to allow for a "*"
            // we do a horrendously bad thing here and recognize arbitrary *'s
            case ISA_IMPORT_2: {
                if (c == '*') {
                    return token(FnTokenId.SYMBOL);
                } else if (c == ';') {
                    state = ISI_TOP;
                    return token(FnTokenId.SYMBOL);
                } else {
                    return token(FnTokenId.ERROR);
                }
            }

            case ISA_DESCRIPTION_1: {
                if (c == ';') {
                    state = ISI_TOP;
                    return token(FnTokenId.SYMBOL);
                } else {
                    input.backup(1);
                    state = ISA_DESCRIPTION_2;
                    return finishJavaPhrase(c, ISA_DESCRIPTION_2, ISI_TOP);
                }
            }
            
            case ISA_DESCRIPTION_2: {
                if (c == ';') {
                    state = ISI_TOP;
                    return token(FnTokenId.SYMBOL);
                } else {
                    return token(FnTokenId.ERROR);
                }
            }

            // ********************
            // *** READ Fn BODY ***
            // ********************

            // after "fn"
            // read FnName
            case ISA_FN: {
                if (Character.isJavaIdentifierStart(c)) {
                    state = ISA_FN_NAME;
                    return finishIdentifier(c, FnTokenId.NAME);
                } else {
                    return finishError(ISI_TOP);
                }
            }

            // after "fn FnName"
            // read {
            case ISA_FN_NAME: {
                if (c == '{') {
                    state = ISI_FN_BODY;
                    return token(FnTokenId.LBRACE);
                } else {
                    return finishError(ISI_TOP);
                }
            }

            // inside fn body
            case ISI_FN_BODY: {

                // our options here are the various fn elements:
                // blocks: eval, exec, init, setup
                // one-argument inputs: out, interface, slin
                // two-argument inputs: in, parameter, exin, cvar
                // meta
                // local declarations
                // or it may be a }, which ends the block.

                // test for the end case first, since the rest are liable to be 
                if (c == '}') {
                    state = ISI_TOP;
                    return token(FnTokenId.RBRACE);
                }

                // go through and check each of the keywords we might find.
                input.backup(1);
                FnTokenId token = null;

                // check blocks.
                if (readString("eval")) {
                    token = FnTokenId.EVAL;
                } else if (readString("exec")) {
                    token = FnTokenId.EXEC;
                } else if (readString("init")) {
                    token = FnTokenId.INIT;
                } else if (readString("setup")) {
                    token = FnTokenId.SETUP;
                }

                // check to see if we've found our token yet
                if (token != null) {
                    state = ISA_FN_BLOCK_KEYWORD_1;
                    return token(token);
                }

                // check one and two argument elements
                // just call these phrases, and let the Java Lexer handle the rest.
                if (readString("interface")) {
                    token = FnTokenId.INTERFACE;
                } else if (readString("in")) {
                    token = FnTokenId.IN;
                } else if (readString("parameter")) {
                    token = FnTokenId.PARAMETER;
                } else if (readString("exin")) {
                    token = FnTokenId.EXIN;
                } else if (readString("cvar")) {
                    token = FnTokenId.CVAR;
                } else if (readString("fout")) {
                    token = FnTokenId.OUT;
                } else if (readString("slin")) {
                    token = FnTokenId.SLIN;
                } else if (readString("meta")) {
                    token = FnTokenId.META;
                } else if (readString("description")) {
                    token = FnTokenId.DESCRIPTION;
                }

                // check to see if we've found our token yet
                if (token != null) {
                    // do a peek to make sure there's nothing after this.
                    //c = input.read();
                    //if(!Character.isWhitespace(c))
                    //    return finishError(c, state);

                    // no error character
                    //input.backup(1);

                    state = ISA_FN_PHRASE_KEYWORD_1;
                    return token(token);
                }

                // if nothing else has been satisfied, assume local java
                //return finishError(ISI_FN_BODY);
                return finishLocalJava();
            }

            // after "eval" or other fn block
            case ISA_FN_BLOCK_KEYWORD_1: {
                if (c == '{') {
                    state = ISA_FN_BLOCK_KEYWORD_2;
                    return token(FnTokenId.LBRACE);
                } else {
                    return token(FnTokenId.ERROR);
                }
            }

            // after "eval {" or other fn block
            case ISA_FN_BLOCK_KEYWORD_2: {
                return finishJavaBlock(c, ISA_FN_BLOCK_KEYWORD_3, ISI_FN_BODY);
            }

            case ISA_FN_BLOCK_KEYWORD_3: {
                if (c == '}') {
                    state = ISI_FN_BODY;
                    return token(FnTokenId.RBRACE);
                } else {
                    return token(FnTokenId.ERROR);
                }
            }

            case ISA_FN_PHRASE_KEYWORD_1: {
                return finishJavaPhrase(c, ISA_FN_PHRASE_KEYWORD_2, ISI_FN_BODY);
            }

            case ISA_FN_PHRASE_KEYWORD_2: {
                if (c == ';') {
                    state = ISI_FN_BODY;
                    return token(FnTokenId.SYMBOL);
                } else {
                    return token(FnTokenId.ERROR);
                }
            }

        }
        return null;
    }

    /**
     * Read a java block, starting with the character c.
     * @param c
     * @param stateAfter state to transition to after finishing the block
     * @param stateOnClose state to transition to if the block is empty, ie {}
     * @return
     */
    private Token<FnTokenId> finishJavaBlock(int c, int stateAfter, int stateOnClose) {
        int braceCount = 0;
        while (true) {
            if (c == '{') {
                braceCount++;
            }
            if (c == '}') {
                if (braceCount == 0) {
                    if (input.readLength() > 1) {
                        input.backup(1);
                        state = stateAfter;
                        return token(FnTokenId.JAVA_BLOCK);
                    } else {
                        // we have received a }, but the contents of the block is empty
                        state = stateOnClose;
                        return token(FnTokenId.RBRACE);
                    }
                }
                braceCount--;
            }
            if (c == EOF) {
                input.backup(1);
                state = stateAfter;
                return token(FnTokenId.JAVA_BLOCK);
            }
            c = input.read();
        }
    }

    /**
     * This is a simple approach to handling java input sections.
     * A phrase is simply a sequence of Java tokens followed by a semicolon.
     * @param c
     * @param stateAfter the state to transition to after finishing the phrase.
     * @param stateOnClose the state to transition to if the phrase is empty.
     * @return
     */
    private Token<FnTokenId> finishJavaPhrase(int c, int stateAfter, int stateOnClose) {
        while (true) {
            if (c == ';') {
                if (input.readLength() > 1) {
                    input.backup(1);
                    state = stateAfter;
                    return token(FnTokenId.JAVA_PHRASE);
                } else {
                    state = stateOnClose;
                    return token(FnTokenId.SYMBOL);
                }
            }
            if (c == EOF) {
                input.backup(1);
                state = stateAfter;
                return token(FnTokenId.JAVA_BLOCK);
            }
            c = input.read();
        }
    }

    private Token<FnTokenId> finishLocalJava() {
        int braceCount1 = 0; // {
        int braceCount2 = 0; // [
        int braceCount3 = 0; // (

        while (true) {
            int c = input.read();
            if (c == '{') {
                braceCount1++;
            } else if (c == '[') {
                braceCount2++;
            } else if (c == '(') {
                braceCount3++;
            }

            boolean potentialEndFound = false;
            if (c == '}') {
                potentialEndFound = true;
                braceCount1--;
            } else if (c == ']') {
                braceCount2--;
            }
            if (c == ')') {
                braceCount3--;
            }
            if (c == ';') {
                potentialEndFound = true;
            }

            if (potentialEndFound) {
                if (braceCount1 == 0 && braceCount2 == 0 && braceCount3 == 0) {
                    // braces are done, we should be in the clear.
                    return token(FnTokenId.JAVA_LOCAL);
                }
            }

            if (c == EOF) {
                input.backup(1);
                return token(FnTokenId.JAVA_LOCAL);
            }
        }
    }

    /**
     * The input has read a //, so we finish the rest of the comment
     * @return
     */
    private Token<FnTokenId> finishLineComment() {
        while (true) {
            int c = input.read();
            if (c == EOF || c == '\n') {
                input.backup(1);

                return tokenFactory.createToken(FnTokenId.COMMENT);
            }
        }
    }

    /**
     * The input has read a /*, so we finish the rest of the block comment
     * @return
     */
    private Token<FnTokenId> finishBlockComment() {
        boolean haveStar = false;
        while (true) {
            int c = input.read();
            if (c == '*') {
                haveStar = true;
            } else if (c == '/' && haveStar) {
                return tokenFactory.createToken(FnTokenId.COMMENT);
            } else {
                haveStar = false;
            }

            if (c == EOF) {
                input.backup(1);
                return tokenFactory.createToken(FnTokenId.COMMENT);
            }
        }
    }

    /**
     * Returns true if the string has been read. The string may still be part of
     * an additional identifier or something.
     * @param s
     * @return
     */
    private boolean readString(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (input.read() != s.charAt(i)) {
                input.backup(input.readLength());
                return false;
            }
        }
        return true;
    }

    /**
     * Read a java style name- that is a sequence of identifiers connected by dots.
     * Also assigns the state to afterState
     * @param c
     * @param afterState the state to transition to after finishing.
     */
    private Token<FnTokenId> finishDottedName(int c, int afterState) {
        if (!Character.isJavaIdentifierPart(c) && c != '.') {
            return tokenFactory.createToken(FnTokenId.ERROR);
        }

        while (true) {
            if (c == EOF ||
                    (!Character.isJavaIdentifierPart(c = translateSurrogates(c)) &&
                    c != '.')) {
                // For surrogate 2 chars must be backed up
                input.backup((c >= Character.MIN_SUPPLEMENTARY_CODE_POINT) ? 2 : 1);
                state = afterState;
                return tokenFactory.createToken(FnTokenId.IDENTIFIER);
            }
            c = input.read();
        }
    }

    /**
     * Returns a token denoting a keyword. If the keyword is not read, then the rest of the line
     * is marked as an error, but the current state is maintained.
     * @param keywordId the keyword we are trying to match
     * @param stateKeyword the state to transition to after the keyword is found.
     * @param stateError the state to transition to after the error, if the keyword is not found.
     * @return
     */
    private Token<FnTokenId> keywordOrError(FnTokenId keywordId, int stateKeyword) {
        return keywordOrError(keywordId, input.read(), stateKeyword, -1);
    }

    /**
     * Returns a token denoting a keyword, or goes into the error state.
     * @param keywordId the keyword we are trying to match
     * @param stateKeyword the state to transition to after the keyword is found.
     * @param stateError the state to transition to after the error, if the keyword is not found.
     * @return
     */
    private Token<FnTokenId> keywordOrError(FnTokenId keywordId, int stateKeyword, int stateError) {
        return keywordOrError(keywordId, input.read(), stateKeyword, stateError);
    }

    /**
     * Returns a token denoting a keyword, or goes into the error state.
     * @param keywordId the keyword we are trying to match
     * @param c the first character of the keyword
     * @param stateKeyword the state to transition to after the keyword is found.
     * @param stateError the state to transition to after the error, if the keyword is not found.
     * @return
     */
    private Token<FnTokenId> keywordOrError(FnTokenId keywordId, int c, int stateKeyword, int stateError) {
        // Check whether the given char is non-ident and if so then return keyword
        if (c == EOF || !Character.isJavaIdentifierPart(c = translateSurrogates(c))) {
            // For surrogate 2 chars must be backed up
            input.backup((c >= Character.MIN_SUPPLEMENTARY_CODE_POINT) ? 2 : 1);
            state = stateKeyword;
            return token(keywordId);
        } else // c is identifier part
        {
            return finishError(stateError);
        }
    }

    /*private Token<FnTokenId> keywordOrIdentifier(FnTokenId keywordId) {
    return keywordOrIdentifier(keywordId, input.read());
    }
    private Token<FnTokenId> keywordOrIdentifier(FnTokenId keywordId, int c) {
    // Check whether the given char is non-ident and if so then return keyword
    if (c == EOF || !Character.isJavaIdentifierPart(c = translateSurrogates(c))) {
    // For surrogate 2 chars must be backed up
    input.backup((c >= Character.MIN_SUPPLEMENTARY_CODE_POINT) ? 2 : 1);
    return token(keywordId);
    } else // c is identifier part
    {
    return finishIdentifier();
    }
    }*/
    /**
     * Reads to the end of the line, and then returns a token that denotes an error.
     * @param stateError
     * @return
     */
    private Token<FnTokenId> finishError(int stateError) {
        return finishError(input.read(), stateError);
    }

    /**
     * Reads to the end of the line, and then returns a token that denotes an error.
     * The entire rest of the line is made to represent the error. Ideally, we would
     * want to only read until the error logically ended, but that is hard to do.
     * @param c the first character of the error.
     * @param stateError state to go to when the error is finished. If stateError
     *        is negative, the current state is still used.
     * @return
     */
    private Token<FnTokenId> finishError(int c, int stateError) {
        while (true) {
            if (c == EOF || c == '\n') {
                input.backup(1);

                if (stateError > 0) {
                    state = stateError;
                }
                return tokenFactory.createToken(FnTokenId.ERROR);
            }
            c = input.read();
        }
    }

    /**
     * Reads a sequence of characters and returns a token representing an identifier.
     * @return
     */
    private Token<FnTokenId> finishIdentifier() {
        return finishIdentifier(input.read());
    }

    /**
     * Reads a sequence of characters and returns a token representing an identifier.
     * Will return an error if it encounters a character that is not a valid identifier part.
     * We leave the state the same, so the identifier may still be read.
     * @param c the first character in the identifier.
     * @return
     */
    private Token<FnTokenId> finishIdentifier(int c) {
        return finishIdentifier(c, FnTokenId.IDENTIFIER);
    }

    /**
     * Reads a sequence of characters and returns a token representing an identifier.
     * Will return an error if it encounters a character that is not a valid identifier part.
     * We leave the state the same, so the identifier may still be read.
     * @param c the first character in the identifier.
     * @param identifierTokenId the tokenId type for the identifier.
     * @return
     */
    private Token<FnTokenId> finishIdentifier(int c, FnTokenId identifierTokenId) {
        if (!Character.isJavaIdentifierPart(c)) {
            return tokenFactory.createToken(FnTokenId.ERROR);
        }

        while (true) {
            if (c == EOF || !Character.isJavaIdentifierPart(c = translateSurrogates(c))) {
                // For surrogate 2 chars must be backed up
                input.backup((c >= Character.MIN_SUPPLEMENTARY_CODE_POINT) ? 2 : 1);
                return tokenFactory.createToken(identifierTokenId);
            }
            c = input.read();
        }
    }

    /**
     * This consumes all whitespace and then returns a whitespace token.
     * @return
     */
    private Token<FnTokenId> finishWhitespace() {
        while (true) {
            int c = input.read();
            if (!Character.isWhitespace(c)) {
                input.backup(1);
                return token(FnTokenId.WHITESPACE);
            }
        }
    }

    /**
     * Helper method to return a token from a token id.
     * @param id
     * @return
     */
    private Token<FnTokenId> token(FnTokenId id) {
        return tokenFactory.createToken(id);
    }

    /**
     * I'm honestly not sure what this function does. I think it does special 
     * handling for surrogate chars.
     * @param c
     * @return
     */
    private int translateSurrogates(int c) {
        if (Character.isHighSurrogate((char) c)) {
            int lowSurr = input.read();
            if (lowSurr != EOF && Character.isLowSurrogate((char) lowSurr)) {
                // c and lowSurr form the integer unicode char.
                c = Character.toCodePoint((char) c, (char) lowSurr);
            } else {
                // Otherwise it's error: Low surrogate does not follow the high one.
                // Leave the original character unchanged.
                // As the surrogates do not belong to any
                // specific unicode category the lexer should finally
                // categorize them as a lexical error.
                input.backup(1);
            }
        }
        return c;
    }

    /**
     * Returns the current state of the lexer.
     * @return
     */
    public Object state() {
        return state;
    }

    public void release() {
    }
}
