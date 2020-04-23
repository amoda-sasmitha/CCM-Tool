package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;



public class Size {
	 
	private static HashSet<String> keyWordSet = new HashSet<String>();

	 protected static  int keywords(String line) {

	        int total = 0;

	         ArrayList<String> jkeyList = new ArrayList<>();
	         Collections.addAll(jkeyList, "assert", "break", "catch", "static" , "public",
	                     "class", "continue", "default",  "enum", "extends", "final", "finally",
	                     "implements", "import", "instanceof",  "interface", "native",
	                     "package", "private", "protected static ",  "strictfp", "super", 
	                    "synchronized", "this", "transient", "void", "volatile");

	         Iterator<String> itr = jkeyList.iterator();

	         while (itr.hasNext()) {
                String kw = itr.next();
                total = total + ((line.length() - line.replaceAll(kw, "").length()) / kw.length());
	         }
	            
	       return total;
	 }
	 
	 protected static  int arithmeticOperators(String line) {
	        int total = 0;

	        //Detect +
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])[+](?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()));
	        //Detect -
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])[-](?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()));
	        //Detect *
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])[*](?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()));
	        //Detect /
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])[/](?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()));
	        //Detect %
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])[%](?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()));
	        //Detect ++
	        //total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])\\++(?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()) / 2);
	        //Detect --
	        //total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])\\--(?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()) / 2);

	        return total;
	    }
	 
	 	protected static  int relationalOperators(String line) {
	        int total = 0;

	        //Detect ==
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])==(?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()) / 2);
	        //Detect !=
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])!=(?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()) / 2);
	        //Detect >
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])>(?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()));
	        //Detect <
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])<(?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()));
	        //Detect >=
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])>=(?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()) / 2);
	        //Detect <=
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])<=(?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()) / 2);

	        return total;
	    }
	 	
	 	protected static  int logicalOperators(String line) {
	        int total = 0;

	        //Detecting &&
	        total = total + ((line.length() - line.replaceAll("&&", "").length()) / 2);
	        //Detecting ||
	        total = total + ((line.length() - line.replaceAll("\\|\\|", "").length()) / 2);
	        //Detecting !
	        total = total + ((line.length() - line.replaceAll("!(?!=)", "").length()));

	        return total;
	    }
	 	
	 	protected static  int bitwiseOperators(String line) {

	        int total = 0;

	        //Detect |
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])[|](?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()));
	        //Detect ^ Does not work needs to be fixed
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])\\^(?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()));
	        //Detect ~
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])[~](?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()));
	        //Detect <<
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])<<(?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()) / 2);
	        //Detect >>
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])>>(?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()) / 2);
	        //Detect <<<
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])<<<(?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()) / 3);
	        //Detect >>>
	        total = total + ((line.length() - line.replaceAll("(?<![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])>>>(?![\\=\\<\\>\\!\\+\\-\\?\\|\\@\\#\\$\\%\\^\\&\\*\\/])", "").length()) / 3);

	        return total;
	    }
	 	
	 	 protected static  int miscellaneousOperators(String line) {
	         int total = 0;
	 
	             // Multiply by 2 since each operator is awarded 2 marks
	             //Detecting &
	             total = total + ((line.length() - line.replaceAll("(?<!&)&(?![&=])", "").length())) * 2;
	             //Detecting *
	             total = total + ((line.length() - line.replaceAll("\\*(?!=)", "").length())) * 2;

	         return total;
	     }
	 	 
	 	protected static  int assignmentOperators(String line) {
	        int total = 0;

	        //Detecting +=
	        total = total + ((line.length() - line.replaceAll("\\+=", "").length()) / 2);
	        //Detecting -=
	        total = total + ((line.length() - line.replaceAll("\\-=", "").length()) / 2);
	        //Detecting *=
	        total = total + ((line.length() - line.replaceAll("\\*=", "").length()) / 2);
	        //Detecting /= 
	        total = total + ((line.length() - line.replaceAll("\\/=", "").length()) / 2);
	        //Detecting = 
	        total = total + ((line.length() - line.replaceAll("(?<![=\\+\\-\\*/!><%&^|])=(?![&=])", "").length()));
	        //Detecting >>>=
	        total = total + ((line.length() - line.replaceAll(">>>=", "").length()) / 4);
	        //Detecting |=
	        total = total + ((line.length() - line.replaceAll("\\|=", "").length()) / 2);
	        //Detecting &=
	        total = total + ((line.length() - line.replaceAll("&=", "").length()) / 2);
	        //Detecting %=
	        total = total + ((line.length() - line.replaceAll("%=", "").length()) / 2);
	        //Detecting <<=
	        total = total + ((line.length() - line.replaceAll("<<=", "").length()) / 2);
	        //Detecting >>=
	        total = total + ((line.length() - line.replaceAll("(?<!>)>>=", "").length()) / 2);
	        //Detecting ^=
	        total = total + ((line.length() - line.replaceAll("\\^=", "").length()) / 2);

	        return total;
	    }
	 	
	 	protected static  int checkStrings(String line) {

	        int total = 0;
	        total = total + ((line.length() - line.replaceAll("\".*?", "").length()) / 2);
	        return total;
	    }
	 	
	 	public static int identifiers(String line) {
	        int programType =  0;		//set program type 0 for java and, 2 for C++.
	        String character = " "; 	//holds Temporary character value used with regex statement.
	        int namesCount = 0;  		//counter increased when an identifiers.
	        String word = ""; 			//word String hold an word value used to identify keywords.
	        initKeyWordSet(programType); //fill keyWordSet with keyword of given program type. 
	        //Loop to access iterate through line ends when line is empty.
	        while (!line.isEmpty()) {

	            try
	            {
	                /*Get character value and remove it form line String*/
	                character = String.valueOf(line.charAt(0));
	                line = line.substring(1);
	                /*is character the start of a identifier*/
	                if (Pattern.matches(CodeSizeConstrants.VARIABLE_START_WITH[programType], character)) {

	                    word = word + character;//add character to word

	                    /*Get character value and remove it form line String*/
	                    character = String.valueOf(line.charAt(0));
	                    line = line.substring(1);

	                    /*loop that check if the next character is part of 
	                                    * the identifier and then adds to word */
	                    do{

	                        word = word + character;//add character to word
	                        /*Get character value and remove it form line String*/
	                        if(line.isEmpty()) {
	                        	break;
	                        }
	                        character = String.valueOf(line.charAt(0));
	                        line = line.substring(1);
	                    }while (Pattern.matches(CodeSizeConstrants.VARIABLE_CHAR[programType], character));

	                    //If word is keyword reset word.
	                    if (keyWordSet.contains(word)) {
	                        word = "";//Reset word value to empty. 
	                    } else {
	                        /*If word is not a keyword 
	                                            reset word and increase namesCount.*/
	                        namesCount++;
	                        word = "";
	                    }
	                }
	            }catch(StringIndexOutOfBoundsException ignored)
	            {}
	        }
	        return namesCount;
	    }
	 	
	 	private static void initKeyWordSet(int programType) {
	        for (String key : CodeSizeConstrants.KEY_WORD_LIST[programType]) {
	            keyWordSet.add(key);
	        }
	    }
	 	
	 	public static int numbers(String line) {
	        int programType = 0;//set program type 0 for java and, 2 for C++.
	        int numberCount = 0;
	        String character = " ";
	        // add a non variable value in-case first character is a number
	        line = "#" + line;
	        /*Get character value and remove it form line String*/
	        character = String.valueOf(line.charAt(0));
	        line = line.substring(1);

	        //Loop to access iterate through line ends when line is empty.
	        while (!line.isEmpty()) {
	            //is character NOT the start of a identifier.
	            if (!Pattern.matches(CodeSizeConstrants.VARIABLE_CHAR[programType], character)) {
	                /*Get character value and remove it form line String*/
	                character = String.valueOf(line.charAt(0));
	                line = line.substring(1);
	                //is character a number.
	                if (Pattern.matches("[0-9]", character)) {
	                    //loop to find end of number.
	                    while (Pattern.matches("[0-9.]", character)) {

	                        //end loop if line is empty
	                        if (line.isEmpty()) {
	                            break;
	                        }
	                        /*Get character value and remove it form line String*/
	                        character = String.valueOf(line.charAt(0));
	                        line = line.substring(1);
	                    }
	                    numberCount++;

	                    //end loop if line is empty
	                    if (line.isEmpty()) {
	                        break;
	                    }

	                }
	            } else {
	                /*Get character value and remove it form line String*/
	                character = String.valueOf(line.charAt(0));
	                line = line.substring(1);
	            }

	        }
	        int count = numberCount;
	        return count;
	    }
	 	
	 	 



}
