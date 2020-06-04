// run this program with javac -cp LoopDetection.java ../nodes/Node.java then java LoopDetection
import nodes.Node;

class LoopDetection {
  
  static Node detectLoop(Node head){
    if(head == null || head.next == null ){
      return null;
    }
    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if(fast == slow){
        break;
      }
    }
    if(fast.next == null || fast == null){
      return null;
    }

    System.out.println("collision at node: " + fast.data);

    fast = head;
    while(slow !=fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    Node initialLoop = new Node(4);
    head.next.next.next = initialLoop;
    initialLoop.next = new Node(5);
    initialLoop.next.next = new Node(6);
    initialLoop.next.next.next = new Node(7);
    initialLoop.next.next.next.next = new Node(8);
    initialLoop.next.next.next.next.next = new Node(9);
    initialLoop.next.next.next.next.next.next = new Node(10);
    initialLoop.next.next.next.next.next.next.next = new Node(11); 
    initialLoop.next.next.next.next.next.next.next.next = initialLoop;

    Node loopDetected = detectLoop(head);
    System.out.println("loop detected at node with value: " +  loopDetected.data);
  }
}