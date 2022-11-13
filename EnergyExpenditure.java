import java.util.Scanner;
/** 
 * ACS-1903 Assignment 1 Question 2
 * @Key 
*/

public class EnergyExpenditure{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // variables
        String qc;              // quit or contine
        
        // personal infor input from kb
        double weight = 0.0;
        int age = 0;
        int height = 0;
        char gender = 'm';
        char activityLevel = 'A';
        
        // calculated values
        double bmr = 0.0;               // basal medabolic rate
        double tdee = 0.0;              // total daily energy expenditure
        double activityFactor = 0.0;    // based on input code   
        
        // do until user inputs quit
        do{
            // get personal info
            System.out.println("Enter your weight (in kg), height (in cm), age (in years),and gender (m/f):");
            weight = scanner.nextDouble();
            height = scanner.nextInt();
            age = scanner.nextInt();
            gender = scanner.next().toLowerCase().charAt(0);  // have to extract the required char from the input string
            
            // Display the activity level menu
            displayActivityLevelMenu();
            
            // get the activity factor
            activityLevel = getActivityLevel(scanner);  // have to extract the required char from the input string
            
            // look up activity factor
            activityFactor = lookUpAF(activityLevel);
            
            /* calculate the bmr
             * based on the formula given in the 
             * assignment instructions
             */
            if(gender == 'm'){
                bmr = 66 + (13.7 * weight) + (5 * height) -(6.8 * age);
            }//end gender m
            else{
                bmr = 655 + (9.6 * weight) + (1.8 * height) -(4.7 * age);
            }// end gender not m
            
            //calculate tdee
            tdee = calculateTDEE(bmr, activityFactor);
            
            // output results
            printSummary(bmr, tdee);
            
            // wuit or continue
            System.out.println("Do you want to do another? Yes/No");
            qc = scanner.next();
            qc = qc.toLowerCase();
        }// end q/c do-while loop
        while(qc.equals("yes"));
        
        // closing message        
        System.out.println("end of program");
    }// end main
    
    // ***** static methods ****
    public static void printSummary(double bmr, double tdee){
        // print summarty result
        System.out.format("BMR: %.2f\n",bmr);
        System.out.format("TDEE: %.2f\n",tdee);
    } //n end print
    
    public static double calculateTDEE(double bmr, double activityFactor){
        return bmr * activityFactor;
    }// end get tdee
    
    public static double lookUpAF(char al){
        double af;
        
        // normalize al to uppercase
        al = Character.toUpperCase(al);
        
        switch(al){
            case 'A': af = 1.2;
            break;
            case 'B': af = 1.375;
            break;
            case 'C': af = 1.55;
            break;
            case 'D': af = 1.725;
            break;
            default: af = -1;
        }// end swtich
        return af;
    }// end lookUpAF
    
    public static char getActivityLevel(Scanner s){
        String st = s.next();
        return st.charAt(0);
    }// end get actibity level
    
    public static void displayActivityLevelMenu(){
    // display menu
        System.out.println("Enter your activity level:");
        System.out.println("[A]  Sedentary");
        System.out.println("[B]  Lightly Active");
        System.out.println("[C]  Moderate exercise");
        System.out.println("[D]  Very Active");
        System.out.println("[E]  Extra Active");    
    }// end activity level menu
}
