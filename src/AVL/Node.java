package AVL;

public class Node {
   int key, height;
   Node left = null, right = null;
   Node(int key) {
      this.key = key;
      height = 1;
   }
}
