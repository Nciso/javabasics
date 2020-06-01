import java.util.ArrayList;

class RobotGrid {

  static boolean findPath(
      int row, 
      int col, 
      boolean[][] maze, 
      ArrayList<Point> path,
      ArrayList<Point> failedPoints
    ){
    if(
      row < 0 || 
      col < 0 || 
      row >= maze.length || 
      col >= maze.length || 
      !maze[row][col]
    ){
      return false;
    }
    
    boolean isOrigin = row == 0 && col == 0;

    Point n = new Point(row, col);
    if(failedPoints.contains(n)){
      return false;
    }

    if(
      isOrigin || 
      findPath(row-1, col, maze, path, failedPoints) || 
      findPath(row, col-1, maze, path, failedPoints)
    ){
      path.add(n);
      return true;
    }else {
      failedPoints.add(n);
      return true;
    }
  }

  
  static ArrayList<Point> findPath(boolean[][] maze){
     ArrayList<Point> path = new ArrayList<Point>();
     ArrayList<Point> failedPoints = new ArrayList<Point>();
     
     if(findPath(maze.length-1, maze[0].length-1, maze, path, failedPoints)){
       return path;
     }
     return null;    
  }

  public static void main(String[] args){
    System.out.println("initialize");
    boolean[][] maze = {
      {true, false, false},
      {true, true, false},
      {false, true, true}
    };
  
    ArrayList<Point> path = findPath(maze);
    
    for(Point p: path){
      System.out.println(p);
    }
  }
}

class Point {
  int row;
  int col;

  Point(int row, int col){
    this.row = row;
    this.col = col;
  }

  public String toString(){
    return "r: " + this.row +" c: " + this.col;
  }
}