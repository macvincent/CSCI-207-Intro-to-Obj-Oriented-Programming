import java.util.*;
public class NumChar {
  public static void main(String[] args) {
    System.out.print("Input the Phrase: ");
    Scanner input = new Scanner(System.in);
    String a = input.nextLine();
    System.out.printf("What character are you looking for: ");
    char k = input.nextLine().charAt(0);

    int total = 0;
    for(int i = 0; i < a.length(); i++){
      if(k == a.charAt(i))total++;
    }
    System.out.printf("Your character %C appeared %d times",k,total);

    input.close();
  }
}