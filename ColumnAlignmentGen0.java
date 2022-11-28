import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/** 
 * ACS-1903 Assignment 2 Question 2
 * @sveinson
 * align input text according to the string type
 */

public class ColumnAlignmentGen0{
    public static void main(String[] args) throws FileNotFoundException {
        // vairables constants and objects
        Scanner fin = new Scanner(new File("As2Q2.txt"));
        Scanner scanner = new Scanner(System.in);   // need this to get column width

        String strin;           // general input string
        String strout = "";     // string for aligned output

        int width = 0;              // width of the output column

        // get the column width
        // get column width
        System.out.println("enter the column width.");
        width = scanner.nextInt();

        boolean numeric = true;

        // read data from a file
        // eof loop
        while(fin.hasNext()){ 
            // read the next line from the file
            strin = fin.nextLine();
            //System.out.println(strin);

            // get numeric or not from a static method
            // 3 possibilities (nested if-else)
            // too long (easy)
            // numeric
            // text
            if(strin.length() > width){
                //System.out.println("too long");
                strout = strin;
            }// end too long
            else{
                if(isNumeric(strin)){
                    strout = rightAlign(strin, width);
                    //System.out.println("numeric");
                }// end is numeric
                else{
                    strout = centerAlign(strin, width);
                    //System.out.println("not numeric");
                }// end not numeric
            }// end not too long

            // output the aligned string
            System.out.println(strout);
        }//end eof

        // build the output string for numeric and text strings
        // if it's too long set stout = strin
        // if it's numeric
        // right align by padding the left side of the output string
        // add strin
        // if it's not numeric centre align
        // pad left side of strout with dots
        // add strin
        // pad right side of strout

        // output the aligned string

        System.out.println("end of program");
    }// end main

    public static String rightAlign(String strin, int width){
        /* strout has to be initialized otherwise we get the 
         * "strout might not have been initialized" error message
         */
        String strout = "";

        // variables for the left and right padding
        int leftPadding = 0;        // number of spaces left to the left

        // calculate left padding
        leftPadding = width - strin.length();
        //System.out.println(leftPadding);

        // add left padding dots
        for(int i = 0; i < leftPadding; i++){
            strout += ".";
        }// end add left padding
        // add strin
        strout += strin;    
        return strout;
    }// end right align

    public static String centerAlign(String strin, int width){
        /* strout has to be initialized otherwise we get the 
         * "strout might not have been initialized" error message
         */
        String strout = "";
        int leftPadding = 0;        // number of spaces left to the left
        int rightPadding = 0;       // number of spaces to the right

        // calculate left and right padding
        leftPadding = width - strin.length();
        rightPadding = leftPadding / 2;
        leftPadding = leftPadding - rightPadding;
        //System.out.println(leftPadding + " " + rightPadding);

        // add left padding dots
        for(int i = 0; i < leftPadding; i++){
            strout += ".";
        }// end add left padding

        // catenate strin
        strout += strin;

        // add right padding
        for(int i = leftPadding + strin.length(); i < width; i++){
            strout += ".";
        }//end right padding    
        return strout;
    }// end center

    /* take in a string and return true if the string
     * is numeric i.e. digits
     * it may also be numeric if the first character is $
     * and if there is one and only one . ie. a decimal point
     */
    public static boolean isNumeric(String strin){
        // assume the string is numeric
        boolean n = true;       // assume that the string is numeric
        char ch;                // local variable for each character extracted from strin
        int dotCount = 0;       // number of dots in the string

        // get the first character        
        // see if the first character is anything but a digit or $
        ch = strin.charAt(0);
        //System.out.println(ch);

        if(!(ch == '$' || Character.isDigit(ch))){
            n = false;
            //System.out.println("this is text");
        }// end first character

        // iterate over the remaining characters
        // count the dots
        //if any of them are not digits and there are more than one .
        // set numeric to false
        for(int i = 1; i < strin.length() && n; i++){
            ch = strin.charAt(i);   // extract each char in turn
            //System.out.println(ch);

            if(!Character.isDigit(ch)){
                if(ch == '.' && dotCount < 1){
                    dotCount++;
                }// end not digit and dot count < 1
                else{
                    n = false;
                }// end not a digit not a dot

            }// end not a digit
        }// end for int i

        // now we know if the input string is numeric or not
        return n; 
    }// end isNumeric
}// end main
