package sorting.Merge;

public class MergeSort {

   public static int[] mergerSort(int[] array) {
      int[] tempArray = new int[array.length];
      mergeSort(array, tempArray, 0, array.length-1);
      return array;
   }

   private static void mergeSort(int[] array, int[] tempArray, int left, int right) {
      if(left < right) {
         int center = (left + right) / 2;
         mergeSort(array, tempArray, left, center);
         mergeSort(array, tempArray, center+1, right);
         merge(array, tempArray, left, center+1, right);
      }
   }

   private static void merge(int[] array, int[] tempArray, int leftStart, int rightStart, int rightEnd) {
      int leftEnd = rightStart - 1;
      int currentPosition = leftStart;
      int numberOfElement = rightEnd - leftStart + 1;

      // Copy until one half is finished.
      while(leftStart <= leftEnd && rightStart <= rightEnd) {
         if(array[leftStart] < array[rightStart]) {
            tempArray[currentPosition++] = array[leftStart++];
         } else {
            tempArray[currentPosition++] = array[rightStart++];
         }
      }

      // Copy rest of left half
      while(leftStart <= leftEnd) {
         tempArray[currentPosition++] = array[leftStart++];
      }

      // Copy rest of right half
      while(rightStart <= rightEnd) {
         tempArray[currentPosition++] = array[rightStart++];
      }

      for(int i = 0; i < numberOfElement; i++, rightEnd--) {
         array[rightEnd] = tempArray[rightEnd];
      }
   }
}
