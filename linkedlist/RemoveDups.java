import java.util.HashSet;
import nodes.Node;

class RemoveDups {

  // bigO: space O(n) time O(n)
  public static void removeDups(Node head){
    HashSet<Integer> buffer = new HashSet<Integer>();
    Node runner = head;
    if(head == null){
      return;
    }else {
      buffer.add(head.data);
    }

    while(runner != null && runner.next != null) { // todo: check final node condition
      if(buffer.contains(runner.next.data)){
        runner.next = runner.next.next;
      }else {
        buffer.add(runner.data);
        runner = runner.next;
      }
    }
  }

  //Big O: space(1) time(n^2)
  public static void removeDupsNoSpace(Node head){
    if(head == null){
      return;
    }

    Node runner1 = head;
    Node runner2 = head;

    while(runner1.next != null){
      while(runner2 != null && runner2.next != null){
        if(runner1.data == runner2.next.data) {
          runner2.next = runner2.next.next;
        }else{
          runner2 = runner2.next;
        }
      }
      runner1 = runner1.next;
      runner2 = runner1;
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

    //removeDups(head);
    removeDupsNoSpace(head);
    System.out.println("remove dups");
    Node.printList(head);

    


  }
}