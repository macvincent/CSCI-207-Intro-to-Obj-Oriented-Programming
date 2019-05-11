#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

//We construct a node class
struct Node{
  int x;
  int y;
  int g;
  int h;
  enum class State {Open, Closed};
  State state;

  Node(int x, int y){
    this->x = x;
    this->y = y; 
    this->g = 0;  
  }
  int findH(Node* curr){
    return abs(curr->x - this->x) +  abs(curr->y - this->y);
  }
};

//This creates the grid we would be sorting through
std::vector<std::vector<Node*>> createGrid(std::vector<std::vector<int>>& arr, Node* endNode){
  std::vector<std::vector<Node*>> grid;
  for(int i = 0; i < arr.size(); i++){
    std::vector<Node*> temp;
    for(int j = 0; j < arr[i].size(); j++){
      Node* newNode = new Node(i,j);
      newNode->h = endNode->findH(newNode);
      temp.push_back(newNode);
    }grid.push_back(temp);
  }
  return grid;
}

//This function would be used when sorting node values
bool compare (Node* x, Node* y){
  return (x->h + x->g) > (y->h + y->g);
}

/**
*Initial board input
*0 represents open spaces and 1 represents blocks
*/
std::vector<std::vector<int>> createBoard(){
    std::vector<std::vector<int>>board{{0,1,0,0,0,0,0,0}, {0,1,0,0,0,0,0,0}, {0,1,0,0,0,0,0,0}, {0,1,0,1,0,0,0,0}, {0,0,0,1,0,0,0,0}};
    return board;
}

//Our AStarSearch to find the shortest path through the board
void AStarSearch(std::vector<std::vector<int>>& arr, std::vector<std::vector<Node*>>& grid){
  //We initialise our start and end Nodes which can also be gotten from user input
  Node* startNode = grid[0][0];
  Node* endNode = grid[arr.size()-1][arr[1].size()-1];
  std::vector<Node*> open;
  open.push_back(startNode);
  Node* cur = startNode;

  //This directions vector makes it easier to search for possible node neighbors
  int direction [][2] = {{1, 0}, {0, 1}, {-1, 0}, {-1, 0}};

  //We would keep on searching as long as there are still open arrays or we have not yet reached the end node
  while(open.size() > 0){
  	//We set current nodes as part of path
    cur->state = Node::State::Closed;
    for(auto i : direction){
      int tempX = cur->x + i[0];
      int tempY = cur->y + i[1];

      if(tempX < grid.size() && tempY < grid[1].size()){
        if(arr[tempX][tempY] != 1 && grid[tempX][tempY]-> state !=  Node::State::Closed){
          grid[tempX][tempY]->g = 1 + cur->g;
          open.push_back(grid[tempX][tempY]);
        }
      }
    }
    /**
    *we sort for the node with the lowest f-value
    *f = h + g
    *Where h = heuristic value and g is workdone or steps taken
    *The f value helps us make the best decision as to which node to move to
    */
    std::sort(open.begin(), open.end(), compare);
    cur = open.back();
    if(cur == endNode)break;
    open.pop_back();
  }
  	cur->state = Node::State::Closed;//The end node is also part of path
}

int main() {
  std::vector<std::vector<int>>arr = createBoard();
  Node* endNode = new Node(arr.size()-1, arr[0].size()-1);
  std::vector<std::vector<Node*>> grid = createGrid(arr, endNode);
  AStarSearch(arr, grid);
  delete endNode;
  //We print the found path
  for(auto i : grid){
    for(auto j : i){
      if(j->state == Node::State::Closed){
        printf("%2d ", j->g);
      }else{
        printf("%d ", -1);
      }
    }std::cout << '\n';
  }

}