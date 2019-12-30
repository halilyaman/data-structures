import AVL.AVLTree;

public class Test {
   public static void main(String[] args) {
      AVLTree tree = new AVLTree();

      tree.root = tree.insert(tree.root, 10);
      tree.root = tree.insert(tree.root, 20);
      tree.root = tree.insert(tree.root, 30);
      tree.root = tree.insert(tree.root, 40);
      tree.root = tree.insert(tree.root, 80);
      tree.root = tree.insert(tree.root, 90);
      tree.root = tree.insert(tree.root, 100);
      tree.root = tree.insert(tree.root, 110);
      tree.root = tree.insert(tree.root, 120);
      tree.root = tree.insert(tree.root, 50);
      tree.root = tree.insert(tree.root, 60);
      tree.root = tree.insert(tree.root, 70);

      System.out.println("\nIn-order:");
      tree.inorder(tree.root);

      System.out.println("\nPost-order:");
      tree.postorder(tree.root);

      System.out.println("\nPre-order:");
      tree.preorder(tree.root);
   }
}
