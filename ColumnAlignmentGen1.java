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
            System.out.println(strin);

        }//end eof

        System.out.println("\n-------------------------");
        System.out.println("end of program");
    }// end main

    
}// end class
