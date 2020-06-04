package nodes;

public class GenericNode<T> {
  private T data;
  GenericNode<T> next = null;
  public GenericNode(T data) {
    this.data = data;
  }

  public void setNext(GenericNode<T> n){
    this.next = n;
  }

  public GenericNode<T> getNext(){
    return this.next;
  }

  public T getData() {
    return this.data;
  }

  public String toString(){
    return data.toString();
  }

  

  
}