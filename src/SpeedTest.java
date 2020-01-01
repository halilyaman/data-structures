import heap.MinHeap;
import sorting.MergeSort.MergeSort;

public class SpeedTest {
   final static int ARRAY_SIZE = 1000000;

   public static void main(String[] args) {
      int[] array1 = new int[ARRAY_SIZE];
      int[] array2 = new int[ARRAY_SIZE];

      fillArrayWithRandomIntegers(array1, ARRAY_SIZE);
      fillArrayWithRandomIntegers(array2, ARRAY_SIZE);

      long start_time = System.currentTimeMillis();

      heap_sort(array1);
      long end_time_1 = System.currentTimeMillis();

      merge_sort(array2);
      long end_time_2 = System.currentTimeMillis();

      System.out.println("\nHeap Sort Time: " + (end_time_1 - start_time) + "\n");
      System.out.println("\nMerge Sort Time: " + (end_time_2 - end_time_1) + "\n");
   }

   private static void heap_sort(int[] array) {
      MinHeap heap = new MinHeap(ARRAY_SIZE);
      for(int i = 0; i < ARRAY_SIZE; i++) {
         heap.insert(array[i]);
      }
      for(int i = 0; i < ARRAY_SIZE; i++) {
         array[i] = heap.remove();
      }
   }

   private static void merge_sort(int[] array) {
      MergeSort.mergerSort(array);
   }

   public static void fillArrayWithRandomIntegers(int[] array, int size) {
      for(int i = 0; i < size; i++) {
         array[i] = (int)(Math.random() * size);
      }
   }
}
