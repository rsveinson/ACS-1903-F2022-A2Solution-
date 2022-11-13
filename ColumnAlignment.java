import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/** 
 * ACS-1903 Assignment 2 Question 2
 * @Sveinson: Key 
 */

public class ColumnAlignment{
    public static void main(String[] args) throws FileNotFoundException{
        // vairables constants and objects
        Scanner fin = new Scanner(new File("As2Q2.txt"));
        Scanner scanner = new Scanner(System.in);   // need this to get column width

        String strin;           // general input string
        String strout = "";     // string for aligned output

        int width = 0;          // width of the output column
        char stringType = 'n';  // type of string read from file, n is numeric otherwise non-numeric
        char ch;                // place holder for each char in the sting
        int dotCount = 0;       // counter for dots.
        
        int leftPadding = 0;        // number of spaces left to the left
        int rightPadding = 0;       // number of spaces to the right

        // get column width
        System.out.println("enter the column width.");
        width = scanner.nextInt();

        // eof loop
        while(fin.hasNext()){ 
            // read the next line from the file
            strin = fin.nextLine();
            //System.out.println(strin);

            // work on alignment
            // analyze strin
            dotCount = 0;               // 0 dots for each new string
            stringType = 'n';           // assume string is numeric

            // set wide input
            if(strin.length() >= width){
                stringType = 'l';
            }// end input is wider than column
            else{
                // deal with the first character
                ch = strin.charAt(0);
                //System.out.println(ch);

                if(!(ch == '$' || Character.isDigit(ch))){
                    stringType = 't';
                    //System.out.println("this is text");
                }// end first character

                // now analyze the rest of the characters
                // i added the && to the logical expression but it's not
                // really needed, it stops the loop if the type is changed to 't'
                for(int i = 1; i < strin.length() && stringType == 'n'; i++){
                    ch = strin.charAt(i);   // extract each char in turn
                    //System.out.println(ch);
                    if(!Character.isDigit(ch)){
                        if(ch == '.' && dotCount < 1){
                            dotCount++;
                        }// end not digit and dot count < 1
                        else{
                            stringType = 't';
                        }// end not a digit not a dot

                    }// end not a digit
                }// end for int i

            }// end width in range
            
            /* now the string type has been set
             * we can build the output string
             * with the padding characters right or
             * left
             */
            
            // set strout to empty string
            strout = "";
            
            // now pad out the string
            if(stringType == 'l'){
                strout = strin;     // simple left aligned on oversized string
            }// end input is wider than column
            else if(stringType == 'n'){
                // calculate left padding
                leftPadding = width - strin.length();
                //System.out.println(leftPadding);
                
                // add left padding dots
                for(int i = 0; i < leftPadding; i++){
                    strout += ".";
                }// end add left padding
                // add strin
                strout += strin;
            }//end numeric
            else{
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
            }// end text

            // output the formatted/aligned string
            System.out.println(strout);
        }//end eof

        System.out.println("\n-------------------------");
        System.out.println("end of program");
    }// end main
}// end main
