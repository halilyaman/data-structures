package sorting.Insertion;

public class InsertionSort {
   public static void insertionSort(int[] array) {

      for(int i = 0; i < array.length; i++) {
         int iterator = i;
         while(iterator != 0) {
            if(array[iterator] < array[iterator-1]) {
               int temp = array[iterator];
               array[iterator] = array[iterator-1];
               array[iterator-1] = temp;
            }
            iterator--;
         }
      }
   }
}
