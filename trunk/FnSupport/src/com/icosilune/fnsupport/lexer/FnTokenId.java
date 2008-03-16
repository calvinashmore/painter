/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.lexer;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import org.netbeans.api.java.lexer.JavaTokenId;
import org.netbeans.api.lexer.InputAttributes;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.LanguagePath;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.spi.lexer.LanguageEmbedding;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author Calvin Ashmore
 */
public enum FnTokenId implements TokenId {

    FN("fnkeyword"),
    PACKAGE("fnkeyword"),
    GROUP("fnkeyword"),
    TYPE("fnkeyword"),
    TYPE_VALUE("fnkeyword"), // either Expression, Statement, Command, or Accessor
    IMPORT("fnkeyword"),
    IN("fnkeyword"),
    OUT("fnkeyword"),
    EVAL("fnkeyword"),
    EXEC("fnkeyword"),
    INIT("fnkeyword"),
    SETUP("fnkeyword"),
    PARAMETER("fnkeyword"),
    INTERFACE("fnkeyword"),
    META("fnkeyword"),
    SLIN("fnkeyword"),
    EXIN("fnkeyword"),
    CVAR("fnkeyword"),
    LBRACE("symbol"), // {
    RBRACE("symbol"), // }
    SYMBOL("symbol"),
    ERROR("error"),
    COMMENT("comment"),
    WHITESPACE("whitespace"),
    IDENTIFIER(null),
    NAME(null),
    //JAVA_NAME(null),
    //JAVA_EXPRESSION(null),
    //JAVA_TYPE(null),
    JAVA_BLOCK(null),
    JAVA_LOCAL(null),
    JAVA_PHRASE(null);

    private FnTokenId(String primaryCategory) {
        this.primaryCategory = primaryCategory;
    }
    private String primaryCategory;

    public String primaryCategory() {
        return primaryCategory;
    }
    private static final Language<FnTokenId> language = new LanguageHierarchy<FnTokenId>() {

        @Override
        protected Collection<FnTokenId> createTokenIds() {
            return EnumSet.allOf(FnTokenId.class);
        }

        @Override
        protected Lexer<FnTokenId> createLexer(LexerRestartInfo info) {
            return new FnLexer(info);
        }

        @Override
        protected String mimeType() {
            return "text/x-fn";
        }

        @Override
        protected Map<String, Collection<FnTokenId>> createTokenCategories() {
            return super.createTokenCategories();
        }

        @Override
        protected LanguageEmbedding<?> embedding(Token<FnTokenId> token, LanguagePath languagePath, InputAttributes inputAttributes) {
            //return super.embedding(token, languagePath, inputAttributes);
            switch (token.id()) {
                //case JAVA_NAME:
                //case JAVA_EXPRESSION:
                //case JAVA_TYPE:
                case JAVA_LOCAL:
                case JAVA_BLOCK:
                case JAVA_PHRASE:
                    return LanguageEmbedding.create(JavaTokenId.language(), 0, 0, true);
                default:
                    return null;
            }
        }
    }.language();

    public static Language<FnTokenId> language() {
        return language;
    }
}
