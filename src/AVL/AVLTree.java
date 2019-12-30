package AVL;

public class AVLTree {
   public Node root;

   // utility function to get the height of tree
   public int getHeight(Node tree) {
      if(tree == null) {
         return 0;
      } else {
         return tree.height;
      }
   }

   // utility function to find the greatest one of two integers
   public int findMax(int a, int b) {
      return Math.max(a, b);
   }

   public Node rightRotate(Node pivotTree) {
      Node leftOfPivot = pivotTree.left;
      Node rightOfLeft = leftOfPivot.right;

      // Perform rotation
      leftOfPivot.right = pivotTree;
      pivotTree.left = rightOfLeft;

      // update heights
      pivotTree.height = findMax(getHeight(pivotTree.left), getHeight(pivotTree.right)) + 1;
      leftOfPivot.height = findMax(getHeight(leftOfPivot.left), getHeight(leftOfPivot.right)) + 1;

      // return new root
      return leftOfPivot;
   }

   public Node leftRotate(Node pivotNode) {
      Node rightOfPivot = pivotNode.right;
      Node leftOfRight = rightOfPivot.left;

      // Perform rotation
      pivotNode.right = leftOfRight;
      rightOfPivot.left = pivotNode;

      // update heights
      pivotNode.height = findMax(getHeight(pivotNode.right), getHeight(pivotNode.right)) + 1;
      rightOfPivot.height = findMax(getHeight(rightOfPivot.left), getHeight(rightOfPivot.right)) + 1;

      // return new root
      return rightOfPivot;
   }

   // get the difference of height of right and left trees
   public int getBalance(Node node) {
      return ( getHeight(node.left) - getHeight(node.right) );
   }

   public Node insert(Node tree, int key) {
      // Perform normal BST insertion
      if(tree == null) {
         return new Node(key);
      }

      if(key < tree.key) {
         tree.left = insert(tree.left, key);
      } else if(key > tree.key) {
         tree.right = insert(tree.right, key);
      } else {
         return tree;
      }

      // update height of tree
      tree.height = 1 + findMax(getHeight(tree.right), getHeight(tree.left));

      // Get balance factor
      int balance = getBalance(tree);

      // Left-Left Case
      if(balance > 1 && key < tree.left.key) {
         return rightRotate(tree);
      }

      // Left-Right Case
      if(balance > 1 && key > tree.left.key) {
         tree.left = leftRotate(tree.left);
         return rightRotate(tree);
      }

      // Right-Right Case
      if(balance < -1 && key > tree.right.key) {
         return leftRotate(tree);
      }

      // Right-Left Case
      if(balance < -1 && key < tree.right.key) {
         tree.right = rightRotate(tree.right);
         return leftRotate(tree);
      }

      // there is no unbalanced situation, return unchanged tree
      return tree;
   }

   public Node minValueNode(Node tree) {
      Node current = tree;
      while(current.left != null) {
         current = current.left;
      }
      return current;
   }

   public void inorder(Node tree) {
      if(tree != null) {
         inorder(tree.left);
         System.out.println("Key: " + tree.key + " Height: " + tree.height);
         inorder(tree.right);
      }
   }

   public void postorder(Node tree) {
      if(tree != null) {
         inorder(tree.left);
         inorder(tree.right);
         System.out.println("Key: " + tree.key + " Height: " + tree.height);
      }
   }

   public void preorder(Node tree) {
      if(tree != null) {
         System.out.println("Key: " + tree.key + " Height: " + tree.height);
         inorder(tree.left);
         inorder(tree.right);
      }
   }
}
