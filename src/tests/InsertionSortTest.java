package tests;

import sorting.Insertion.InsertionSort;

public class InsertionSortTest {
   public static void main(String[] args) {
      int[] array = new int[]{29, 37, 17, 2, 7, 11, 23};
      InsertionSort.insertionSort(array);
      for(int i = 0; i < array.length; i++) {
         System.out.print(array[i] + " ");
      }
   }
}
