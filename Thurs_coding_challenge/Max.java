import java.util.Scanner;
class Max{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int temp = 0;
    int max1, max2;//max1 is greatest and max2 second greatest
//we receive the first number and assign
  System.out.print("Input a number: ");
  temp = input.nextInt();
  max1 = temp;
//Here we receive the second number
  System.out.print("Input a number: ");
  temp = input.nextInt();
//if the number is greater 
  if(temp > max1){
        max2 = max1;//we assign max1 to max 2
        max1 = temp;//then we assign that number to max2
  }else{
        max2 = temp;
  }
//now we receive the three numbers
    for(int i = 0; i<3; i++){
      System.out.print("Input a number: ");
      temp = input.nextInt();
      if(temp > max1){//if the number is greater than max1
        max2 = max1;//we assign max2 to max1
        max1 = temp;//assign the number to max1
      }else if(temp > max2){// else if the number is greater than max2
        max2 = temp;//we assign the number to max2
      }
    }

    System.out.printf("The maximum numbers are %d and %d",max1,max2);//we print out the maximum numbers
  }
}