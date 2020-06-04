// javac -cp Stack.java ../nodes/GenericNode.java
/*
From the upper directory
call javac stacksNqueues/Stack.java nodes/GenericNode.java
then: java stacksNqueues/Stack
*/
package stacksNqueues;
import nodes.GenericNode;
class Stack<T> {
  GenericNode<T> top;

  public Stack(){
    this.top = null;
  }

  public void push(T data){
    GenericNode<T> n = new GenericNode<T>(data);
    if(this.top == null){
      this.top = n;
    }else {
      n.setNext(top);
      top = n;
    }
  }

  public T pop(){
    GenericNode<T> tmp = this.top;
    this.top = this.top.getNext();
    return tmp.getData();

  }

  public T peek() {
    return top.getData();
  }

  public boolean isEmpty() {
    return this.top == null;
  }
  
  public String toString(){
    if(this.isEmpty()){
      return "[EMPTY]";
    }
    GenericNode<T> tmp = this.top;
    String pr =  "Current data: \n";
    while(tmp != null){
      pr += tmp.toString() + " ";
      tmp = tmp.getNext();
    }
    return pr;
  }

  public static void main(String[] args){
    Stack<Integer> s = new Stack<Integer>();
    s.push(1);
    s.push(5);
    s.push(7);
    System.out.println(s);
    int removed = s.pop();
    System.out.println(s);
    System.out.println("elem removed: "+ removed );
    System.out.println("top element: " +s.peek());
    System.out.println(s);
    System.out.println("emptying...");
    while(!s.isEmpty()){
      System.out.println("elem removed: " + s.pop());
    }
    System.out.println(s);
    
  }
}