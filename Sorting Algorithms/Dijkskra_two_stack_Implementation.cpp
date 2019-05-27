#include <iostream>
#include <Stack.h>
#include <map>
#include <vector>
int Dijkskra_two_stack(std::string& str);
int main() {
  std::cout << "Enter operation: ";
  std::string received_value = "";
  getline(std::cin, received_value);
  std::cout << " = " << Dijkskra_two_stack(received_value);
}

int Dijkskra_two_stack(std::string& str){
  Stack<char> *operand = new Stack<char>();
  Stack<char> *values = new Stack<char>();
  int result = 0;
  for(auto i : str){
    if(i == '(' || i == ' '){
      continue;
    }else if(i == '*' || i == '+' || i == '-'){
      operand->push(i);
    }else if (i == ')'){
      int a = values->pop();
      int b = values->pop();
      char operation = operand->pop();
      char result;
      if(operation == '*'){
        result = (a * b);
        values->push(result);
      }
      else if(operation == '+'){      
        result = (a + b);
        values->push(result);
      }
      else if(operation == '-'){   
        result = (a - b);
        values->push(result);
      }
    }else{
      values->push(i - '0');
    }
  }
  return values->pop();
}
