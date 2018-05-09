import java.util.Scanner;

/*
 *  Executable Class
 *  Binary Search Tree (BST) Console Application
 */
public class BSTApp {
 
  // Begin of main method 
  public static void main(String[] args) {
    
  
	BST bst = new BST();
    Scanner s = new Scanner(System.in);
    String input;
    
    System.out.print("Please enter the initial sequence of values: ");
    input = s.nextLine();
  
    for (String i: input.split("\\s+")) {
      try {
        bst.insert(Integer.parseInt(i));
      } catch (Exception e) {
        System.out.println(i+" is invalid input, ignore.");
      }
    }
    
    // Print three traversals
    bst.printPreOrder();
    bst.printInOrder();
    bst.printPostOrder();
   
    while (true) {
      System.out.print("Command? ");
      input = s.nextLine();
      char cmd = input.toLowerCase().toCharArray()[0]; 
      
      // If E, then terminate
      if (cmd == 'e') {
        System.out.println("Thank you for using my program!");
        return;
      
        // If H, print menu
      } else if (cmd == 'h') {
        System.out.println("I	Insert a value");
        System.out.println("D	Delete a value");
        System.out.println("P	Find predecessor");
        System.out.println("S	Find successor");
        System.out.println("E	Exit the program");
        System.out.println("H	Display this message");
        continue;
      }
     
      // Identify key from user input
      Integer key;
      try {
        key = Integer.parseInt(input.split("\\s+")[1]);
      } catch (Exception e) {
        System.out.println(input+" is an invalid command.");
        continue;
      }
    
      // If I, attempt to insert key 
      if (cmd == 'i') {
        if (bst.contains(key)) {
          System.out.println(key+" already exists, ignore.");
        } else {
          bst.insert(key);
          bst.printInOrder();
        }
     
        // If D, attempt to delete key
      } else if (cmd == 'd') {
        if (bst.contains(key)) {
          bst.delete(key);
          bst.printInOrder();
        } else {
          System.out.println(key+" doesn't exist!");
        }
      
       // If P, attempt to find predecessor of key
      } else if (cmd == 'p') {
        if (bst.contains(key)) {
          System.out.println(bst.predecessor(key));
        } else {
          System.out.println(key+" doesn't exist!");
        }
     
        // If S, attempt to find successor of key
      } else if (cmd == 's') {
        if (bst.contains(key)) {
          System.out.println(bst.successor(key));
        } else {
          System.out.println(key+" doesn't exist!");
        }
      } else {
        System.out.println(input+"is an unrecognized command.");
      }
    }
  }
}