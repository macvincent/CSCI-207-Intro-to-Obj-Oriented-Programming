#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

class AStar{
    struct Node{
        int x;
        int y;
        int g;
        int h;
        enum class State{open, closed, path, checked, endNode};
        Node* prev;
        State state;
        Node(int x, int y){
            this->x = x;
            this->y = y;
            prev = nullptr;
            this->g = 0;
            this->h = 0;
        }
    };
    std::vector<std::vector<Node*>> grid;
    std::vector<Node*> openNodes;
    Node* beginNode;
    Node* endNode;
    void create(std::vector<std::vector<int>>, int, int);
    void find(Node*);
    void addNode(Node*&, Node*&);
public:
    void search(std::vector<std::vector<int>>& arr, int endx, int endy);
};

int main(){
    std::vector<std::vector<int>> arr{
        {0,0,0,1},
        {0,0,1,0},
        {0,1,0,0},
        {0,1,0,1},
        {0,0,0,0}
    };
    AStar* search = new AStar();
    search->search(arr, 1, 3);
}

// Creates grid and set their h values
void AStar::create(std::vector<std::vector<int>> arr, int endx, int endy){
    if(arr.size() == 0) return;
    std::vector<Node*>tempList;
    endNode = new Node(endx, endy);
    for(int i = 0; i < arr.size(); i++){
        for(int j = 0; j < arr[i].size(); j++){
            Node* temp = new Node(i, j);
            temp->h = abs(endNode->x - i) + abs(endNode->y - j);
            if(arr[i][j] == 0)temp->state = Node::State::open;
            else temp->state = Node::State::closed;
            tempList.push_back(temp);
        }
        grid.push_back(tempList);
        tempList.clear();
    }
    delete endNode;
    endNode = grid[endx][endy];
}

// Main A-Star pathfinding implementation
void AStar::search(std::vector<std::vector<int>> &arr, int endx, int endy){
    create(arr, endx, endy);
    std::cout << "=>" << endNode->x << ' ' << endNode->y << std::endl;

    grid[0][0]->state = Node::State::checked;
    openNodes.push_back(grid[0][0]);

    while(openNodes.size()){
        Node* temp = openNodes[openNodes.size()-1];
        openNodes.pop_back();
        if(temp == endNode){
            std::cout << "Node Found" << std::endl;
            while(temp){
                temp->state = Node::State::path;
                printf("[%d, %d]\n", temp->x, temp->y);
                temp = temp->prev;
            }
            endNode->state = Node::State::endNode;
            for(auto i : grid){
                for(auto j : i){
                    if(j->state == Node::State::path)std::cout << "* ";
                    else if (j->state == Node::State::checked || j->state == Node::State::open)std::cout << "1 ";
                    else if (j->state == Node::State::endNode)std::cout << "+ ";
                    else std::cout << 0 << ' ';
                }std::cout << std::endl;
            }
            return;
        }
        find(temp);
    }
    std::cout << "No path found" << std::endl;
}

//Populates and sorts openNodes
void AStar::find(AStar::Node* temp){
    if(temp == nullptr) return;
    int i = temp->x;
    int j = temp->y;
    // Check for valid nodes
    if(i+1 < grid.size() && grid[i+1][j]->state == Node::State::open) addNode(temp, grid[i+1][j]);
    if(i-1 >= 0 && grid[i-1][j]->state == Node::State::open) addNode(temp, grid[i-1][j]);
    if(j+1 < grid[i].size() && grid[i][j+1]->state == Node::State::open) addNode(temp, grid[i][j+1]);
    if(j-1 >= 0 && grid[i][j-1]->state == Node::State::open) addNode(temp, grid[i][j-1]);
    // Sort nodes according to their g and h values
    sort(openNodes.begin(), openNodes.end(), [](Node* a, Node* b){
        return (a->h + a->g) > (b->h + b->g);
    });
}

void AStar::addNode(AStar::Node*& curr, AStar::Node*& next){
    next->g = curr->g + 1;
    next->prev = curr;
    next->state = Node::State::checked;
    openNodes.push_back(next);
}
