import heap.MinHeap;

public class HeapTest {
   public static void main(String[] args) {
      MinHeap heap = new MinHeap(1000);
      while(!heap.isFull()) {
         heap.insert((int) (Math.random() * 1000 + 1));
      }
      while(!heap.isEmpty()) {
         System.out.print(heap.remove() + " ");
      }
   }
}
