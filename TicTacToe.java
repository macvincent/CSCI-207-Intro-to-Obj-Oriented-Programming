import java.util.Scanner;
class Main{
  static Scanner input = new Scanner(System.in);
  static String [][]arr = new String[3][3];
  static boolean gameEnd = false;
//Creates an empty board
  static void create(){
    for(int i = 0; i<3; i++){
     for(int j = 0; j<3; j++){
      arr[i][j] = "-";
     }
   }
  }

  public static void main(String[] args) {
//we create the initial board
   create();
   while(!gameEnd){
    play("One","X");
    checkGameEnd("One","X");
    if(gameEnd)break;
    System.out.println();
    play("Two","O");
    checkGameEnd("Two","O");
    System.out.println();
   }
  }
//This method when called displays the board
  public static void display(String[][]arr){
    System.out.println("____________\n");
    for(int i = 0; i<3; i++){
     for(int j = 0; j<3; j++){
      System.out.print(arr[i][j]+ " | ");
     }
     System.out.println("\n____________\n");
   }
  }
//Here a player selects a position to play
  static void play(String player, String key){
    System.out.println("Player "+player);
    display(arr);
    boolean insert = true;
    while(insert){
      int i = 0, j = 0;
      try{
        System.out.print("Which Row: ");
        i = input.nextInt();
        System.out.print("Which Column: ");
        j = input.nextInt();
      }
      catch(Exception e){
        System.out.println("Invalid Input! \nTry again");
        input.nextLine();
        continue;
      }
      if(i > 2  || i < 0 || j > 2 || j < 0){
        System.out.println("You entered an invalid position. Try again!");
        continue;
      }
      if(check(arr[i][j])){
        arr[i][j] = key;
        insert = false;
      }
    }
  }
//This is a method that displays the winner
  static void displayWinner(String player){
    System.out.println("\n*********************************");
    System.out.println("Player "+ player +" is the winner!");
    System.out.println("*********************************\n");
    gameEnd = true;
  }
//We check to ensure that position is not taken
  static boolean check(String a){
    if(a == "-") return true;
    if(isFull()){
      System.out.println("Array is full. Here, this is a new one");
      create();
      display(arr);
    }
    else{
      System.out.println("Taken!\nSelect a different placement\n");
    }
    return false;
  }
//We check for all possible win positions
  static void checkGameEnd(String player, String key){
      for(int i = 0; i<3; i++){
        if(arr[i][0] == key && arr[i][1] == key && arr[i][2]== key ){
          displayWinner(player);
          break;
        }
        if(arr[0][i] == key && arr[1][i] == key && arr[2][i] == key){
          displayWinner(player);
          break;
        }
      }
      if(arr[0][0] == key && arr[1][1] == key && arr[2][2] == key){
          displayWinner(player);
      }
      if(arr[0][2] == key && arr[1][1] == key && arr[2][0] == key){
          displayWinner(player);
      }
  }
//Checks to see when board is full without winners
  static boolean isFull(){
    boolean full = true;
    for(int i = 0; i<3; i++){
      for(int j = 0; j < 3; j++){
        if(arr[i][j] == "-"){
          full = false;
        }
      }
    }
    return full;
  }
}