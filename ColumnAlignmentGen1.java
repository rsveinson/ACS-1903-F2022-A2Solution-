import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/** 
 * ACS-1903 Assignment 2 Question 2
 * @Sveinson: Key 
 */

public class ColumnAlignmentGen1{
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

            if(strin.length() > width){
                System.out.println("too long");
                strout = strin;
            }// end too long
            else{
                if(isNumeric(strin)){
                    System.out.println("numeric");
                }// end is numeric
                else{
                    System.out.println("not numeric");
                }// end not numeric
            }// end ok

        }//end eof

        System.out.println("\n-------------------------");
        System.out.println("end of program");
    }// end main

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

}// end class
