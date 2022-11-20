import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/** 
 * ACS-1903 Assignment 2 Question 2
 * @Sveinson: Key 
 */

public class ColumnAlignmentGen2{
    public static void main(String[] args) throws FileNotFoundException{
        // vairables constants and objects
        Scanner fin = new Scanner(new File("As2Q2.txt"));
        Scanner scanner = new Scanner(System.in);   // need this to get column width

        String strin;           // general input string
        String strout = "";     // string for aligned output

        int width = 0;              // width of the output column
        boolean numeric = true;     // if true the input string is numeric

        // int leftPadding = 0;        // number of spaces left to the left
        // int rightPadding = 0;       // number of spaces to the right

        // get column width
        System.out.println("enter the column width.");
        width = scanner.nextInt();

        // eof loop
        while(fin.hasNext()){ 
            // read the next line from the file
            strin = fin.nextLine();
            //System.out.println(strin);

            /* i can create an isNumeric method that will be false if the 
             * string is too long or if the first character is anything
             * other than a digit or a $
             */
            numeric = isNumeric(strin, width);
            
            if(numeric){
                strout = "numeric";
            }// end numeric
            else{
                strout = "non-numeric";
            }// end non-numeric
            
            // print the formatted output string
            System.out.println(strout);
        }//end eof

        System.out.println("\n-------------------------");
        System.out.println("end of program");
    }// end main
    
    public static boolean isNumeric(String strin, int width){
        boolean n = true;       // assume that the string is numeric
        char ch;                // local variable for each character extracted from strin

        if(strin.length() >= width){
            n = false;
        }// end input is wider than column
        else{
            // deal with the first character
            ch = strin.charAt(0);
            //System.out.println(ch);

            if(!(ch == '$' || Character.isDigit(ch))){
                n = false;
                //System.out.println("this is text");
            }// end first character

        }// end width in range

        // now we know if the input string is numeric or not
        return n;
    }// end isNumeric

}// end class
