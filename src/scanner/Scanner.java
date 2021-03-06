/* The following code was generated by JFlex 1.6.1 */

package scanner;

import java_cup.runtime.*;
import parser.sym;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/scanner/Lexer.flex</tt>
 */
public class Scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\6\1\10\1\50\1\50\1\7\22\0\1\6\2\0\1\52"+
    "\1\0\1\47\2\0\1\61\1\62\1\55\1\53\1\74\1\54\1\0"+
    "\1\51\1\3\11\4\1\57\1\73\1\0\1\60\3\0\3\2\1\37"+
    "\1\25\1\15\1\72\1\21\1\13\2\2\1\23\1\2\1\27\1\35"+
    "\1\2\1\70\1\44\1\42\1\31\1\46\1\33\1\17\3\2\1\63"+
    "\1\0\1\64\1\56\1\5\1\0\3\1\1\36\1\24\1\14\1\71"+
    "\1\20\1\12\2\1\1\22\1\1\1\26\1\34\1\1\1\67\1\43"+
    "\1\41\1\30\1\45\1\32\1\16\3\1\1\65\1\0\1\66\7\0"+
    "\1\50\252\0\2\11\115\0\1\40\u1ea8\0\1\50\1\50\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\2\4\1\1\2\2\1\1"+
    "\1\2\1\1\1\2\1\1\1\2\1\1\1\2\1\1"+
    "\1\2\1\1\1\2\1\1\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\1\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\2\1\1\1\21\1\22\3\2\1\23\1\0"+
    "\1\23\2\2\1\0\1\2\1\0\1\2\1\24\1\0"+
    "\1\24\1\2\1\25\1\0\1\25\1\2\1\0\1\2"+
    "\1\0\1\2\2\0\1\26\1\0\1\2\1\27\1\0"+
    "\1\27\2\30\2\31\1\0\1\2\2\32\1\0\1\2"+
    "\2\33\1\0\2\2\2\0\1\34\2\35\1\0\1\2"+
    "\2\36\2\37\1\2\1\0\1\5\1\0\2\40\1\2"+
    "\1\0\2\41";

  private static int [] zzUnpackAction() {
    int [] result = new int[108];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\75\0\172\0\75\0\267\0\75\0\364\0\u0131"+
    "\0\u016e\0\u01ab\0\u01e8\0\u0225\0\u0262\0\u029f\0\u02dc\0\u0319"+
    "\0\u0356\0\u0393\0\u03d0\0\u040d\0\u044a\0\u0487\0\u04c4\0\u0501"+
    "\0\u053e\0\75\0\75\0\u057b\0\75\0\u05b8\0\75\0\75"+
    "\0\75\0\75\0\75\0\75\0\u05f5\0\u0632\0\75\0\75"+
    "\0\75\0\u066f\0\u06ac\0\75\0\u06e9\0\172\0\u0726\0\u0763"+
    "\0\u07a0\0\u07dd\0\u081a\0\u0857\0\172\0\u0894\0\75\0\u08d1"+
    "\0\172\0\u090e\0\75\0\u094b\0\u0988\0\u09c5\0\u0a02\0\u0a3f"+
    "\0\u0a7c\0\u0ab9\0\75\0\u0af6\0\u0b33\0\172\0\u0b70\0\75"+
    "\0\75\0\172\0\172\0\75\0\u0bad\0\u0bea\0\172\0\75"+
    "\0\u0c27\0\u0c64\0\172\0\75\0\u0ca1\0\u0cde\0\u0d1b\0\u0d58"+
    "\0\u0d95\0\75\0\172\0\75\0\u0dd2\0\u0e0f\0\75\0\172"+
    "\0\75\0\172\0\u0e4c\0\u0e89\0\75\0\u0ec6\0\75\0\172"+
    "\0\u0f03\0\u0f40\0\172\0\75";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[108];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\2\1\4\1\5\1\2\1\6\1\7"+
    "\1\6\1\10\1\11\1\10\1\12\1\13\1\14\1\15"+
    "\1\3\1\2\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\3\1\2\1\24\1\25\1\3\1\2\1\3\2\2"+
    "\1\3\1\2\1\26\1\27\1\3\1\2\1\30\1\0"+
    "\1\31\1\2\1\32\1\33\1\34\1\35\1\36\1\2"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\3\1\2"+
    "\1\45\1\46\1\47\1\50\76\0\2\3\1\51\1\52"+
    "\1\53\4\0\26\3\1\0\6\3\20\0\4\3\5\0"+
    "\2\5\100\0\1\6\100\0\2\54\10\0\2\55\46\0"+
    "\2\3\1\51\1\52\1\53\4\0\2\3\2\56\10\3"+
    "\2\57\10\3\1\0\6\3\20\0\4\3\3\0\2\3"+
    "\1\51\1\52\1\53\4\0\22\3\2\60\2\3\1\0"+
    "\6\3\20\0\4\3\36\0\2\61\40\0\2\3\1\51"+
    "\1\52\1\53\4\0\6\3\2\62\16\3\1\0\6\3"+
    "\20\0\4\3\22\0\2\63\54\0\2\3\1\51\1\52"+
    "\1\53\4\0\12\3\2\64\2\3\2\65\6\3\1\0"+
    "\6\3\20\0\4\3\26\0\2\66\2\0\2\67\44\0"+
    "\2\3\1\51\1\52\1\53\4\0\10\3\2\70\14\3"+
    "\1\0\6\3\20\0\2\71\2\3\24\0\2\72\43\0"+
    "\2\73\5\0\2\3\1\51\1\52\1\53\4\0\12\3"+
    "\2\74\12\3\1\0\6\3\20\0\4\3\26\0\2\75"+
    "\50\0\2\3\1\51\1\52\1\53\4\0\22\3\2\76"+
    "\2\3\1\0\6\3\20\0\4\3\36\0\2\77\40\0"+
    "\2\3\1\51\1\52\1\53\4\0\12\3\2\100\12\3"+
    "\1\0\6\3\20\0\4\3\26\0\2\101\47\0\7\30"+
    "\2\0\37\30\1\0\24\30\52\0\1\102\77\0\1\103"+
    "\76\0\1\104\16\0\2\3\1\51\1\52\1\53\4\0"+
    "\12\3\2\105\2\3\2\106\6\3\1\0\6\3\20\0"+
    "\4\3\26\0\2\107\2\0\2\110\46\0\2\52\71\0"+
    "\2\53\1\51\1\52\5\0\26\53\1\0\6\53\20\0"+
    "\4\53\32\0\2\111\44\0\2\3\1\51\1\52\1\53"+
    "\4\0\16\3\2\112\6\3\1\0\6\3\20\0\4\3"+
    "\3\0\2\3\1\51\1\52\1\53\4\0\26\3\1\0"+
    "\2\3\2\113\2\3\20\0\4\3\45\0\2\114\31\0"+
    "\2\3\1\51\1\52\1\53\3\0\1\115\2\116\24\3"+
    "\1\0\6\3\20\0\4\3\13\0\3\115\62\0\2\3"+
    "\1\51\1\52\1\53\4\0\26\3\1\0\6\3\20\0"+
    "\2\117\2\3\71\0\2\120\5\0\2\3\1\51\1\52"+
    "\1\53\4\0\26\3\1\121\2\122\4\3\20\0\4\3"+
    "\42\0\3\121\33\0\2\3\1\51\1\52\1\53\4\0"+
    "\26\3\1\0\6\3\20\0\2\123\2\3\71\0\2\124"+
    "\5\0\2\3\1\51\1\52\1\53\3\0\1\125\2\126"+
    "\24\3\1\0\6\3\20\0\4\3\13\0\3\125\62\0"+
    "\2\3\1\51\1\52\1\53\4\0\16\3\2\127\6\3"+
    "\1\0\6\3\20\0\4\3\32\0\2\130\43\0\52\102"+
    "\1\131\22\102\60\0\1\132\15\0\2\3\1\51\1\52"+
    "\1\53\4\0\26\3\1\0\6\3\20\0\2\133\2\3"+
    "\71\0\2\134\26\0\2\135\52\0\2\3\1\51\1\52"+
    "\1\53\4\0\10\3\2\136\14\3\1\0\6\3\20\0"+
    "\4\3\26\0\2\137\50\0\2\3\1\51\1\52\1\53"+
    "\4\0\12\3\2\140\12\3\1\0\6\3\20\0\4\3"+
    "\40\0\2\141\36\0\2\3\1\51\1\52\1\53\4\0"+
    "\24\3\2\142\1\0\6\3\20\0\4\3\3\0\2\3"+
    "\1\51\1\52\1\53\4\0\26\3\1\0\4\3\2\143"+
    "\20\0\4\3\47\0\2\144\26\0\51\102\1\145\1\146"+
    "\22\102\24\0\2\147\50\0\2\3\1\51\1\52\1\53"+
    "\4\0\12\3\2\150\12\3\1\0\6\3\20\0\4\3"+
    "\3\0\2\3\1\51\1\52\1\53\4\0\26\3\1\0"+
    "\2\3\2\151\2\3\20\0\4\3\45\0\2\152\30\0"+
    "\51\102\1\0\1\146\22\102\1\0\2\3\1\51\1\52"+
    "\1\53\4\0\14\3\2\153\10\3\1\0\6\3\20\0"+
    "\4\3\30\0\2\154\45\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3965];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\1\1\1\11\23\1\2\11"+
    "\1\1\1\11\1\1\6\11\2\1\3\11\2\1\1\11"+
    "\1\0\3\1\1\0\1\1\1\0\2\1\1\0\1\11"+
    "\2\1\1\0\1\11\1\1\1\0\1\1\1\0\1\1"+
    "\2\0\1\11\1\0\2\1\1\0\2\11\2\1\1\11"+
    "\1\0\2\1\1\11\1\0\2\1\1\11\1\0\2\1"+
    "\2\0\1\11\1\1\1\11\1\0\1\1\1\11\1\1"+
    "\1\11\2\1\1\0\1\11\1\0\1\11\2\1\1\0"+
    "\1\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[108];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    /* Se retorna el simbolo encontrado*/
    public Symbol symbol(int tipoToken){
        return new Symbol(tipoToken, yyline, yycolumn);
    }
    /* Se retorna el simbolo y su valor*/
    public Symbol symbol(int tipoToken, Object objetoToken){
        return new Symbol(tipoToken, yyline, yycolumn, objetoToken);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 210) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
        System.out.println("Final de archivo -> Lexer");
  yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
            switch (zzLexicalState) {
            case YYINITIAL: {
              return symbol(sym.EOF);
            }
            case 109: break;
            default:
          {     System.out.println("eofval -> Lexer");
    return new Symbol(sym.EOF, null);
 }
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new Error("Caracter ilegal <"+yytext()+">");
            }
          case 34: break;
          case 2: 
            { return new Symbol(sym.ID,yyline, yycolumn,yytext());
            }
          case 35: break;
          case 3: 
            { return new Symbol(sym.NUM,yyline, yycolumn,new Integer(yytext()));
            }
          case 36: break;
          case 4: 
            { /*return symbol(sym.NEWLINE);*/
            }
          case 37: break;
          case 5: 
            { /*Ignore*/
            }
          case 38: break;
          case 6: 
            { return symbol(sym.DIV);
            }
          case 39: break;
          case 7: 
            { return symbol(sym.SUMA);
            }
          case 40: break;
          case 8: 
            { return symbol(sym.RESTA);
            }
          case 41: break;
          case 9: 
            { return symbol(sym.MULT);
            }
          case 42: break;
          case 10: 
            { return symbol(sym.EXPO2);
            }
          case 43: break;
          case 11: 
            { return symbol(sym.LCIRCLEB);
            }
          case 44: break;
          case 12: 
            { return symbol(sym.RCIRCLEB);
            }
          case 45: break;
          case 13: 
            { return symbol(sym.LSQUAREB);
            }
          case 46: break;
          case 14: 
            { return symbol(sym.RSQUAREB);
            }
          case 47: break;
          case 15: 
            { return symbol(sym.LCURLYB);
            }
          case 48: break;
          case 16: 
            { return symbol(sym.RCURLYB);
            }
          case 49: break;
          case 17: 
            { return symbol(sym.SEMICOLON);
            }
          case 50: break;
          case 18: 
            { return symbol(sym.COMMA);
            }
          case 51: break;
          case 19: 
            { return symbol(sym.IF);
            }
          case 52: break;
          case 20: 
            { return symbol(sym.LT);
            }
          case 53: break;
          case 21: 
            { return symbol(sym.EQ);
            }
          case 54: break;
          case 22: 
            { return symbol(sym.EXPO1);
            }
          case 55: break;
          case 23: 
            { return symbol(sym.GT);
            }
          case 56: break;
          case 24: 
            { return symbol(sym.INT);
            }
          case 57: break;
          case 25: 
            { return symbol(sym.FOR);
            }
          case 58: break;
          case 26: 
            { return symbol(sym.LEQ);
            }
          case 59: break;
          case 27: 
            { return symbol(sym.NEQ);
            }
          case 60: break;
          case 28: 
            { return symbol(sym.ASSIGN);
            }
          case 61: break;
          case 29: 
            { return symbol(sym.GEQ);
            }
          case 62: break;
          case 30: 
            { return symbol(sym.ELSE);
            }
          case 63: break;
          case 31: 
            { return symbol(sym.VOID);
            }
          case 64: break;
          case 32: 
            { return symbol(sym.WHILE);
            }
          case 65: break;
          case 33: 
            { return symbol(sym.RETURN);
            }
          case 66: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
