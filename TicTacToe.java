import java.util.Scanner;
class TicTacToe {
  static Scanner input = new Scanner(System.in);
  static String [][]arr = new String[3][3];
  static boolean gameEnd = false;

  static void create(){
    for(int i = 0; i<3; i++){
     for(int j = 0; j<3; j++){
      arr[i][j] = "-";
     }
   }
  }

  public static void main(String[] args) {
   create();
   while(!gameEnd){
    playerOne();
    checkGameEnd("One");
    if(gameEnd){
      break;
    }
    System.out.println();
    playerTwo();
    checkGameEnd("Two");
    System.out.println();
   }
  }

  public static void display(String[][]arr){
    System.out.println("____________\n");
    for(int i = 0; i<3; i++){
     for(int j = 0; j<3; j++){
      System.out.print(arr[i][j]+ " | ");
     }
     System.out.println("\n____________\n");
   }
  }

  static void playerOne(){
    System.out.println("Player One");
    display(arr);
    boolean insert = true;
    while(insert){
      System.out.print("Which Row: ");
      int i = input.nextInt();
      System.out.print("Which Column: ");
      int j = input.nextInt();
      if(check(arr[i][j])){
        arr[i][j] = "X";
        insert = false;
      }
    }
  }

  static void playerTwo(){
    System.out.println("Player Two");
    display(arr);
    boolean insert = true;
    while(insert){
      System.out.print("Which Row: ");
      int i = input.nextInt();
      System.out.print("Which Column: ");
      int j = input.nextInt();
      if(check(arr[i][j])){
        arr[i][j] = "O";
        insert = false;
      }
    }
  }

  static void displayWinner(String a){
    System.out.println("Player "+ a +" is the winner!");
    gameEnd = true;
  }

  static boolean check(String a){
    if(a == "-") return true;
    System.out.println("\nTaken. Select a different placement");
    return false;
  }

  static void checkGameEnd(String a){
    if(a == "One"){
      for(int i = 0; i<3; i++){
        if(arr[i][0]=="X" && arr[i][1]=="X" && arr[i][2]=="X"){
          displayWinner("One");
        }
        if(arr[0][i]=="X" && arr[1][i]=="X" && arr[2][i]=="X"){
          displayWinner("One");
        }
      }
      if(arr[0][0]=="X" && arr[1][1]=="X" && arr[2][2]=="X"){
          displayWinner("One");
        }
        if(arr[0][2]=="X" && arr[1][1]=="X" && arr[2][0]=="X"){
          displayWinner("One");
        }
    }
    else{
      for(int i = 0; i<3; i++){
      if(arr[i][0]=="O" && arr[i][1]=="O" && arr[i][2]=="O"){
        displayWinner("Two");
      }
      if(arr[0][i]=="O" && arr[1][i]=="O" && arr[2][i]=="O"){
        displayWinner("Two");
      }
    }
    if(arr[0][0]=="O" && arr[1][1]=="O" && arr[2][2]=="O"){
          displayWinner("Two");
        }
        if(arr[0][2]=="O" && arr[1][1]=="O" && arr[2][0]=="O"){
          displayWinner("Two");
        }
    }
  }
}