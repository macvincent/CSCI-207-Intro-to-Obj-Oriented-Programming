#include <iostream>
#include <vector>
using namespace std;

vector<int> mergeSort(vector<int>);
vector<int> merge(vector<int>,vector<int>);

int main() {
  vector<int> arr = {0,1,2};
  arr = mergeSort(arr);
  for(auto i : arr){
    cout<<i<<' ';
  }
}
//In this method we receive the list to be sorted
vector<int> mergeSort(vector<int> arr){
  int n = arr.size();
  //When the list is down to just one element we return it and start merging
  if(n <= 1){
    return arr;
  }
  //If the array has more than one element we split it in half
  vector<int> l1(arr.begin(),arr.begin()+n/2);
  vector<int> l2(arr.begin()+n/2,arr.end());
  //We recursively continue the splitting the halves
  l1 = mergeSort(l1);
  l2 = mergeSort(l2);
  //we merge and return the sorted halves
  return merge(l1,l2);
}

//This method performs the merging
vector<int>merge(vector<int> l1, vector<int> l2){
  vector<int> merged;
  /*We consider only the  first elements in the two arrays which would definitely contain the largest elements in each of the list , add the largest to the merged list and delete it from its original position. This process continues until one of the lists is empty*/
  while(l1.size() != 0 && l2.size() != 0){
    if(l1[0] > l2[0]){
      merged.push_back(l1[0]);
      l1.erase(l1.begin());
    }else{
      merged.push_back(l2[0]);
      l2.erase(l2.begin());
    }
  }
  //The next two while loops takes the elements of the sorted non-empty list and adds it to the merged list
  while(l1.size() != 0){
    merged.push_back(l1[0]);
    l1.erase(l1.begin());
  }
  while(l2.size() != 0){
    merged.push_back(l2[0]);
    l2.erase(l2.begin());
  }
  //we return the sorted merged list
  return merged;
}
//Merge sort is a safe bet because apart from the fact tha we would be sorting a list of numbers, we no nothing else about the form of the input. We use merge as compared to quick sort, because we are sure of an O(nlogn) time complexity.