import java.util.Scanner;

class Node {
  int value;
  Node left;
  Node right;

  public Node(int value) {
    this.value = value;
    this.left = this.right = null;
  }
}

class BinarySearchTree {
  Node root;

  public void insert(int value) {
    root = insertRec(root, value);
  }

  private Node insertRec(Node root, int value) {
    if (root == null)
      return new Node(value);

    if (value < root.value) {
      root.left = insertRec(root.left, value);
    } else {
      root.right = insertRec(root.right, value);
    }

    return root;
  }

  public boolean isBalanced() {
    return isBalancedRec(root) != -1;
  }

  private int isBalancedRec(Node root) {
    if (root == null)
      return 0;

    int leftHeight = isBalancedRec(root.left);
    int rightHeight = isBalancedRec(root.right);

    if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }

    return Math.max(leftHeight, rightHeight) + 1;
  }
}

public class ExerciseB {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    BinarySearchTree bst = new BinarySearchTree();

    // Leitura e inserção dos valores na árvore
    for (int i = 0; i < n; i++) {
      bst.insert(scanner.nextInt());
    }

    // Verifica se a árvore é balanceada e imprime o resultado
    System.out.println(bst.isBalanced() ? 1 : 0);

    scanner.close();
  }
}
