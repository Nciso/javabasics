import nodes.Node;
class KthLast {
  
  public static int counter = 0;
  public static Node findIndex(Node head, int k){
     if(head == null){
      return null;
    }
    head = head.next;
    Node index = findIndex(head, k);
    counter++;
    //if(head != null){
    //  System.out.println("the k index: " + (index-1) + " contains: " +head.data);
   // }
    if(counter == k){
      System.out.println("the k index: " + k + " contains: " +head.data);
      return head;
    }else {
      return index;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(1);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(2);
    head.next.next.next.next.next = new Node(2);
    head.next.next.next.next.next.next = new Node(1);

    Node.printList(head);
    int backwardIndex = 4;
    System.out.println("find el with kth: "+ backwardIndex);
    Node found = findIndex(head, backwardIndex);
    System.out.println(found.data);
  }  
}