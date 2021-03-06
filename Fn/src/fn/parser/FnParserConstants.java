/* Generated By:JJTree&JavaCC: Do not edit this line. FnParserConstants.java */
package fn.parser;

public interface FnParserConstants {

  int EOF = 0;
  int SINGLE_LINE_COMMENT = 9;
  int FORMAL_COMMENT = 10;
  int MULTI_LINE_COMMENT = 11;
  int ABSTRACT = 13;
  int ASSERT = 14;
  int BOOLEAN = 15;
  int BREAK = 16;
  int BYTE = 17;
  int CASE = 18;
  int CATCH = 19;
  int CHAR = 20;
  int CLASS = 21;
  int CONST = 22;
  int CONTINUE = 23;
  int _DEFAULT = 24;
  int DO = 25;
  int DOUBLE = 26;
  int ELSE = 27;
  int ENUM = 28;
  int EXTENDS = 29;
  int FALSE = 30;
  int FINAL = 31;
  int FINALLY = 32;
  int FLOAT = 33;
  int FOR = 34;
  int GOTO = 35;
  int IF = 36;
  int IMPLEMENTS = 37;
  int IMPORT = 38;
  int INSTANCEOF = 39;
  int INT = 40;
  int INTERFACE = 41;
  int LONG = 42;
  int NATIVE = 43;
  int NEW = 44;
  int NULL = 45;
  int PACKAGE = 46;
  int PRIVATE = 47;
  int PROTECTED = 48;
  int PUBLIC = 49;
  int RETURN = 50;
  int SHORT = 51;
  int STATIC = 52;
  int STRICTFP = 53;
  int SUPER = 54;
  int SWITCH = 55;
  int SYNCHRONIZED = 56;
  int THIS = 57;
  int THROW = 58;
  int THROWS = 59;
  int TRANSIENT = 60;
  int TRUE = 61;
  int TRY = 62;
  int VOID = 63;
  int VOLATILE = 64;
  int WHILE = 65;
  int FN = 66;
  int GROUP = 67;
  int TYPE = 68;
  int IN = 69;
  int OUT = 70;
  int EVAL = 71;
  int EXEC = 72;
  int INIT = 73;
  int PARAMETER = 74;
  int SETUP = 75;
  int META = 76;
  int SLIN = 77;
  int EXIN = 78;
  int CVAR = 79;
  int DESCRIPTION = 80;
  int INTEGER_LITERAL = 81;
  int DECIMAL_LITERAL = 82;
  int HEX_LITERAL = 83;
  int OCTAL_LITERAL = 84;
  int FLOATING_POINT_LITERAL = 85;
  int EXPONENT = 86;
  int CHARACTER_LITERAL = 87;
  int STRING_LITERAL = 88;
  int IDENTIFIER = 89;
  int LETTER = 90;
  int DIGIT = 91;
  int LPAREN = 92;
  int RPAREN = 93;
  int LBRACE = 94;
  int RBRACE = 95;
  int LBRACKET = 96;
  int RBRACKET = 97;
  int SEMICOLON = 98;
  int COMMA = 99;
  int DOT = 100;
  int AT = 101;
  int ASSIGN = 102;
  int LT = 103;
  int BANG = 104;
  int TILDE = 105;
  int HOOK = 106;
  int COLON = 107;
  int EQ = 108;
  int LE = 109;
  int GE = 110;
  int NE = 111;
  int SC_OR = 112;
  int SC_AND = 113;
  int INCR = 114;
  int DECR = 115;
  int PLUS = 116;
  int MINUS = 117;
  int STAR = 118;
  int SLASH = 119;
  int BIT_AND = 120;
  int BIT_OR = 121;
  int XOR = 122;
  int REM = 123;
  int LSHIFT = 124;
  int PLUSASSIGN = 125;
  int MINUSASSIGN = 126;
  int STARASSIGN = 127;
  int SLASHASSIGN = 128;
  int ANDASSIGN = 129;
  int ORASSIGN = 130;
  int XORASSIGN = 131;
  int REMASSIGN = 132;
  int LSHIFTASSIGN = 133;
  int RSIGNEDSHIFTASSIGN = 134;
  int RUNSIGNEDSHIFTASSIGN = 135;
  int ELLIPSIS = 136;
  int RUNSIGNEDSHIFT = 137;
  int RSIGNEDSHIFT = 138;
  int GT = 139;

  int DEFAULT = 0;
  int IN_SINGLE_LINE_COMMENT = 1;
  int IN_FORMAL_COMMENT = 2;
  int IN_MULTI_LINE_COMMENT = 3;

  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\f\"",
    "\"//\"",
    "<token of kind 7>",
    "\"/*\"",
    "<SINGLE_LINE_COMMENT>",
    "\"*/\"",
    "\"*/\"",
    "<token of kind 12>",
    "\"abstract\"",
    "\"assert\"",
    "\"boolean\"",
    "\"break\"",
    "\"byte\"",
    "\"case\"",
    "\"catch\"",
    "\"char\"",
    "\"class\"",
    "\"const\"",
    "\"continue\"",
    "\"default\"",
    "\"do\"",
    "\"double\"",
    "\"else\"",
    "\"enum\"",
    "\"extends\"",
    "\"false\"",
    "\"final\"",
    "\"finally\"",
    "\"float\"",
    "\"for\"",
    "\"goto\"",
    "\"if\"",
    "\"implements\"",
    "\"import\"",
    "\"instanceof\"",
    "\"int\"",
    "\"interface\"",
    "\"long\"",
    "\"native\"",
    "\"new\"",
    "\"null\"",
    "\"package\"",
    "\"private\"",
    "\"protected\"",
    "\"public\"",
    "\"return\"",
    "\"short\"",
    "\"static\"",
    "\"strictfp\"",
    "\"super\"",
    "\"switch\"",
    "\"synchronized\"",
    "\"this\"",
    "\"throw\"",
    "\"throws\"",
    "\"transient\"",
    "\"true\"",
    "\"try\"",
    "\"void\"",
    "\"volatile\"",
    "\"while\"",
    "\"fn\"",
    "\"group\"",
    "\"type\"",
    "\"in\"",
    "\"fout\"",
    "\"eval\"",
    "\"exec\"",
    "\"init\"",
    "\"parameter\"",
    "\"setup\"",
    "\"meta\"",
    "\"slin\"",
    "\"exin\"",
    "\"cvar\"",
    "\"description\"",
    "<INTEGER_LITERAL>",
    "<DECIMAL_LITERAL>",
    "<HEX_LITERAL>",
    "<OCTAL_LITERAL>",
    "<FLOATING_POINT_LITERAL>",
    "<EXPONENT>",
    "<CHARACTER_LITERAL>",
    "<STRING_LITERAL>",
    "<IDENTIFIER>",
    "<LETTER>",
    "<DIGIT>",
    "\"(\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "\";\"",
    "\",\"",
    "\".\"",
    "\"@\"",
    "\"=\"",
    "\"<\"",
    "\"!\"",
    "\"~\"",
    "\"?\"",
    "\":\"",
    "\"==\"",
    "\"<=\"",
    "\">=\"",
    "\"!=\"",
    "\"||\"",
    "\"&&\"",
    "\"++\"",
    "\"--\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"&\"",
    "\"|\"",
    "\"^\"",
    "\"%\"",
    "\"<<\"",
    "\"+=\"",
    "\"-=\"",
    "\"*=\"",
    "\"/=\"",
    "\"&=\"",
    "\"|=\"",
    "\"^=\"",
    "\"%=\"",
    "\"<<=\"",
    "\">>=\"",
    "\">>>=\"",
    "\"...\"",
    "\">>>\"",
    "\">>\"",
    "\">\"",
  };

}
