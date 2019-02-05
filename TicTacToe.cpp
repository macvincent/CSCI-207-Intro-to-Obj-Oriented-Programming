#include <iostream>
using namespace std;

string arr[3][3];//check= new string[3][3];
bool gameEnd = false;
void create();
void play(string, string);
void checkGameEnd(string, string);
void display(string[3][3]);
bool check(string);
bool isFull();

int main() {
  //we create the initial board
  create();
  while(!gameEnd){
    play("One","X");
    checkGameEnd("One","X");
    if(gameEnd)break;
    cout<<'\n';
    play("Two","O");
    checkGameEnd("Two","O");
    cout<<'\n';
  }
}
//Here a player selects a position to play
void play(string player, string key){
  cout<<"Player "<<player<<'\n';
  display(arr);
  bool insert = true;
  while(insert){
    int i = 0, j = 0;
    try{
      cout<<"Which Row: ";
      cin>>i;
      if(!cin){
        throw -1;
      }
      cout<<"Which Column: ";
      cin>>j;
      if(!cin){
        throw -1;
      }
    }
    catch(...){
      cin.clear();
      cin.ignore(1000,'\n');
      cout<<"Invalid input\nSelect a different placement\n";
      continue;
    }
    if(i > 2  || i < 0 || j > 2 || j < 0){
      cout<<"You entered an invalid position. Try again!\n";
      continue;
    }
    if(check(arr[i][j])){
      arr[i][j] = key;
      insert = false;
    }
  }
}
//This is a method that displays the winner
void displayWinner(string player){
  cout<<"\n*********************************\n";
  cout<<"Player "+ player +" is the winner!\n";
  cout<<"*********************************\n";
  gameEnd = true;
}
//We check to ensure that position is not taken
bool check(string a){
  if(a == "-") return true;
  if(isFull()){
    cout<<"Array is full. Here, this is a new one\n";
    create();
    display(arr);
  }
  else{
    cout<<"Taken!\nSelect a different placement\n";
  }
    return false;
}
//We check for all possible win positions
void checkGameEnd(string player, string key){
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
bool isFull(){
  bool full = true;
  for(int i = 0; i<3; i++){
    for(int j = 0; j < 3; j++){
      if(arr[i][j] == "-"){
        full = false;
      }
    }
  }
  return full;
}
//Creates an empty board
void create(){
  for(int i = 0; i<3; i++){
    for(int j = 0; j<3; j++){
      arr[i][j] = "-";
    }
  }
}
//This method when called displays the board
void display(string arr [3][3]){
  cout<<"____________\n";
  for(int i = 0; i<3; i++){
    for(int j = 0; j<3; j++){
      cout<<arr[i][j]+ " | ";
    }
    cout<<"\n____________\n";
  }
}