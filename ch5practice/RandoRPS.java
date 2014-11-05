import java.util.Scanner;
import java.util.Random;
public class RandoRPS
{
    public static void main(String[] args)
        throws InterruptedException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many games should be played? ");
        int play = scan.nextInt();
        Random rand1 = new Random();
        Random rand2 = new Random();
        
        int games_played = 0;
        
        String player1;
        String player2;
        
        String player1_wordchoice = "";
        String player2_wordchoice = "";
        String ties_wordchoice = "";
        
        int player1_wins = 0;
        int player2_wins = 0;
        int ties = 0;
        
        while (games_played < play)
        {
            
            games_played += 1;
            
            int shoot = rand1.nextInt(3);
            int shoot2 = rand2.nextInt(3);
            
           
            if (shoot == 0) 
            {
                player1 = "rock";
            }
            else if (shoot == 1)
            {
                player1 = "scissors";
            }
            else
            {
                player1 = "paper";
            }
            
            if (shoot2 == 0) 
            {
                player2 = "rock";
            }
            else if (shoot2 == 1)
            {
                player2 = "scissors";
            }
            else
            {
                player2 = "paper";
            }
            
            System.out.println("\nROUND: " + games_played);
            System.out.println("Player 1 threw: " + player1 + "!");
            System.out.println("Player 2 threw: " + player2 + "!");
            
            if (player1.equals("rock"))
            {
                if (player2.equals("rock"))
                {
                    System.out.println("Its a tie");
                    ties += 1;
                }
                else if (player2.equals("paper"))
                {
                    System.out.println("Player 2 wins");
                    player2_wins += 1;
                }
                else if (player2.equals("scissors"))
                {
                    System.out.println("Player 1 wins");
                    player1_wins += 1;
                }
            }
            if (player1.equals("paper"))
            {
                if (player2.equals("rock"))
                {
                    System.out.println("Player 1 wins");
                    player1_wins += 1;
                }
                else if (player2.equals("paper"))
                {
                    System.out.println("It's a tie");
                    ties += 1;
                }
                else if (player2.equals("scissors"))
                {
                    System.out.println("Player 2 wins");
                    player2_wins += 1;
                }
            }
            if (player1.equals("scissors"))
            {
                if (player2.equals("rock"))
                {
                    System.out.println("Player 2 wins");
                    player2_wins += 1;
                }
                else if (player2.equals("paper"))
                {
                    System.out.println("Player 1 wins");
                    player1_wins += 1;
                }
                else if (player2.equals("scissors"))
                {
                    System.out.println("It's a tie");
                    ties += 1;
                }
            }
            
            if (games_played != play)
            {
                System.out.println("The next round will begin shortly...");
            }
                //Thread.sleep(1);
        }
        
        if (player1_wins > 1 || player1_wins == 0)
        {
            player1_wordchoice = "times";
        }
        else if (player1_wins == 1)
        {
            player1_wordchoice = "time";
        }
        
        if (player2_wins > 1 || player2_wins == 0)
        {
            player2_wordchoice = "times";
        }
        else if (player2_wins == 1)
        {
            player2_wordchoice = "time";
        }
        
        if (ties > 1 || ties == 0)
        {
            ties_wordchoice = " ties.";
        }
        else
        {
            ties_wordchoice = " tie.";
        }
        
        System.out.println("\nOut of " + play + " rounds, player 1 won " + player1_wins + " " + player1_wordchoice 
                            +", and player 2 won " + player2_wins + " " + player2_wordchoice + ".");
        System.out.println("There were " + ties + ties_wordchoice );                   
    }
}

