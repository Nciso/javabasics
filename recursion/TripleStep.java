
/**
* A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count howmany possible ways the child can run up to the stairs
*/


class TripleStep {

  public static int ways(int steps){
    if(steps < 0){
      return 0;
    }
    if(steps <= 1){
      return 1;
    }
    return ways(steps-1) + ways(steps-2) + ways(steps-3);
  }

 

  public static int waysMemo(int steps) {
    int []memo = new int[steps+1];
    Arrays.fill(memo, -1);
    return waysMemo(steps, memo);

  }

  public static int waysMemo(int steps, int[] memo){
    if(steps < 0) {
      return 0;
    }
    if(steps <= 1) {
      return 1;
    }
    if(memo[steps] == -1) {
      memo[steps] = waysMemo(steps-1, memo) + waysMemo(steps-2, memo) +waysMemo(steps-3, memo);
    }
    return memo[steps];

  }


  //public static void main(String[] args) {
  //  System.out.println(waysMemo(4));
  //}
}