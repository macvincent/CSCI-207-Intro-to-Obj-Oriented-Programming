/*******************************************************
 * MacVincent Agha-Oko
 * Dr. karina Liles
 * Rock Paper Scissors Game in java
 * March 25, 2019
 * *****************************************************/
import java.util.Scanner;
import java.util.Random;

class RPS{
  //This functions checks to see if player won
  static boolean won(int pl, int cm){
    if(pl == 1 && cm == 3)return true;
    if(pl == 2 && cm == 1)return true;
    if(pl == 3 && cm == 2)return true;
    
    return false;
  }
  
  //This function shows the player and computer's play
  static void showPlay(String a, int temp){
    String b = " ";
    if(temp == 1) b = "Rock";
    else if(temp == 2) b = "Paper";
    else b = "Scissors";
    System.out.printf("%s vs %s ",a,b);
  }

  public static void main(String[] args){
    //We declare and initialise our variables
    int pScore = 0, compScore = 0;
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    System.out.println("\nWelcome to Rock Paper Scissors!\n"); 
    
    //Code runs three times after which results are declared
    for(int i = 0; i < 3; i++){
      System.out.print("Enter \"Rock\", \"Paper\", or \"Scissors\" ");
      String userInput = "";
      try{
        userInput = input.nextLine();
      }catch(Error e){
        System.out.println("Invalid input");
        i--;
        continue;
      }
      int user = 0, comp = 0;
      switch(userInput){
          case("Rock"):
            user = 1;
            break;
          case("Paper"):
            user = 2;
            break;
          case("Scissors"):
            user = 3;
            break;
        default:
          System.out.println("Invalid input try again!");
          i--;
          continue;
      }
      comp = 1 + rand.nextInt(3);//Range for computers play between 1 and 3
      showPlay(userInput,comp);
      
      if(user == comp){
        System.out.println("Draw!");
      }
      else if(won(user,comp)){
        pScore++;
        System.out.println("Player Wins!");
      }else{
        compScore++;
        System.out.println("Computer Wins!");
      }
      
      System.out.printf("Player has won %d times and computer has won %d times\n",pScore,compScore);
    }
    //We display our winner
    if(pScore > compScore){
      System.out.println("Player won!");
    }else if(pScore < compScore){
      System.out.println("Computer won!");
    }else{
      System.out.println("We have a draw!");
    }
  }
};