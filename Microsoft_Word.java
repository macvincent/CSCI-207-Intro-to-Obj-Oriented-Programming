/****************************
 * Name: MacVincent Agha-Oko
 * Class: CSC207
 * Description: A code that performs certain operations on a string
 * Date: February 18th, 2019
****************************/

import java.util.Scanner;
class Microsoft_Word {
  public static void main(String[] args) {
    //Create a sentence and method variable and scanner class
    String sentence = "";
    String method = "";
    Scanner input = new Scanner(System.in);
    //Gets the sentence
    System.out.println("Enter the sentence");
    try{
      sentence = input.nextLine();
    }
    catch(Exception e){
      //
    }
    //Gets the function
    System.out.println("Enter a function F1, F2,...F7");
    System.out.println("F1: Get the number of words");
    System.out.println("F2: Get the number of characters");
    System.out.println("F3: Capitalize first letter of first word in the string");
    System.out.println("F4: Converts every uppercase in the string");
    System.out.println("F5: Converts every lowercase in the string");
    System.out.println("F6: Capitalises first letter of each word in the string");
    System.out.println("F7: Swap all cases in each sentence");
    System.out.println();
    try{
      System.out.print("Select a function F1,F2,...F7: ");
      method = input.nextLine();
    }
    catch(Exception e){
      //
    }
    //Pass the sentence through the selected method
    switch(method){
      case("F1"):
        F1(sentence);
        break;
      case("F2"):
        F2(sentence);
        break;
      case("F3"):
        System.out.println(F3(sentence));
        break;
      case("F4"):
        F4(sentence);
        break;
      case("F5"):
        F5(sentence);
        break;
      case("F6"):
        F6(sentence);
      break;
      case("F7"):
        F7(sentence);
        break;
      default:
      System.out.println("Invalid Input");
    }
  }//End of main method
  
  static void F1(String str){//Get the number of words
    if(str.length() == 0){
      System.out.println("You didn't enter a sentance");
    }else{
      int words = 1;
      for(int i = 0; i < str.length(); i++){
        if(str.charAt(i) == ' '){
          words++;
        }
      }
      System.out.printf("Your sentence has %d words.",words);
    }
  }
  
  static void F2(String str){//Get the number of characters
    System.out.printf("There are %d characters in your sentence.",str.length());
  }
  //capitalize first letter of first word in the string and prints new string 
  static String F3(String str){
    char temp = str.charAt(0);
    String first = "";
    first += Character.toUpperCase(temp);
    for(int i = 1; i < str.length(); i++){
      first += str.charAt(i);
    }
    return first;
  }
  //Converts every uppercase in the string
  static void F4(String str){
    System.out.println(str.toLowerCase());
  }
  //Converts every lowercase in the string
  static void F5(String str){
    System.out.println(str.toUpperCase());
  }
  //Capitalises first letter of each word in the string
  static void F6(String str){
    String result = "";
    for(int i = 0; i < str.length(); i++){
      if(str.charAt(i) == ' '){
        String prev = str.substring(0,i);
        result += (F3(prev) + " ");
        str = str.substring(i+1);
        i = 0;
        continue;
      }
      if(i == str.length()-1){
        String prev = str.substring(0);
        result += F3(prev);
      }
    }
    System.out.println(result);
  }
  //Swap all cases in each sentence
  static void F7(String str){
    String result = "";
    for(int i = 0; i < str.length(); i++){
      char temp = str.charAt(i);
      if(Character.isUpperCase(temp)){
        result += Character.toLowerCase(temp);
      }
      else{
        result += Character.toUpperCase(temp);
      }
    }
    System.out.println("Your swapped text is: " + result);
  }
}//End of Main class
