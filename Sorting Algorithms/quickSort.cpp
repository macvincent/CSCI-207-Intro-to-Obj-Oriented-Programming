  #include <iostream>
  using namespace std;
  //This function takes array elements by reference and swaps their values
  void swap (int& a, int& b){
    int temp = a;
    a = b;
    b = temp;
  }
  /* 
  This our quick sort function, the parameters
  arr = a pointer to the array list to be sorted
  l = leftmost index
  r = rightmost index
  */
  void qSort(int* arr, int l, int r){
    //If the list has one element that it is already sorted so we return
    if(l >= r){
      return;
    }
    //We declare a pointer to hold the value of the leftmost index 
    int ptr = l;
    //We set our pivot to be the element at the most extreme position
    int pivot = arr[r];
    //We use a for loop to run through all the elements in the list
    for(int i = l; i <= r; i++){
      //if any element is greater than or equal to the pivot value we take it to the left of the pivot using our pointer ptr
      if(arr[i] >= pivot){
        swap(arr[i], arr[ptr]);
        ptr++;
      }
    }
    //We recursively sort the elements to the left and right of the pivot
    qSort(arr,l,ptr-2);
    qSort(arr,ptr,r);
  }
 /* I considered two options: quicksort and mergesort. I chose quicksort for various reasons:
1. Time complexity: I made an assumption that the list of numbers would not be already sorted. In that case
	we are sure of a O(nlogn) for the quicksort, wich is similar to merge sort's O(nlogn).
2. Space complexity: Merge sort will uses O(n) since it's not a linked list while quick sort only uses O(logn) space.
 	And since the size of the list is not specified quicksort is a better bet.
 */