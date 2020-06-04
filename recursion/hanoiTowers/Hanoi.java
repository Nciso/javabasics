import java.util.Stack;

class Hanoi {


  public static void move(
    Stack<Integer> origin,
    Stack<Integer> buffer,
    Stack<Integer> destination,
    int disks
  ){
    if(disks == 0) {
      return;
    }

    if(disks == 1) {
     int currentDisk = origin.pop();
     destination.push(currentDisk); 
    }
    if(disks == 2) {
      int currentDisk = origin.pop();
      buffer.push(currentDisk);
      currentDisk = origin.pop();
      destination.push(currentDisk);
      currentDisk = buffer.pop();
      destination.push(currentDisk);
    }

    if(disks > 2){
      int diskToBuffer = disks -1;
      move(origin, destination, buffer, diskToBuffer);
      move(origin, buffer, destination, 1);
      move(buffer, origin, destination, diskToBuffer);
    }
  }

  public static void main(String[] args) {

    Stack<Integer> origin = new Stack<Integer>();
    Stack<Integer> buffer = new Stack<Integer>();
    Stack<Integer> destination = new Stack<Integer>();

    origin.push(5);
    origin.push(4);
    origin.push(3);
    origin.push(2);
    origin.push(1);

  //origin tower is from bottom to top: 5,4,3,2,1

    int quantity = 5;

    move(origin, buffer, destination, quantity);

    System.out.println("destination");
    int position = 1;
    while(!destination.empty()){
      System.out.println("disk " +position+ ": " + destination.pop());
      position++;
    }
  }
}