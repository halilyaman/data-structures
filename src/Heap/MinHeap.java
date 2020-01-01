package Heap;

public class MinHeap {
   private int[] heapArray;
   private int size;
   private int maxSize;

   private final int FIRST_ELEMENT = 1;

   public MinHeap(int maxsize){
      this.maxSize = maxsize;
      heapArray = new int[maxsize + 1];
      this.size = 0;
      heapArray[0] = Integer.MIN_VALUE;
   }

   private int getParentPosition(int position) {
      return (position / 2);
   }

   private int getLeftChildPosition(int position) {
      return (2 * position);
   }

   private int getRightChildPosition(int position) {
      return (2 * position + 1);
   }

   private boolean isLeaf(int position) {
      return position <= size && position > (size / 2);
   }

   private void swapElements(int firstPosition, int secondPosition) {
      int temp = heapArray[firstPosition];
      heapArray[firstPosition] = heapArray[secondPosition];
      heapArray[secondPosition] = temp;
   }

   private void minHeapify(int position) {
      if(!isLeaf(position)) {
         int parent = heapArray[position];
         int leftChild;
         int rightChild;

         if(getLeftChildPosition(position) <= size) {
            leftChild = heapArray[getLeftChildPosition(position)];
         } else {
            leftChild = Integer.MAX_VALUE;
         }

         if(getRightChildPosition(position) <= size) {
            rightChild = heapArray[getRightChildPosition(position)];
         } else {
            rightChild = Integer.MAX_VALUE;
         }

         if (parent > rightChild || parent > leftChild) {
            if (leftChild < rightChild) {
               swapElements(position, getLeftChildPosition(position));
               minHeapify(getLeftChildPosition(position));
            } else {
               swapElements(position, getRightChildPosition(position));
               minHeapify(getRightChildPosition(position));
            }
         }
      }
   }

   public void insert(int value) {
      if(size < maxSize) {
         heapArray[++size] = value;

         int currentPosition = this.size;
         while(value < heapArray[getParentPosition(currentPosition)]) {
            swapElements(currentPosition, getParentPosition(currentPosition));
            currentPosition = getParentPosition(currentPosition);
         }
      } else {
         System.out.println(value + " can not be inserted because heap is full!");
      }
   }

   public int remove() {
      if(!isEmpty()) {
         int deleted = heapArray[FIRST_ELEMENT];
         heapArray[FIRST_ELEMENT] = heapArray[size--];
         minHeapify(FIRST_ELEMENT);
         return deleted;
      }
      return -1;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public boolean isFull() {
      return size == maxSize;
   }
}
