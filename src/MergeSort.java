public class MergeSort {
private int[] numbers;
  private int[] helper;

  private int number;

  public void sort(int[] values) {
    this.numbers = values;
    number = values.length;
    this.helper = new int[number];
    divide(0, number - 1);
  }

  private void divide(int low, int high) {
	
	   if(low>=high){
		   return;
	   }
      //Retreive mid.
      int middle = low + (high - low) / 2;
      //Sort first half and second hald separately.
      divide(low, middle);
      divide(middle + 1, high);
      //Merge the 2 sorted halves.
      conquer(low, middle, high);
   
  }

  private void conquer(int low, int middle, int high) {

    // Copy both parts into the helper array
    for (int i = low; i <= high; i++) {
      helper[i] = numbers[i];
    }

    int i = low;
    int j = middle + 1;
    int k = low;
    // Copy the smallest values from either the left or the right side back
    // to the original array
    while (i <= middle && j <= high) {
      if (helper[i] <= helper[j]) {
        numbers[k] = helper[i];
        i++;
      } else {
        numbers[k] = helper[j];
        j++;
      }
      k++;
    }
    // Copy the rest of the left side of the array into the target array
    while (i <= middle) {
      numbers[k] = helper[i];
      k++;
      i++;
    }

  }
  
  public static void main(String args[]){
	  int[] toSort = {1,45,34,67,23,98,980,424,124,73,42,31,11,16,8};
	  MergeSort m = new MergeSort();
	  m.sort(toSort);
	  System.out.println("The sorted array is: ");
	 for(int i=0;i<m.numbers.length;i++){
		 System.out.print(m.numbers[i]+" ");
	 }
  }
}