import java.util.Scanner;
import java.util.Random;
/** 
 * ACS-1903 Assignment X Question Y
 * @author 
 */

public class Peril{
    public static void main(String[] args) {

        Random rnd = new Random();      // random number generator

        // player tokens, each player starts with 5
        int p1Tokens = 5;
        int p2Tokens = 5;

        // random player rolls, 2 per player per round
        int p1D1, p1D2;
        int p2D1, p2D2;

        // the big and small roll for each player
        int p1Big, p1Small;
        int p2Big, p2Small;

        int roundCount = 1;     // how many rounds are played
        String bWinner = "";
        String sWinner = "";

        // rounds won by each player
        int p1Rounds = 0;
        int p2Rounds = 0;

        // sets won by each player
        int p1Sets = 0;
        int p2Sets = 0;
        int setCount = 1;           // total sets played

        // play a game
        System.out.println("Welcome to Peril");

        p1Sets = 0;
        p2Sets = 0;

        // play until someone wins 3 sets
        while(p1Sets < 3 && p2Sets < 3){
            //** play one set **
            System.out.println("\n------------------------------");
            System.out.println("Set: " + setCount);
            // set up game valus
            p1Tokens = 5;
            p2Tokens = 5;

            // set goes until someone (or both) run out of tokens
            while((p1Tokens > 0 && p2Tokens > 0)){
                // player one rolls
                p1D1 = rnd.nextInt(6) + 1;
                p1D2 = rnd.nextInt(6) + 1;
                // System.out.println("P1D1: " + p1D1);
                // System.out.println("P1D2: " + p1D2);
                // System.out.println();

                // player 2 rolls
                p2D1 = rnd.nextInt(6) + 1;
                p2D2 = rnd.nextInt(6) + 1;
                // System.out.println("P2D1: " + p2D1);
                // System.out.println("P2D2: " + p2D2);
                // System.out.println();

                // get big and small rolls fore each player
                // player 1

                // using Math.max
                // p1Big = Math.max(p1D1, p1D2);
                // p1Small = Math.min(p1D1, p1D2);

                // using if-else
                if(p1D1 > p1D2){
                    p1Big = p1D1;
                    p1Small = p1D2;
                }// end p1D1 big
                else{
                    p1Big = p1D2;
                    p1Small = p1D1; 
                }// end p1D2 big

                // player 2
                // p2Big = Math.max(p2D1, p2D2);
                // p2Small = Math.min(p2D1, p2D2);

                if(p2D1 > p2D2){
                    p2Big = p2D1;
                    p2Small = p2D2;
                }// end p1D1 big
                else{
                    p2Big = p2D2;
                    p2Small = p2D1; 
                }// end p1D2 big

                // System.out.println("P1Big: " + p1Big);
                // System.out.println("P1Small: " + p1Small);
                // System.out.println();

                // System.out.println("P2Big: " + p2Big);
                // System.out.println("P2Small: " + p2Small);
                // System.out.println();

                // compare big and small rolls
                // see who wins the big roll
                // set winner and remove tokens
                if(p1Big > p2Big){
                    p2Tokens -= p1Big - p2Big;
                    bWinner = "Player 1";
                }// end player 1 wins
                else if (p2Big > p1Big){
                    p1Tokens -= p2Big - p1Big;
                    bWinner = "Player 2";
                }// end player 2 wins
                else{
                    bWinner = "Tie";
                }// end tie

                if(p1Small > p2Small){
                    p2Tokens -= p1Small - p2Small;
                    sWinner = "Player 1";
                }// end play 1 wins
                else if (p2Small > p1Small){
                    p1Tokens -= p2Small - p1Small;
                    sWinner = "Player 2";
                }// ens player 2 wins
                else{
                    sWinner = "tie";
                }//

                // print round summary
                System.out.println("----------------------------");
                System.out.println("Round: " + roundCount + "\n");

                System.out.println("Big roll");
                System.out.print("Player 1: " + p1Big + "\t");
                System.out.print("Player 2: " + p2Big + "\t");
                System.out.println("Winner: " + bWinner);
                System.out.println();

                System.out.println("Small roll");
                System.out.print("Player 1: " + p1Small + "\t");
                System.out.print("Player 2: " + p2Small + "\t");
                System.out.println("Winner: " + sWinner);

                System.out.println();
                System.out.println("Summary: Tokens remaining");
                System.out.println("Player 1: " + p1Tokens);
                System.out.println("Player 2: " + p2Tokens);

                roundCount++;
            }// end of set
            //** post loop **

            roundCount = 1; // re-set rounds to 1 after each set

            // increment round wins of winner
            // this works even if both players have lost all of their
            // tokens, the player with the highest negativ still wins
            //(p1tokens > p2Tokens) ? p1Rounds++ : p2Rounds++;
            if(p1Tokens > p2Tokens){
                System.out.println("\n------------------------");
                System.out.println("Player 1 Wins set " + setCount);
                p1Sets++;
            }// end p1 wins round
            else{
                System.out.println("\n------------------------");
                System.out.println("Player 2 Wins set " + setCount);
                p2Sets++;
            }// end p2 wins round

            // print score board
            System.out.println("\n------------------------");
            System.out.println("Score Board");
            System.out.println(" Player 1 \t Player 2");
            System.out.println("\t" + p1Sets + "\t\t" + p2Sets);
            setCount++;
        }// end game loop

        // print champion message
        System.out.println("\nend of program");
    }
}
