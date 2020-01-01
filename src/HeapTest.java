import Heap.MinHeap;

public class HeapTest {
   public static void main(String[] args) {
      MinHeap heap = new MinHeap(10);
      while(!heap.isFull()) {
         heap.insert((int) (Math.random() * 100 + 1));
      }
      while(!heap.isEmpty()) {
         System.out.print(heap.remove() + " ");
      }
   }
}
