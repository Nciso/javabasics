import nodes.Node;
class RemoveMiddle {

  public static void deleteNode(Node n) {
    if(n == null || n.next == null){
      return;
    }
    Node next = n.next;
    n.data = next.data;
    n.next = next.next;
    next.next = null;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(1);
    Node middle = new Node(4);
    head.next.next.next = middle;
    middle.next = new Node(2);
    middle.next.next = new Node(2);
    middle.next.next.next = new Node(1);

    Node.printList(head);
    deleteNode(middle);
    Node.printList(head);

  }
} 