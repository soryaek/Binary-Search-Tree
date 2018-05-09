/*
 * Binary Search Tree (BST) Class Implementation
 */
public class BST {
  
  private Node root;
  
  // Constructor
  public BST() {
  }
  
  // Contains method
  public boolean contains(Integer key) {
    return search(key) != null;
  }
  
  // Search method
  public Integer search(Integer key) {
    return search(root, key);
  }
  
  // Search method RECURSIVE
  private Integer search(Node n, Integer key) {
    if (n == null) {
      return null;
    } else if (key < n.getKey()) {
      return search(n.getLeft(), key);
    } else if (key > n.getKey()) {
      return search(n.getRight(), key);
    } else {
      return n.getKey();
    }
  }
  
  // Insert method
  public void insert(Integer key) {
    root = insert(root, key);
  }
  
  // Insert method recurvsive
  private Node insert(Node n, Integer key) {
    if (n == null) {
      return new Node(key);
    } else if (key < n.getKey()) {
      n.setLeft(insert(n.getLeft(), key));
    } else if (key > n.getKey()) {
      n.setRight(insert(n.getRight(), key));
    }
    return n;
  }
  
  // Delete method
  public void delete(Integer key) {
    root = delete(root, key);
  }
  
  // Delete method recursive
  private Node delete(Node n, Integer key) {
    if (n == null) {
      return null;
    } else if (key < n.getKey()) {
      n.setLeft(delete(n.getLeft(), key));
    } else if (key > n.getKey()) {
      n.setRight(delete(n.getRight(), key));
    } else {
      if (n.getRight() == null) {
        return n.getLeft();
      } else if (n.getLeft() == null) {
        return n.getRight();
      }
      Node m = n;
      n = min(m.getRight());
      n.setRight(deleteMin(m.getRight()));
      n.setLeft(m.getLeft());
    }
    return n;
  }
  
  // min helper method
  private Node min(Node n) {
    if (n.getLeft() == null) {
      return n;
    } else {
      return min(n.getLeft());
    }
  }
  
  // deleteMin helper method
  private Node deleteMin(Node n) {
    if (n.getLeft() == null) {
      return n.getRight();
    }
    n.setLeft(deleteMin(n.getLeft()));
    return n;
  }
  
  // predecessor method
  public Integer predecessor(Integer key) {
    Node n = predecessor(root, key);
    if (n == null) {
      return null;
    } else {
      return n.getKey();
    }
  }
  
  // predecessor method recursive
  private Node predecessor(Node n, Integer key) {
    if (n == null) {
      return null;
    } else if (key <= n.getKey()) {
      return predecessor(n.getLeft(), key);
    } else {
      Node m = predecessor(n.getRight(), key);
      if (m != null) {
        return m;
      } else {
        return n;
      }
    }
  }
  
  // successor method
  public Integer successor(Integer key) {
    Node n = successor(root, key);
    if (n == null) {
      return null;
    } else {
      return n.getKey();
    }
  }
  
  // successor method recursive
  private Node successor(Node n, Integer key) {
    if (n == null) {
      return null;
    } else if (key < n.getKey()) {
      Node m = successor(n.getLeft(), key);
      if (m != null) {
        return m;
      } else {
        return n;
      }
    } else {
      return successor(n.getRight(), key);
    }
  }
  
  // Print PreOrder method
  public void printPreOrder() {
    System.out.print("Pre-order: ");
    printPreOrder(root);
    System.out.print("\n");
  }
  
  // Print PreOrder method recursive
  private void printPreOrder(Node n) {
    if (n != null) {
      n.print();
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
    }
  }
  
  // Print InOrder method
  public void printInOrder() {
    System.out.print("In-order: ");
    printInOrder(root);
    System.out.print("\n");
  }
  
  // Print InOrder method recursive
  private void printInOrder(Node n) {
    if (n != null) {
      printInOrder(n.getLeft());
      n.print();
      printInOrder(n.getRight());
    }
  }
  
  // Print PostOrder method
  public void printPostOrder() {
    System.out.print("Post-order: ");
    printPostOrder(root);
    System.out.print("\n");
  }
  
  // Print PostOrder method recursive
  private void printPostOrder(Node n) {
    if (n != null) {
      printPostOrder(n.getLeft());
      printPostOrder(n.getRight());
      n.print();
    }
  }
  
}