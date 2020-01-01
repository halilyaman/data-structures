package sorting.MergeSort;

public class MergeSortTest {
   public static void main(String[] args) {
      int[] myArray = new int[1000];

      for(int i = 0; i < 1000; i++) {
         myArray[i] = (int) (Math.random() * 1000 + 1);
      }

      myArray = MergeSort.mergerSort(myArray);

      for(int i = 0; i < myArray.length; i++) {
         System.out.print(myArray[i] + " ");
      }
   }
}
