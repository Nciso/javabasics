package stacksNqueues;
import nodes.GenericNode;

class Queue<T> {

  GenericNode<T> first;
  GenericNode<T> last;

  public Queue(){
    GenericNode<T> first = null;
    GenericNode<T> last = first;
  }

  public void add(T data){
    GenericNode<T> node = new GenericNode<T>(data);
    if(last == null){
      this.last = node;
      this.first = this.last;
    }

    this.last.setNext(node);
    this.last = node;
  }

  public T remove(){
    if(this.first == null){
      return null;
    }
    GenericNode<T> node = this.first;
    this.first = this.first.getNext();
    return node.getData();
  }

  public T peek(){
    if(this.first == null){
      return null;
    }
    return this.first.getData();
  }

  public boolean isEmpty(){
    return this.first == null;
  }

  public String toString(){
    if(this.isEmpty()){
      return "[EMPTY]";
    }
    GenericNode<T> node = this.first;
    String pr = "current queue: \n";
    while(node != null){
      pr += node.getData() + " ";
      node = node.getNext();
    }
   
    return pr;
  }

  public static void main(String[] args) {
   Queue<Integer> q = new Queue<Integer>();

   q.add(3);
   q.add(2);
   q.add(1);

   System.out.println(q);
   System.out.println("removed: "+ q.remove());
   System.out.println(q);
   System.out.println(q.peek()); //2
   while(!q.isEmpty()){
     System.out.println("removed: "+ q.remove());
   }
   System.out.println(q);
  }
}