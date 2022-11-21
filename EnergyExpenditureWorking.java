import java.util.Scanner;
/** 
 * ACS-1903 Assignment 1 Question 2
 * @Key 
*/

public class EnergyExpenditureWorking{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // variables
        double weight = 0.0;
        int age = 0;
        int height = 0;
        char gender = 'm';
        char activityLevel = 'A';
        
        double bmr = 0.0;               // basal medabolic rate
        double tdee = 0.0;              // total daily energy expenditure
        double activityFactor = 0.0;    // based on input code 
        
        String qc;          // continue or not
        
        // do-while loop
        do{
            // get personal info
            System.out.println("Enter your weight (in kg), height (in cm), age (in years),and gender (m/f):");
            weight = scanner.nextDouble();
            height = scanner.nextInt();
            age = scanner.nextInt();
            gender = scanner.next().toLowerCase().charAt(0);  // have to extract the required char from the input string
        
            // get activity level
            displayActivityLevelMenu();
            activityLevel = scanner.next().toUpperCase().charAt(0);  // have to extract the required char from the input string

            // get activity factor
            activityFactor = getActivityFactor(activityLevel);
            // calculate bmr
            
            // calculate tdee
            
            // output result
            
            
            // quit or continue
            System.out.println("Do you want to do another? Yes/No");
            qc = scanner.next();
            qc = qc.toLowerCase();
        }// end do
        while(qc.equals("yes"));
        
        
        /*the following print lines are used to 
         * verify that the input is being read 
         * corrctly
         */
        // System.out.println(weight);
        // System.out.println(height);
        // System.out.println(age);
        // System.out.println(gender);
        
        
        
        
        activityLevel = scanner.next().toUpperCase().charAt(0);  // have to extract the required char from the input string
        //System.out.println(activityLevel);
        
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
        
        /* now the activity factor
         * set the level based on the code input
         * from the keyboard and the scale 
         * given in the assignment instructions
       */
        
        // tdee
        tdee = bmr * activityFactor;
        
        // print summarty result
        System.out.format("BMR: %.2f\n",bmr);
        System.out.format("TDEE: %.2f\n",tdee);
        
        // closing message
        
        System.out.println("end of program");
    }
    
    public static double getActivityFactor(char al){
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
    }// end get factor
    
    public static void displayActivityLevelMenu(){
        System.out.println("Enter your activity level:");
        System.out.println("[A]  Sedentary");
        System.out.println("[B]  Lightly Active");
        System.out.println("[C]  Moderate exercise");
        System.out.println("[D]  Very Active");
        System.out.println("[E]  Extra Active");
    }// end displayactivity level
}
