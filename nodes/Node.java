package nodes;

public class Node {
  int data;
  Node next = null;
  public Node(int data) {
    this.data = data;
  }

  public static void printList(Node head) {
   
    Node runner = head;
    while(runner != null) {
      System.out.print(runner.data+ " ");
      runner = runner.next;
    }
    System.out.println();
  }
}