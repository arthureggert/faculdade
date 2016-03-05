package br.com.ahe.cop.copilador.gals2;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import br.com.ahe.cop.utils.Utils;

@SuppressWarnings( "deprecation" )
public class Lexico implements Constants {
    
	private int position;
    private String input;
    

    public Lexico() {
        this(new StringReader(""));
    }

    public Lexico(Reader input)  {
        setInput(input);
    }

    public void setInput(Reader input){
        StringBuffer bfr = new StringBuffer();
        try {
            int c = input.read();
            while (c != -1) {
                bfr.append((char)c);
                c = input.read();
            }
            this.input = bfr.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setPosition(0);
    }

    public void setPosition(int pos) {
        this.position = pos;
    }

    public Token nextToken() throws LexicalError  {
        if ( !hasInput() ){
        	return null;
        }
        
        int start = this.position;

        int state = 0;
        int lastState = 0;
        int endState = -1;
        int end = -1;

        while (hasInput()) {
            lastState = state;
            state = nextState(nextChar(), state);

            if (state < 0){
                break;
            } else {
                if (tokenForState(state) >= 0) {
                    endState = state;
                    end = this.position;
                }
            }
        }
        if (endState < 0 || (endState != state && tokenForState(lastState) == -2)){
            throw new LexicalError(SCANNER_ERROR[lastState], start, Utils.getInstance().getLinha(start), new String(Utils.getInstance().getToken(start , this.position)) );
        }
        
        this.position = end;

        int token = tokenForState(endState);

        if (token == 0){
        	return nextToken();        	
        } else {
            String lexeme = this.input.substring(start, end);
            token = lookupToken(token, lexeme);
            return new Token(token, lexeme, start);
        }
    }

    private int nextState(char c, int state)
    {
        switch (state)
        {
            case 0:
                switch (c)
                {
                    case 9: return 1;
                    case 10: return 1;
                    case 13: return 1;
                    case 32: return 1;
                    case 33: return 2;
                    case 34: return 3;
                    case 35: return 4;
                    case 40: return 5;
                    case 41: return 6;
                    case 42: return 7;
                    case 43: return 8;
                    case 44: return 9;
                    case 45: return 10;
                    case 47: return 11;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    case 58: return 13;
                    case 59: return 14;
                    case 60: return 15;
                    case 61: return 16;
                    case 62: return 17;
                    case 91: return 18;
                    case 93: return 19;
                    case 97: return 20;
                    case 98: return 21;
                    case 99: return 20;
                    case 100: return 20;
                    case 101: return 20;
                    case 102: return 22;
                    case 103: return 20;
                    case 104: return 20;
                    case 105: return 23;
                    case 106: return 20;
                    case 107: return 20;
                    case 108: return 20;
                    case 109: return 20;
                    case 110: return 20;
                    case 111: return 20;
                    case 112: return 20;
                    case 113: return 20;
                    case 114: return 20;
                    case 115: return 24;
                    case 116: return 20;
                    case 117: return 20;
                    case 118: return 20;
                    case 119: return 20;
                    case 120: return 20;
                    case 121: return 20;
                    case 122: return 20;
                    default: return -1;
                }
            case 2:
                switch (c)
                {
                    case 61: return 25;
                    default: return -1;
                }
            case 3:
                switch (c)
                {
                    case 9: return 3;
                    case 13: return 3;
                    case 32: return 3;
                    case 33: return 3;
                    case 34: return 26;
                    case 35: return 3;
                    case 36: return 3;
                    case 37: return 3;
                    case 38: return 3;
                    case 39: return 3;
                    case 40: return 3;
                    case 41: return 3;
                    case 42: return 3;
                    case 43: return 3;
                    case 44: return 3;
                    case 45: return 3;
                    case 46: return 3;
                    case 47: return 3;
                    case 48: return 3;
                    case 49: return 3;
                    case 50: return 3;
                    case 51: return 3;
                    case 52: return 3;
                    case 53: return 3;
                    case 54: return 3;
                    case 55: return 3;
                    case 56: return 3;
                    case 57: return 3;
                    case 58: return 3;
                    case 59: return 3;
                    case 60: return 3;
                    case 61: return 3;
                    case 62: return 3;
                    case 63: return 3;
                    case 64: return 3;
                    case 65: return 3;
                    case 66: return 3;
                    case 67: return 3;
                    case 68: return 3;
                    case 69: return 3;
                    case 70: return 3;
                    case 71: return 3;
                    case 72: return 3;
                    case 73: return 3;
                    case 74: return 3;
                    case 75: return 3;
                    case 76: return 3;
                    case 77: return 3;
                    case 78: return 3;
                    case 79: return 3;
                    case 80: return 3;
                    case 81: return 3;
                    case 82: return 3;
                    case 83: return 3;
                    case 84: return 3;
                    case 85: return 3;
                    case 86: return 3;
                    case 87: return 3;
                    case 88: return 3;
                    case 89: return 3;
                    case 90: return 3;
                    case 91: return 3;
                    case 92: return 3;
                    case 93: return 3;
                    case 94: return 3;
                    case 95: return 3;
                    case 96: return 3;
                    case 97: return 3;
                    case 98: return 3;
                    case 99: return 3;
                    case 100: return 3;
                    case 101: return 3;
                    case 102: return 3;
                    case 103: return 3;
                    case 104: return 3;
                    case 105: return 3;
                    case 106: return 3;
                    case 107: return 3;
                    case 108: return 3;
                    case 109: return 3;
                    case 110: return 3;
                    case 111: return 3;
                    case 112: return 3;
                    case 113: return 3;
                    case 114: return 3;
                    case 115: return 3;
                    case 116: return 3;
                    case 117: return 3;
                    case 118: return 3;
                    case 119: return 3;
                    case 120: return 3;
                    case 121: return 3;
                    case 122: return 3;
                    case 123: return 3;
                    case 124: return 3;
                    case 125: return 3;
                    case 126: return 3;
                    case 161: return 3;
                    case 162: return 3;
                    case 163: return 3;
                    case 164: return 3;
                    case 165: return 3;
                    case 166: return 3;
                    case 167: return 3;
                    case 168: return 3;
                    case 169: return 3;
                    case 170: return 3;
                    case 171: return 3;
                    case 172: return 3;
                    case 173: return 3;
                    case 174: return 3;
                    case 175: return 3;
                    case 176: return 3;
                    case 177: return 3;
                    case 178: return 3;
                    case 179: return 3;
                    case 180: return 3;
                    case 181: return 3;
                    case 182: return 3;
                    case 183: return 3;
                    case 184: return 3;
                    case 185: return 3;
                    case 186: return 3;
                    case 187: return 3;
                    case 188: return 3;
                    case 189: return 3;
                    case 190: return 3;
                    case 191: return 3;
                    case 192: return 3;
                    case 193: return 3;
                    case 194: return 3;
                    case 195: return 3;
                    case 196: return 3;
                    case 197: return 3;
                    case 198: return 3;
                    case 199: return 3;
                    case 200: return 3;
                    case 201: return 3;
                    case 202: return 3;
                    case 203: return 3;
                    case 204: return 3;
                    case 205: return 3;
                    case 206: return 3;
                    case 207: return 3;
                    case 208: return 3;
                    case 209: return 3;
                    case 210: return 3;
                    case 211: return 3;
                    case 212: return 3;
                    case 213: return 3;
                    case 214: return 3;
                    case 215: return 3;
                    case 216: return 3;
                    case 217: return 3;
                    case 218: return 3;
                    case 219: return 3;
                    case 220: return 3;
                    case 221: return 3;
                    case 222: return 3;
                    case 223: return 3;
                    case 224: return 3;
                    case 225: return 3;
                    case 226: return 3;
                    case 227: return 3;
                    case 228: return 3;
                    case 229: return 3;
                    case 230: return 3;
                    case 231: return 3;
                    case 232: return 3;
                    case 233: return 3;
                    case 234: return 3;
                    case 235: return 3;
                    case 236: return 3;
                    case 237: return 3;
                    case 238: return 3;
                    case 239: return 3;
                    case 240: return 3;
                    case 241: return 3;
                    case 242: return 3;
                    case 243: return 3;
                    case 244: return 3;
                    case 245: return 3;
                    case 246: return 3;
                    case 247: return 3;
                    case 248: return 3;
                    case 249: return 3;
                    case 250: return 3;
                    case 251: return 3;
                    case 252: return 3;
                    case 253: return 3;
                    case 254: return 3;
                    case 255: return 3;
                    default: return -1;
                }
            case 4:
                switch (c)
                {
                    case 9: return 4;
                    case 13: return 4;
                    case 32: return 4;
                    case 33: return 4;
                    case 34: return 4;
                    case 35: return 4;
                    case 36: return 4;
                    case 37: return 4;
                    case 38: return 4;
                    case 39: return 4;
                    case 40: return 4;
                    case 41: return 4;
                    case 42: return 4;
                    case 43: return 4;
                    case 44: return 4;
                    case 45: return 4;
                    case 46: return 4;
                    case 47: return 4;
                    case 48: return 4;
                    case 49: return 4;
                    case 50: return 4;
                    case 51: return 4;
                    case 52: return 4;
                    case 53: return 4;
                    case 54: return 4;
                    case 55: return 4;
                    case 56: return 4;
                    case 57: return 4;
                    case 58: return 4;
                    case 59: return 4;
                    case 60: return 4;
                    case 61: return 4;
                    case 62: return 4;
                    case 63: return 4;
                    case 64: return 4;
                    case 65: return 4;
                    case 66: return 4;
                    case 67: return 4;
                    case 68: return 4;
                    case 69: return 4;
                    case 70: return 4;
                    case 71: return 4;
                    case 72: return 4;
                    case 73: return 4;
                    case 74: return 4;
                    case 75: return 4;
                    case 76: return 4;
                    case 77: return 4;
                    case 78: return 4;
                    case 79: return 4;
                    case 80: return 4;
                    case 81: return 4;
                    case 82: return 4;
                    case 83: return 4;
                    case 84: return 4;
                    case 85: return 4;
                    case 86: return 4;
                    case 87: return 4;
                    case 88: return 4;
                    case 89: return 4;
                    case 90: return 4;
                    case 91: return 4;
                    case 92: return 4;
                    case 93: return 4;
                    case 94: return 4;
                    case 95: return 4;
                    case 96: return 4;
                    case 97: return 4;
                    case 98: return 4;
                    case 99: return 4;
                    case 100: return 4;
                    case 101: return 4;
                    case 102: return 4;
                    case 103: return 4;
                    case 104: return 4;
                    case 105: return 4;
                    case 106: return 4;
                    case 107: return 4;
                    case 108: return 4;
                    case 109: return 4;
                    case 110: return 4;
                    case 111: return 4;
                    case 112: return 4;
                    case 113: return 4;
                    case 114: return 4;
                    case 115: return 4;
                    case 116: return 4;
                    case 117: return 4;
                    case 118: return 4;
                    case 119: return 4;
                    case 120: return 4;
                    case 121: return 4;
                    case 122: return 4;
                    case 123: return 4;
                    case 124: return 4;
                    case 125: return 4;
                    case 126: return 4;
                    case 161: return 4;
                    case 162: return 4;
                    case 163: return 4;
                    case 164: return 4;
                    case 165: return 4;
                    case 166: return 4;
                    case 167: return 4;
                    case 168: return 4;
                    case 169: return 4;
                    case 170: return 4;
                    case 171: return 4;
                    case 172: return 4;
                    case 173: return 4;
                    case 174: return 4;
                    case 175: return 4;
                    case 176: return 4;
                    case 177: return 4;
                    case 178: return 4;
                    case 179: return 4;
                    case 180: return 4;
                    case 181: return 4;
                    case 182: return 4;
                    case 183: return 4;
                    case 184: return 4;
                    case 185: return 4;
                    case 186: return 4;
                    case 187: return 4;
                    case 188: return 4;
                    case 189: return 4;
                    case 190: return 4;
                    case 191: return 4;
                    case 192: return 4;
                    case 193: return 4;
                    case 194: return 4;
                    case 195: return 4;
                    case 196: return 4;
                    case 197: return 4;
                    case 198: return 4;
                    case 199: return 4;
                    case 200: return 4;
                    case 201: return 4;
                    case 202: return 4;
                    case 203: return 4;
                    case 204: return 4;
                    case 205: return 4;
                    case 206: return 4;
                    case 207: return 4;
                    case 208: return 4;
                    case 209: return 4;
                    case 210: return 4;
                    case 211: return 4;
                    case 212: return 4;
                    case 213: return 4;
                    case 214: return 4;
                    case 215: return 4;
                    case 216: return 4;
                    case 217: return 4;
                    case 218: return 4;
                    case 219: return 4;
                    case 220: return 4;
                    case 221: return 4;
                    case 222: return 4;
                    case 223: return 4;
                    case 224: return 4;
                    case 225: return 4;
                    case 226: return 4;
                    case 227: return 4;
                    case 228: return 4;
                    case 229: return 4;
                    case 230: return 4;
                    case 231: return 4;
                    case 232: return 4;
                    case 233: return 4;
                    case 234: return 4;
                    case 235: return 4;
                    case 236: return 4;
                    case 237: return 4;
                    case 238: return 4;
                    case 239: return 4;
                    case 240: return 4;
                    case 241: return 4;
                    case 242: return 4;
                    case 243: return 4;
                    case 244: return 4;
                    case 245: return 4;
                    case 246: return 4;
                    case 247: return 4;
                    case 248: return 4;
                    case 249: return 4;
                    case 250: return 4;
                    case 251: return 4;
                    case 252: return 4;
                    case 253: return 4;
                    case 254: return 4;
                    case 255: return 4;
                    default: return -1;
                }
            case 11:
                switch (c)
                {
                    case 42: return 27;
                    default: return -1;
                }
            case 12:
                switch (c)
                {
                    case 44: return 28;
                    case 48: return 12;
                    case 49: return 12;
                    case 50: return 12;
                    case 51: return 12;
                    case 52: return 12;
                    case 53: return 12;
                    case 54: return 12;
                    case 55: return 12;
                    case 56: return 12;
                    case 57: return 12;
                    default: return -1;
                }
            case 15:
                switch (c)
                {
                    case 45: return 29;
                    case 61: return 30;
                    default: return -1;
                }
            case 17:
                switch (c)
                {
                    case 61: return 31;
                    default: return -1;
                }
            case 20:
                switch (c)
                {
                    case 65: return 32;
                    case 66: return 32;
                    case 67: return 32;
                    case 68: return 32;
                    case 69: return 32;
                    case 70: return 32;
                    case 71: return 32;
                    case 72: return 32;
                    case 73: return 32;
                    case 74: return 32;
                    case 75: return 32;
                    case 76: return 32;
                    case 77: return 32;
                    case 78: return 32;
                    case 79: return 32;
                    case 80: return 32;
                    case 81: return 32;
                    case 82: return 32;
                    case 83: return 32;
                    case 84: return 32;
                    case 85: return 32;
                    case 86: return 32;
                    case 87: return 32;
                    case 88: return 32;
                    case 89: return 32;
                    case 90: return 32;
                    case 97: return 20;
                    case 98: return 20;
                    case 99: return 20;
                    case 100: return 20;
                    case 101: return 20;
                    case 102: return 20;
                    case 103: return 20;
                    case 104: return 20;
                    case 105: return 20;
                    case 106: return 20;
                    case 107: return 20;
                    case 108: return 20;
                    case 109: return 20;
                    case 110: return 20;
                    case 111: return 20;
                    case 112: return 20;
                    case 113: return 20;
                    case 114: return 20;
                    case 115: return 20;
                    case 116: return 20;
                    case 117: return 20;
                    case 118: return 20;
                    case 119: return 20;
                    case 120: return 20;
                    case 121: return 20;
                    case 122: return 20;
                    default: return -1;
                }
            case 21:
                switch (c)
                {
                    case 65: return 32;
                    case 66: return 32;
                    case 67: return 32;
                    case 68: return 32;
                    case 69: return 32;
                    case 70: return 32;
                    case 71: return 32;
                    case 72: return 32;
                    case 73: return 32;
                    case 74: return 32;
                    case 75: return 32;
                    case 76: return 32;
                    case 77: return 32;
                    case 78: return 32;
                    case 79: return 32;
                    case 80: return 32;
                    case 81: return 32;
                    case 82: return 32;
                    case 83: return 32;
                    case 84: return 32;
                    case 85: return 32;
                    case 86: return 32;
                    case 87: return 32;
                    case 88: return 32;
                    case 89: return 32;
                    case 90: return 32;
                    case 95: return 33;
                    case 97: return 20;
                    case 98: return 20;
                    case 99: return 20;
                    case 100: return 20;
                    case 101: return 20;
                    case 102: return 20;
                    case 103: return 20;
                    case 104: return 20;
                    case 105: return 20;
                    case 106: return 20;
                    case 107: return 20;
                    case 108: return 20;
                    case 109: return 20;
                    case 110: return 20;
                    case 111: return 20;
                    case 112: return 20;
                    case 113: return 20;
                    case 114: return 20;
                    case 115: return 20;
                    case 116: return 20;
                    case 117: return 20;
                    case 118: return 20;
                    case 119: return 20;
                    case 120: return 20;
                    case 121: return 20;
                    case 122: return 20;
                    default: return -1;
                }
            case 22:
                switch (c)
                {
                    case 65: return 32;
                    case 66: return 32;
                    case 67: return 32;
                    case 68: return 32;
                    case 69: return 32;
                    case 70: return 32;
                    case 71: return 32;
                    case 72: return 32;
                    case 73: return 32;
                    case 74: return 32;
                    case 75: return 32;
                    case 76: return 32;
                    case 77: return 32;
                    case 78: return 32;
                    case 79: return 32;
                    case 80: return 32;
                    case 81: return 32;
                    case 82: return 32;
                    case 83: return 32;
                    case 84: return 32;
                    case 85: return 32;
                    case 86: return 32;
                    case 87: return 32;
                    case 88: return 32;
                    case 89: return 32;
                    case 90: return 32;
                    case 95: return 34;
                    case 97: return 20;
                    case 98: return 20;
                    case 99: return 20;
                    case 100: return 20;
                    case 101: return 20;
                    case 102: return 20;
                    case 103: return 20;
                    case 104: return 20;
                    case 105: return 20;
                    case 106: return 20;
                    case 107: return 20;
                    case 108: return 20;
                    case 109: return 20;
                    case 110: return 20;
                    case 111: return 20;
                    case 112: return 20;
                    case 113: return 20;
                    case 114: return 20;
                    case 115: return 20;
                    case 116: return 20;
                    case 117: return 20;
                    case 118: return 20;
                    case 119: return 20;
                    case 120: return 20;
                    case 121: return 20;
                    case 122: return 20;
                    default: return -1;
                }
            case 23:
                switch (c)
                {
                    case 65: return 32;
                    case 66: return 32;
                    case 67: return 32;
                    case 68: return 32;
                    case 69: return 32;
                    case 70: return 32;
                    case 71: return 32;
                    case 72: return 32;
                    case 73: return 32;
                    case 74: return 32;
                    case 75: return 32;
                    case 76: return 32;
                    case 77: return 32;
                    case 78: return 32;
                    case 79: return 32;
                    case 80: return 32;
                    case 81: return 32;
                    case 82: return 32;
                    case 83: return 32;
                    case 84: return 32;
                    case 85: return 32;
                    case 86: return 32;
                    case 87: return 32;
                    case 88: return 32;
                    case 89: return 32;
                    case 90: return 32;
                    case 95: return 35;
                    case 97: return 20;
                    case 98: return 20;
                    case 99: return 20;
                    case 100: return 20;
                    case 101: return 20;
                    case 102: return 20;
                    case 103: return 20;
                    case 104: return 20;
                    case 105: return 20;
                    case 106: return 20;
                    case 107: return 20;
                    case 108: return 20;
                    case 109: return 20;
                    case 110: return 20;
                    case 111: return 20;
                    case 112: return 20;
                    case 113: return 20;
                    case 114: return 20;
                    case 115: return 20;
                    case 116: return 20;
                    case 117: return 20;
                    case 118: return 20;
                    case 119: return 20;
                    case 120: return 20;
                    case 121: return 20;
                    case 122: return 20;
                    default: return -1;
                }
            case 24:
                switch (c)
                {
                    case 65: return 32;
                    case 66: return 32;
                    case 67: return 32;
                    case 68: return 32;
                    case 69: return 32;
                    case 70: return 32;
                    case 71: return 32;
                    case 72: return 32;
                    case 73: return 32;
                    case 74: return 32;
                    case 75: return 32;
                    case 76: return 32;
                    case 77: return 32;
                    case 78: return 32;
                    case 79: return 32;
                    case 80: return 32;
                    case 81: return 32;
                    case 82: return 32;
                    case 83: return 32;
                    case 84: return 32;
                    case 85: return 32;
                    case 86: return 32;
                    case 87: return 32;
                    case 88: return 32;
                    case 89: return 32;
                    case 90: return 32;
                    case 95: return 36;
                    case 97: return 20;
                    case 98: return 20;
                    case 99: return 20;
                    case 100: return 20;
                    case 101: return 20;
                    case 102: return 20;
                    case 103: return 20;
                    case 104: return 20;
                    case 105: return 20;
                    case 106: return 20;
                    case 107: return 20;
                    case 108: return 20;
                    case 109: return 20;
                    case 110: return 20;
                    case 111: return 20;
                    case 112: return 20;
                    case 113: return 20;
                    case 114: return 20;
                    case 115: return 20;
                    case 116: return 20;
                    case 117: return 20;
                    case 118: return 20;
                    case 119: return 20;
                    case 120: return 20;
                    case 121: return 20;
                    case 122: return 20;
                    default: return -1;
                }
            case 27:
                switch (c)
                {
                    case 9: return 27;
                    case 10: return 27;
                    case 13: return 27;
                    case 32: return 27;
                    case 33: return 27;
                    case 34: return 27;
                    case 35: return 27;
                    case 36: return 27;
                    case 37: return 27;
                    case 38: return 27;
                    case 39: return 27;
                    case 40: return 27;
                    case 41: return 27;
                    case 42: return 37;
                    case 43: return 27;
                    case 44: return 27;
                    case 45: return 27;
                    case 46: return 27;
                    case 47: return 27;
                    case 48: return 27;
                    case 49: return 27;
                    case 50: return 27;
                    case 51: return 27;
                    case 52: return 27;
                    case 53: return 27;
                    case 54: return 27;
                    case 55: return 27;
                    case 56: return 27;
                    case 57: return 27;
                    case 58: return 27;
                    case 59: return 27;
                    case 60: return 27;
                    case 61: return 27;
                    case 62: return 27;
                    case 63: return 27;
                    case 64: return 27;
                    case 65: return 27;
                    case 66: return 27;
                    case 67: return 27;
                    case 68: return 27;
                    case 69: return 27;
                    case 70: return 27;
                    case 71: return 27;
                    case 72: return 27;
                    case 73: return 27;
                    case 74: return 27;
                    case 75: return 27;
                    case 76: return 27;
                    case 77: return 27;
                    case 78: return 27;
                    case 79: return 27;
                    case 80: return 27;
                    case 81: return 27;
                    case 82: return 27;
                    case 83: return 27;
                    case 84: return 27;
                    case 85: return 27;
                    case 86: return 27;
                    case 87: return 27;
                    case 88: return 27;
                    case 89: return 27;
                    case 90: return 27;
                    case 91: return 27;
                    case 92: return 27;
                    case 93: return 27;
                    case 94: return 27;
                    case 95: return 27;
                    case 96: return 27;
                    case 97: return 27;
                    case 98: return 27;
                    case 99: return 27;
                    case 100: return 27;
                    case 101: return 27;
                    case 102: return 27;
                    case 103: return 27;
                    case 104: return 27;
                    case 105: return 27;
                    case 106: return 27;
                    case 107: return 27;
                    case 108: return 27;
                    case 109: return 27;
                    case 110: return 27;
                    case 111: return 27;
                    case 112: return 27;
                    case 113: return 27;
                    case 114: return 27;
                    case 115: return 27;
                    case 116: return 27;
                    case 117: return 27;
                    case 118: return 27;
                    case 119: return 27;
                    case 120: return 27;
                    case 121: return 27;
                    case 122: return 27;
                    case 123: return 27;
                    case 124: return 27;
                    case 125: return 27;
                    case 126: return 27;
                    case 161: return 27;
                    case 162: return 27;
                    case 163: return 27;
                    case 164: return 27;
                    case 165: return 27;
                    case 166: return 27;
                    case 167: return 27;
                    case 168: return 27;
                    case 169: return 27;
                    case 170: return 27;
                    case 171: return 27;
                    case 172: return 27;
                    case 173: return 27;
                    case 174: return 27;
                    case 175: return 27;
                    case 176: return 27;
                    case 177: return 27;
                    case 178: return 27;
                    case 179: return 27;
                    case 180: return 27;
                    case 181: return 27;
                    case 182: return 27;
                    case 183: return 27;
                    case 184: return 27;
                    case 185: return 27;
                    case 186: return 27;
                    case 187: return 27;
                    case 188: return 27;
                    case 189: return 27;
                    case 190: return 27;
                    case 191: return 27;
                    case 192: return 27;
                    case 193: return 27;
                    case 194: return 27;
                    case 195: return 27;
                    case 196: return 27;
                    case 197: return 27;
                    case 198: return 27;
                    case 199: return 27;
                    case 200: return 27;
                    case 201: return 27;
                    case 202: return 27;
                    case 203: return 27;
                    case 204: return 27;
                    case 205: return 27;
                    case 206: return 27;
                    case 207: return 27;
                    case 208: return 27;
                    case 209: return 27;
                    case 210: return 27;
                    case 211: return 27;
                    case 212: return 27;
                    case 213: return 27;
                    case 214: return 27;
                    case 215: return 27;
                    case 216: return 27;
                    case 217: return 27;
                    case 218: return 27;
                    case 219: return 27;
                    case 220: return 27;
                    case 221: return 27;
                    case 222: return 27;
                    case 223: return 27;
                    case 224: return 27;
                    case 225: return 27;
                    case 226: return 27;
                    case 227: return 27;
                    case 228: return 27;
                    case 229: return 27;
                    case 230: return 27;
                    case 231: return 27;
                    case 232: return 27;
                    case 233: return 27;
                    case 234: return 27;
                    case 235: return 27;
                    case 236: return 27;
                    case 237: return 27;
                    case 238: return 27;
                    case 239: return 27;
                    case 240: return 27;
                    case 241: return 27;
                    case 242: return 27;
                    case 243: return 27;
                    case 244: return 27;
                    case 245: return 27;
                    case 246: return 27;
                    case 247: return 27;
                    case 248: return 27;
                    case 249: return 27;
                    case 250: return 27;
                    case 251: return 27;
                    case 252: return 27;
                    case 253: return 27;
                    case 254: return 27;
                    case 255: return 27;
                    default: return -1;
                }
            case 28:
                switch (c)
                {
                    case 48: return 38;
                    case 49: return 38;
                    case 50: return 38;
                    case 51: return 38;
                    case 52: return 38;
                    case 53: return 38;
                    case 54: return 38;
                    case 55: return 38;
                    case 56: return 38;
                    case 57: return 38;
                    default: return -1;
                }
            case 32:
                switch (c)
                {
                    case 97: return 39;
                    case 98: return 39;
                    case 99: return 39;
                    case 100: return 39;
                    case 101: return 39;
                    case 102: return 39;
                    case 103: return 39;
                    case 104: return 39;
                    case 105: return 39;
                    case 106: return 39;
                    case 107: return 39;
                    case 108: return 39;
                    case 109: return 39;
                    case 110: return 39;
                    case 111: return 39;
                    case 112: return 39;
                    case 113: return 39;
                    case 114: return 39;
                    case 115: return 39;
                    case 116: return 39;
                    case 117: return 39;
                    case 118: return 39;
                    case 119: return 39;
                    case 120: return 39;
                    case 121: return 39;
                    case 122: return 39;
                    default: return -1;
                }
            case 33:
                switch (c)
                {
                    case 65: return 40;
                    case 66: return 40;
                    case 67: return 40;
                    case 68: return 40;
                    case 69: return 40;
                    case 70: return 40;
                    case 71: return 40;
                    case 72: return 40;
                    case 73: return 40;
                    case 74: return 40;
                    case 75: return 40;
                    case 76: return 40;
                    case 77: return 40;
                    case 78: return 40;
                    case 79: return 40;
                    case 80: return 40;
                    case 81: return 40;
                    case 82: return 40;
                    case 83: return 40;
                    case 84: return 40;
                    case 85: return 40;
                    case 86: return 40;
                    case 87: return 40;
                    case 88: return 40;
                    case 89: return 40;
                    case 90: return 40;
                    case 97: return 40;
                    case 98: return 40;
                    case 99: return 40;
                    case 100: return 40;
                    case 101: return 40;
                    case 102: return 40;
                    case 103: return 40;
                    case 104: return 40;
                    case 105: return 40;
                    case 106: return 40;
                    case 107: return 40;
                    case 108: return 40;
                    case 109: return 40;
                    case 110: return 40;
                    case 111: return 40;
                    case 112: return 40;
                    case 113: return 40;
                    case 114: return 40;
                    case 115: return 40;
                    case 116: return 40;
                    case 117: return 40;
                    case 118: return 40;
                    case 119: return 40;
                    case 120: return 40;
                    case 121: return 40;
                    case 122: return 40;
                    default: return -1;
                }
            case 34:
                switch (c)
                {
                    case 65: return 41;
                    case 66: return 41;
                    case 67: return 41;
                    case 68: return 41;
                    case 69: return 41;
                    case 70: return 41;
                    case 71: return 41;
                    case 72: return 41;
                    case 73: return 41;
                    case 74: return 41;
                    case 75: return 41;
                    case 76: return 41;
                    case 77: return 41;
                    case 78: return 41;
                    case 79: return 41;
                    case 80: return 41;
                    case 81: return 41;
                    case 82: return 41;
                    case 83: return 41;
                    case 84: return 41;
                    case 85: return 41;
                    case 86: return 41;
                    case 87: return 41;
                    case 88: return 41;
                    case 89: return 41;
                    case 90: return 41;
                    case 97: return 41;
                    case 98: return 41;
                    case 99: return 41;
                    case 100: return 41;
                    case 101: return 41;
                    case 102: return 41;
                    case 103: return 41;
                    case 104: return 41;
                    case 105: return 41;
                    case 106: return 41;
                    case 107: return 41;
                    case 108: return 41;
                    case 109: return 41;
                    case 110: return 41;
                    case 111: return 41;
                    case 112: return 41;
                    case 113: return 41;
                    case 114: return 41;
                    case 115: return 41;
                    case 116: return 41;
                    case 117: return 41;
                    case 118: return 41;
                    case 119: return 41;
                    case 120: return 41;
                    case 121: return 41;
                    case 122: return 41;
                    default: return -1;
                }
            case 35:
                switch (c)
                {
                    case 65: return 42;
                    case 66: return 42;
                    case 67: return 42;
                    case 68: return 42;
                    case 69: return 42;
                    case 70: return 42;
                    case 71: return 42;
                    case 72: return 42;
                    case 73: return 42;
                    case 74: return 42;
                    case 75: return 42;
                    case 76: return 42;
                    case 77: return 42;
                    case 78: return 42;
                    case 79: return 42;
                    case 80: return 42;
                    case 81: return 42;
                    case 82: return 42;
                    case 83: return 42;
                    case 84: return 42;
                    case 85: return 42;
                    case 86: return 42;
                    case 87: return 42;
                    case 88: return 42;
                    case 89: return 42;
                    case 90: return 42;
                    case 97: return 42;
                    case 98: return 42;
                    case 99: return 42;
                    case 100: return 42;
                    case 101: return 42;
                    case 102: return 42;
                    case 103: return 42;
                    case 104: return 42;
                    case 105: return 42;
                    case 106: return 42;
                    case 107: return 42;
                    case 108: return 42;
                    case 109: return 42;
                    case 110: return 42;
                    case 111: return 42;
                    case 112: return 42;
                    case 113: return 42;
                    case 114: return 42;
                    case 115: return 42;
                    case 116: return 42;
                    case 117: return 42;
                    case 118: return 42;
                    case 119: return 42;
                    case 120: return 42;
                    case 121: return 42;
                    case 122: return 42;
                    default: return -1;
                }
            case 36:
                switch (c)
                {
                    case 65: return 43;
                    case 66: return 43;
                    case 67: return 43;
                    case 68: return 43;
                    case 69: return 43;
                    case 70: return 43;
                    case 71: return 43;
                    case 72: return 43;
                    case 73: return 43;
                    case 74: return 43;
                    case 75: return 43;
                    case 76: return 43;
                    case 77: return 43;
                    case 78: return 43;
                    case 79: return 43;
                    case 80: return 43;
                    case 81: return 43;
                    case 82: return 43;
                    case 83: return 43;
                    case 84: return 43;
                    case 85: return 43;
                    case 86: return 43;
                    case 87: return 43;
                    case 88: return 43;
                    case 89: return 43;
                    case 90: return 43;
                    case 97: return 43;
                    case 98: return 43;
                    case 99: return 43;
                    case 100: return 43;
                    case 101: return 43;
                    case 102: return 43;
                    case 103: return 43;
                    case 104: return 43;
                    case 105: return 43;
                    case 106: return 43;
                    case 107: return 43;
                    case 108: return 43;
                    case 109: return 43;
                    case 110: return 43;
                    case 111: return 43;
                    case 112: return 43;
                    case 113: return 43;
                    case 114: return 43;
                    case 115: return 43;
                    case 116: return 43;
                    case 117: return 43;
                    case 118: return 43;
                    case 119: return 43;
                    case 120: return 43;
                    case 121: return 43;
                    case 122: return 43;
                    default: return -1;
                }
            case 37:
                switch (c)
                {
                    case 9: return 27;
                    case 10: return 27;
                    case 13: return 27;
                    case 32: return 27;
                    case 33: return 27;
                    case 34: return 27;
                    case 35: return 27;
                    case 36: return 27;
                    case 37: return 27;
                    case 38: return 27;
                    case 39: return 27;
                    case 40: return 27;
                    case 41: return 27;
                    case 42: return 37;
                    case 43: return 27;
                    case 44: return 27;
                    case 45: return 27;
                    case 46: return 27;
                    case 47: return 44;
                    case 48: return 27;
                    case 49: return 27;
                    case 50: return 27;
                    case 51: return 27;
                    case 52: return 27;
                    case 53: return 27;
                    case 54: return 27;
                    case 55: return 27;
                    case 56: return 27;
                    case 57: return 27;
                    case 58: return 27;
                    case 59: return 27;
                    case 60: return 27;
                    case 61: return 27;
                    case 62: return 27;
                    case 63: return 27;
                    case 64: return 27;
                    case 65: return 27;
                    case 66: return 27;
                    case 67: return 27;
                    case 68: return 27;
                    case 69: return 27;
                    case 70: return 27;
                    case 71: return 27;
                    case 72: return 27;
                    case 73: return 27;
                    case 74: return 27;
                    case 75: return 27;
                    case 76: return 27;
                    case 77: return 27;
                    case 78: return 27;
                    case 79: return 27;
                    case 80: return 27;
                    case 81: return 27;
                    case 82: return 27;
                    case 83: return 27;
                    case 84: return 27;
                    case 85: return 27;
                    case 86: return 27;
                    case 87: return 27;
                    case 88: return 27;
                    case 89: return 27;
                    case 90: return 27;
                    case 91: return 27;
                    case 92: return 27;
                    case 93: return 27;
                    case 94: return 27;
                    case 95: return 27;
                    case 96: return 27;
                    case 97: return 27;
                    case 98: return 27;
                    case 99: return 27;
                    case 100: return 27;
                    case 101: return 27;
                    case 102: return 27;
                    case 103: return 27;
                    case 104: return 27;
                    case 105: return 27;
                    case 106: return 27;
                    case 107: return 27;
                    case 108: return 27;
                    case 109: return 27;
                    case 110: return 27;
                    case 111: return 27;
                    case 112: return 27;
                    case 113: return 27;
                    case 114: return 27;
                    case 115: return 27;
                    case 116: return 27;
                    case 117: return 27;
                    case 118: return 27;
                    case 119: return 27;
                    case 120: return 27;
                    case 121: return 27;
                    case 122: return 27;
                    case 123: return 27;
                    case 124: return 27;
                    case 125: return 27;
                    case 126: return 27;
                    case 161: return 27;
                    case 162: return 27;
                    case 163: return 27;
                    case 164: return 27;
                    case 165: return 27;
                    case 166: return 27;
                    case 167: return 27;
                    case 168: return 27;
                    case 169: return 27;
                    case 170: return 27;
                    case 171: return 27;
                    case 172: return 27;
                    case 173: return 27;
                    case 174: return 27;
                    case 175: return 27;
                    case 176: return 27;
                    case 177: return 27;
                    case 178: return 27;
                    case 179: return 27;
                    case 180: return 27;
                    case 181: return 27;
                    case 182: return 27;
                    case 183: return 27;
                    case 184: return 27;
                    case 185: return 27;
                    case 186: return 27;
                    case 187: return 27;
                    case 188: return 27;
                    case 189: return 27;
                    case 190: return 27;
                    case 191: return 27;
                    case 192: return 27;
                    case 193: return 27;
                    case 194: return 27;
                    case 195: return 27;
                    case 196: return 27;
                    case 197: return 27;
                    case 198: return 27;
                    case 199: return 27;
                    case 200: return 27;
                    case 201: return 27;
                    case 202: return 27;
                    case 203: return 27;
                    case 204: return 27;
                    case 205: return 27;
                    case 206: return 27;
                    case 207: return 27;
                    case 208: return 27;
                    case 209: return 27;
                    case 210: return 27;
                    case 211: return 27;
                    case 212: return 27;
                    case 213: return 27;
                    case 214: return 27;
                    case 215: return 27;
                    case 216: return 27;
                    case 217: return 27;
                    case 218: return 27;
                    case 219: return 27;
                    case 220: return 27;
                    case 221: return 27;
                    case 222: return 27;
                    case 223: return 27;
                    case 224: return 27;
                    case 225: return 27;
                    case 226: return 27;
                    case 227: return 27;
                    case 228: return 27;
                    case 229: return 27;
                    case 230: return 27;
                    case 231: return 27;
                    case 232: return 27;
                    case 233: return 27;
                    case 234: return 27;
                    case 235: return 27;
                    case 236: return 27;
                    case 237: return 27;
                    case 238: return 27;
                    case 239: return 27;
                    case 240: return 27;
                    case 241: return 27;
                    case 242: return 27;
                    case 243: return 27;
                    case 244: return 27;
                    case 245: return 27;
                    case 246: return 27;
                    case 247: return 27;
                    case 248: return 27;
                    case 249: return 27;
                    case 250: return 27;
                    case 251: return 27;
                    case 252: return 27;
                    case 253: return 27;
                    case 254: return 27;
                    case 255: return 27;
                    default: return -1;
                }
            case 38:
                switch (c)
                {
                    case 48: return 38;
                    case 49: return 38;
                    case 50: return 38;
                    case 51: return 38;
                    case 52: return 38;
                    case 53: return 38;
                    case 54: return 38;
                    case 55: return 38;
                    case 56: return 38;
                    case 57: return 38;
                    default: return -1;
                }
            case 39:
                switch (c)
                {
                    case 65: return 32;
                    case 66: return 32;
                    case 67: return 32;
                    case 68: return 32;
                    case 69: return 32;
                    case 70: return 32;
                    case 71: return 32;
                    case 72: return 32;
                    case 73: return 32;
                    case 74: return 32;
                    case 75: return 32;
                    case 76: return 32;
                    case 77: return 32;
                    case 78: return 32;
                    case 79: return 32;
                    case 80: return 32;
                    case 81: return 32;
                    case 82: return 32;
                    case 83: return 32;
                    case 84: return 32;
                    case 85: return 32;
                    case 86: return 32;
                    case 87: return 32;
                    case 88: return 32;
                    case 89: return 32;
                    case 90: return 32;
                    case 97: return 39;
                    case 98: return 39;
                    case 99: return 39;
                    case 100: return 39;
                    case 101: return 39;
                    case 102: return 39;
                    case 103: return 39;
                    case 104: return 39;
                    case 105: return 39;
                    case 106: return 39;
                    case 107: return 39;
                    case 108: return 39;
                    case 109: return 39;
                    case 110: return 39;
                    case 111: return 39;
                    case 112: return 39;
                    case 113: return 39;
                    case 114: return 39;
                    case 115: return 39;
                    case 116: return 39;
                    case 117: return 39;
                    case 118: return 39;
                    case 119: return 39;
                    case 120: return 39;
                    case 121: return 39;
                    case 122: return 39;
                    default: return -1;
                }
            case 40:
                switch (c)
                {
                    case 48: return 40;
                    case 49: return 40;
                    case 50: return 40;
                    case 51: return 40;
                    case 52: return 40;
                    case 53: return 40;
                    case 54: return 40;
                    case 55: return 40;
                    case 56: return 40;
                    case 57: return 40;
                    case 65: return 40;
                    case 66: return 40;
                    case 67: return 40;
                    case 68: return 40;
                    case 69: return 40;
                    case 70: return 40;
                    case 71: return 40;
                    case 72: return 40;
                    case 73: return 40;
                    case 74: return 40;
                    case 75: return 40;
                    case 76: return 40;
                    case 77: return 40;
                    case 78: return 40;
                    case 79: return 40;
                    case 80: return 40;
                    case 81: return 40;
                    case 82: return 40;
                    case 83: return 40;
                    case 84: return 40;
                    case 85: return 40;
                    case 86: return 40;
                    case 87: return 40;
                    case 88: return 40;
                    case 89: return 40;
                    case 90: return 40;
                    case 95: return 40;
                    case 97: return 40;
                    case 98: return 40;
                    case 99: return 40;
                    case 100: return 40;
                    case 101: return 40;
                    case 102: return 40;
                    case 103: return 40;
                    case 104: return 40;
                    case 105: return 40;
                    case 106: return 40;
                    case 107: return 40;
                    case 108: return 40;
                    case 109: return 40;
                    case 110: return 40;
                    case 111: return 40;
                    case 112: return 40;
                    case 113: return 40;
                    case 114: return 40;
                    case 115: return 40;
                    case 116: return 40;
                    case 117: return 40;
                    case 118: return 40;
                    case 119: return 40;
                    case 120: return 40;
                    case 121: return 40;
                    case 122: return 40;
                    default: return -1;
                }
            case 41:
                switch (c)
                {
                    case 48: return 41;
                    case 49: return 41;
                    case 50: return 41;
                    case 51: return 41;
                    case 52: return 41;
                    case 53: return 41;
                    case 54: return 41;
                    case 55: return 41;
                    case 56: return 41;
                    case 57: return 41;
                    case 65: return 41;
                    case 66: return 41;
                    case 67: return 41;
                    case 68: return 41;
                    case 69: return 41;
                    case 70: return 41;
                    case 71: return 41;
                    case 72: return 41;
                    case 73: return 41;
                    case 74: return 41;
                    case 75: return 41;
                    case 76: return 41;
                    case 77: return 41;
                    case 78: return 41;
                    case 79: return 41;
                    case 80: return 41;
                    case 81: return 41;
                    case 82: return 41;
                    case 83: return 41;
                    case 84: return 41;
                    case 85: return 41;
                    case 86: return 41;
                    case 87: return 41;
                    case 88: return 41;
                    case 89: return 41;
                    case 90: return 41;
                    case 95: return 41;
                    case 97: return 41;
                    case 98: return 41;
                    case 99: return 41;
                    case 100: return 41;
                    case 101: return 41;
                    case 102: return 41;
                    case 103: return 41;
                    case 104: return 41;
                    case 105: return 41;
                    case 106: return 41;
                    case 107: return 41;
                    case 108: return 41;
                    case 109: return 41;
                    case 110: return 41;
                    case 111: return 41;
                    case 112: return 41;
                    case 113: return 41;
                    case 114: return 41;
                    case 115: return 41;
                    case 116: return 41;
                    case 117: return 41;
                    case 118: return 41;
                    case 119: return 41;
                    case 120: return 41;
                    case 121: return 41;
                    case 122: return 41;
                    default: return -1;
                }
            case 42:
                switch (c)
                {
                    case 48: return 42;
                    case 49: return 42;
                    case 50: return 42;
                    case 51: return 42;
                    case 52: return 42;
                    case 53: return 42;
                    case 54: return 42;
                    case 55: return 42;
                    case 56: return 42;
                    case 57: return 42;
                    case 65: return 42;
                    case 66: return 42;
                    case 67: return 42;
                    case 68: return 42;
                    case 69: return 42;
                    case 70: return 42;
                    case 71: return 42;
                    case 72: return 42;
                    case 73: return 42;
                    case 74: return 42;
                    case 75: return 42;
                    case 76: return 42;
                    case 77: return 42;
                    case 78: return 42;
                    case 79: return 42;
                    case 80: return 42;
                    case 81: return 42;
                    case 82: return 42;
                    case 83: return 42;
                    case 84: return 42;
                    case 85: return 42;
                    case 86: return 42;
                    case 87: return 42;
                    case 88: return 42;
                    case 89: return 42;
                    case 90: return 42;
                    case 95: return 42;
                    case 97: return 42;
                    case 98: return 42;
                    case 99: return 42;
                    case 100: return 42;
                    case 101: return 42;
                    case 102: return 42;
                    case 103: return 42;
                    case 104: return 42;
                    case 105: return 42;
                    case 106: return 42;
                    case 107: return 42;
                    case 108: return 42;
                    case 109: return 42;
                    case 110: return 42;
                    case 111: return 42;
                    case 112: return 42;
                    case 113: return 42;
                    case 114: return 42;
                    case 115: return 42;
                    case 116: return 42;
                    case 117: return 42;
                    case 118: return 42;
                    case 119: return 42;
                    case 120: return 42;
                    case 121: return 42;
                    case 122: return 42;
                    default: return -1;
                }
            case 43:
                switch (c)
                {
                    case 48: return 43;
                    case 49: return 43;
                    case 50: return 43;
                    case 51: return 43;
                    case 52: return 43;
                    case 53: return 43;
                    case 54: return 43;
                    case 55: return 43;
                    case 56: return 43;
                    case 57: return 43;
                    case 65: return 43;
                    case 66: return 43;
                    case 67: return 43;
                    case 68: return 43;
                    case 69: return 43;
                    case 70: return 43;
                    case 71: return 43;
                    case 72: return 43;
                    case 73: return 43;
                    case 74: return 43;
                    case 75: return 43;
                    case 76: return 43;
                    case 77: return 43;
                    case 78: return 43;
                    case 79: return 43;
                    case 80: return 43;
                    case 81: return 43;
                    case 82: return 43;
                    case 83: return 43;
                    case 84: return 43;
                    case 85: return 43;
                    case 86: return 43;
                    case 87: return 43;
                    case 88: return 43;
                    case 89: return 43;
                    case 90: return 43;
                    case 95: return 43;
                    case 97: return 43;
                    case 98: return 43;
                    case 99: return 43;
                    case 100: return 43;
                    case 101: return 43;
                    case 102: return 43;
                    case 103: return 43;
                    case 104: return 43;
                    case 105: return 43;
                    case 106: return 43;
                    case 107: return 43;
                    case 108: return 43;
                    case 109: return 43;
                    case 110: return 43;
                    case 111: return 43;
                    case 112: return 43;
                    case 113: return 43;
                    case 114: return 43;
                    case 115: return 43;
                    case 116: return 43;
                    case 117: return 43;
                    case 118: return 43;
                    case 119: return 43;
                    case 120: return 43;
                    case 121: return 43;
                    case 122: return 43;
                    default: return -1;
                }
            default: return -1;
        }
    }

    private int tokenForState(int state)
    {
        if (state < 0 || state >= TOKEN_STATE.length)
            return -1;

        return TOKEN_STATE[state];
    }

    public int lookupToken(int base, String key)
    {
        int start = SPECIAL_CASES_INDEXES[base];
        int end   = SPECIAL_CASES_INDEXES[base+1]-1;

        while (start <= end)
        {
            int half = (start+end)/2;
            int comp = SPECIAL_CASES_KEYS[half].compareTo(key);

            if (comp == 0)
                return SPECIAL_CASES_VALUES[half];
            else if (comp < 0)
                start = half+1;
            else  //(comp > 0)
                end = half-1;
        }

        return base;
    }

    private boolean hasInput()
    {
        return this.position < this.input.length();
    }

    private char nextChar()
    {
        if (hasInput())
            return this.input.charAt(this.position++);
        else
            return (char) -1;
    }
}
