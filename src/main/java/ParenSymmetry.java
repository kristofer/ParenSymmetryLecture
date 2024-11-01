import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

public class ParenSymmetry {

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();
        //ps.runDetailedExamples();
        ps.runFileExamples();
    }

    // lots of ways to do this
    
    /* 
     * This function takes a string and returns a boolean
     * If the number of parens equals the number of thesis, return true
     * else return false
     * if at any point the number of either parens or thesis is less than 0, return false
     */

     // Number 1
    // public Boolean isBalanced(String s) {
    //     Boolean result = false;
    //     if (s.isEmpty()) {
    //         return result;
    //     }
    //     int parens = 0;
    //     int thesis = 0;

    //     char[] c = s.toCharArray();

    //     for (int i = 0; i < c.length; i++) {
    //         if (c[i] == '(') {
    //             parens++;
    //         } else if (c[i] == ')') {
    //             thesis++;
    //         }
    //         if (thesis > parens) {
    //             return false;
    //         }
    //     }
    //     if (parens == thesis) {
    //         result = true;
    //     }
    //     return result;
    // }

    // Number 2
    // public Boolean isBalanced(String s) {
    //     if (s.isEmpty()) return false;
    //     char[] c = s.toCharArray();
    //     int parens = 0;
    //     int thesis = 0;
    //     for (int i = 0; i < c.length; i++) {
    //         if (c[i] == '(') {
    //             parens++;
    //         } else if (c[i] == ')') {
    //             thesis++;
    //         }
    //     }
    //     if (parens - thesis == 0) {
    //         return true;
    //     }
    //     return false;
    // }

    // Number 3
    // public Boolean isBalanced(String s) {
    //     // if the string is empty, return false
    //     if (s.isEmpty()) {
    //         return false;
    //     }
    //     int parenBalance = 0;
    //     for (char c : s.toCharArray()) {
    //         if (c != '(' && c != ')') {
    //             continue;
    //         }
    //         if (c == '(') {
    //             parenBalance++;
    //         } else if (c == ')') {
    //             parenBalance--;
    //         }
    //         if (parenBalance < 0) {
    //             return false;
    //         }
    //     }
    //     if (parenBalance == 0) {
    //         return true;
    //     }
    //     return false;
    // }

    // Number 4
    // public Boolean isBalanced(String s) {

    //     if (s.isEmpty()) return false;
        
    //     char[] c = s.toCharArray();
    //     int parens = 0;
    //     for (int i = 0; i < c.length; i++) {
    //         if (c[i] == '(') {
    //             parens++;
    //         } else if (c[i] == ')') {
    //             parens--;
    //         }
    //     }
    //     if (parens == 0) {
    //         return true;
    //     }
    //     return false;
    // }
    
    // Number 5
    public Boolean isBalanced(String s) {
        if (s.isEmpty()) return false;
        int parens = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') parens++;
            if (c == ')') parens--;
            if (parens < 0) return false;
        }
        if (parens == 0) return true;
        return false;
    }


    void checkFile(String filename) {
        // open file named filename

        // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file

        BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();

			while (line != null) {
				//System.out.println(line);

                printResult2(this.isBalanced(line), line);
				
                // read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    public void runExamples() {
        Boolean b0 = this.isBalanced("()");
        System.out.println(b0);

        Boolean b1 = this.isBalanced("())");
        System.out.println(b1);

        Boolean b2 = this.isBalanced("(()");
        System.out.println(b2);

        Boolean b3 = this.isBalanced("()grand()illusion");
        System.out.println(b3);
    }

    public void runFileExamples() {
        System.out.println(">> Running file examples");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(">> TestStrings0.txt");
        this.checkFile("TestStrings0.txt");
        System.out.println(">> TestStrings1.txt");
        this.checkFile("TestStrings1.txt");
    }

    public void runDetailedExamples() {

        /*
         * Notice the use of `this`
         */
        Boolean b0 = this.isBalanced("()");
        printResult(b0, true, "()");

        System.out.println("\nFalses\n");
        String[] falseStrings = {"(", "((", ")", "", "(()())((())))", ")(", "))(("};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = this.isBalanced(strToTest);
            printResult(falses, false, strToTest);
        }

        System.out.println("\nTrues\n");

        String[] trueStrings = {"()", "(())", "(((())))", "(()())((()))", "(   )", "( )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = this.isBalanced(strToTest);
            printResult(trues, true, strToTest);
        }

    }

    private static void printResult(Boolean b0, boolean b, String input) {
        System.out.print(b + ": " + input + ", ");
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println(" Success");
        } else {
            System.out.println(" Failure");
        }
    }
    private static void printResult2(Boolean b0, String input) {
        System.out.print("??" + ": " + input + ", ");
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0) {
            System.out.println(" Success");
        } else {
            System.out.println(" Failure");
        }
    }
}
