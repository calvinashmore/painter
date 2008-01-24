/*
 * FnParseNode.java
 *
 * Created on December 31, 2005, 2:45 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package fn.parser;

public class FnParseNode extends SimpleNode {
    public Token firstToken, lastToken;

    public FnParseNode(int i) {
        super(i);
    }

    public FnParseNode(FnParser p, int i) {
        super(p,i);
    }
    
    /* Public get accessors for getting the first and last source line
       numbers and columns subsumed by this node. */
    public int getFirstLineNumber() {
	return firstToken.beginLine;
    }

    public int getLastLineNumber() {
	return lastToken.endLine;
    }

    public int getFirstColumn() {
	return firstToken.beginColumn;
    }

    public int getLastColumn() {
	return lastToken.endColumn;
    }
    
    // Dumps the tokens matched while this node was open. 
    public String dumpTokens() {
	StringBuffer image = new StringBuffer(); 
	Token currentToken;
	for(currentToken = firstToken; currentToken != lastToken; currentToken = currentToken.next) {
	    image.append(currentToken.image);
            image.append(" ");
	}
	image.append(currentToken.image); // Add the last token to the image to return. 
	return image.toString();
    }
    
    public String dumpBlock() {
	StringBuffer image = new StringBuffer(); 
	Token currentToken;
        // first to last exclusive, ignore "{" "}"
        if(firstToken.next == lastToken)
            return "";
	for(    currentToken = firstToken.next; 
                currentToken.next != lastToken; 
                currentToken = currentToken.next) {
            image.append(currentToken.image);
            image.append(" ");
        }
	image.append(currentToken.image); // Add the last token to the image to return. 
	return image.toString();
    }
    
    // Returns the number of tokens matched by this parse node. 
    public int numberOfTokens() {
	Token currentToken;
	int tokenCount = 0;

	for(currentToken = firstToken; currentToken != lastToken; currentToken = currentToken.next) {
	    tokenCount++;
	}
	return ++tokenCount;
    }

    // Dumps the matched tokens in the range first to last. The
    // returned string contains the token images starting with token
    // first and extending to token last - 1. The token index starts at 0.
    public String dumpTokens(int first, int last) {
	StringBuffer image = new StringBuffer();
	Token currentToken;
	int tokenCounter = 0;

	assert (last <= numberOfTokens());
	assert (last >= 1);
	assert (first >= 0);
	assert (first < last);

	// Skip over tokens until you get to first.
	for(currentToken = firstToken; tokenCounter != first; currentToken = currentToken.next) {
	    tokenCounter++;
	}

	/* Store images of tokens between index first and last. Leave
           loop if we hit lastToken before hitting index last. */
	while(tokenCounter < last) {
	    image.append(currentToken.image);
	    currentToken = currentToken.next;
	    tokenCounter++;
	}

	return image.toString();
    }
}
