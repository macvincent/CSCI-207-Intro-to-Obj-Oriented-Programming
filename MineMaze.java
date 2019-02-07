/*****************************************
MacVincent Agha-Oko
Dr Karina Liles
A maze game where you must avoid hidden mines
February 7, 2019
*********************************************/

import java.util.*;
class MineMaze {
  static Random rand = new Random();
  static String[][] board = new String [5][10];
  static int mine1 = 0, mine2 = 0, mine3 = 0;
  static int[] playerPosition = {0,0};
  static boolean gameEnd = false;

  public static void main(String[] args) {
    System.out.println("Welcome to the mine game");
    System.out.println("Your goal is to get to the end point (^) while avoiding the mines.");
    create();
    System.out.printf("The three mines are at cells [%d][%d], [%d][%d], and [%d][%d]\n",mine1/10,mine1%10,mine2/10,mine2%10,mine3/10,mine3%10);
    System.out.println("\nTo move up (-1)\nTo move down (1)\nTo move Left (-2)\nTo move Right (2)\nTo Quit (9)");
    while(!gameEnd){
      play();
    }
  }

  static void create(){//Creates the board with initial placements
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 10; j++){
        board[i][j] = "-";
      }
    }

    //Here we get our mines, start, and goal positions while ensuring we don't select duplicate positions
    do{
      mine1 = rand.nextInt(50);
    }while(mine1 == 0 || mine1 == 49);

    do{
      mine2 = rand.nextInt(50);
    }while(mine1 == mine2 || mine2 == 0 || mine2 == 49);

    do{
      mine3 = rand.nextInt(50);
    }while(mine3 == mine1 || mine3 == mine2 || mine3 == 0 || mine3 == 49);

    board[0][0] = "X";
    board[4][9] = "^";
  }

  static void display(){//Displays the board at each segment of the game
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 10; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  static void play(){
    display();
    Scanner input = new Scanner(System.in);
    int move = 0;

    try{
      move = input.nextInt();
    }catch(Exception e){
      System.out.print("");
    }

    board[playerPosition[0]][playerPosition[1]] = "-";
    switch(move){
      case(-1):
        if(playerPosition[0] - 1 < 0){
          System.out.println("Invalid Input");
        }
        else playerPosition[0] -= 1;
      break;

      case(1):
        if(playerPosition[0] + 1 > 4){
          System.out.println("Invalid Input");
        }
        else playerPosition[0] += 1;
      break;

      case(-2):
        if(playerPosition[1] - 1 < 0){
          System.out.println("Invalid Input");
        }
        else playerPosition[1] -= 1;
      break;

      case(2):
        if(playerPosition[1] + 1 > 9){
          System.out.println("Invalid Input");
        }
        else playerPosition[1] += 1;
      break;

      case(9):
        System.out.println("It's okay to quit. Bye!");
        gameEnd = true;
        break;

      default:
        System.out.println("Invalid Input");
    }
    board[playerPosition[0]][playerPosition[1]] = "X";
    checkGameEnd();
  }

  static void checkGameEnd(){//Here we check to see of the game has ended for any possible condition
    int check = playerPosition[0]*10 + playerPosition[1];
    if(check == mine1 || check == mine2 || check == mine3){
      System.out.println("Boom! You hit a mine");
      gameEnd = true;
    }
    if(check == 49){
      System.out.println("Nice. You made it.\nCongratulations!");
      gameEnd = true;
    }
  }
}