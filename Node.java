/*
 * Node Class Implementation
 */
public class Node {
  
  private Node left;
  private Node right;
  private Integer key;
  
  // Constructor
  public Node(Integer key)
  {
    this.key = key;
    left = null;
    right = null;
    
  }
  
  // Set Left Node
  public void setLeft(Node left){
    this.left = left;
  }
  
  // Set Right Node
  public void setRight(Node right){
    this.right = right;
  }
  
  // Get Left Node
  public Node getLeft(){
    return left;
  }
  
  // Get Right Node
  public Node getRight(){
    return right;
  }
  
  // Set Node Key
  public void setKey(Integer k) {
    this.key = k;
  }
  
  // Get Node Key
  public Integer getKey() {
    return key;
  }
  
  // Print Node
  public void print() {
    if (key != null) {
      System.out.print(key+" ");
    }
  }
}