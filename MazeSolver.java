


public class MazeSolver {
    private StackRefBased<MazeLocation> stack;
    boolean locations[][];


    public static String findPath(Maze maze) {

        String result = "";
        StackRefBased<MazeLocation>	stack = new StackRefBased<MazeLocation>();
        boolean [][] visited = new boolean[maze.getNumRows()][maze.getNumCols()];
        MazeLocation curr;

        stack.push(maze.getEntry());
        try {
          while(!stack.isEmpty() && !stack.peek().equals(maze.getExit())) {
            	curr = stack.peek();
              visited[curr.getRow()][curr.getCol()] = true;
              if(curr.getRow() != 0 && visited[curr.getRow()-1][curr.getCol()] == false
  						&& !maze.isWall(curr.getRow()-1, curr.getCol())) {
      					stack.push(new MazeLocation(curr.getRow()-1,curr.getCol()));



            	}
              else if(curr.getRow() != maze.getNumRows()-1 && visited[curr.getRow()+1][curr.getCol()]==false
      						&& !maze.isWall(curr.getRow()+1, curr.getCol()))  {
      					stack.push(new MazeLocation(curr.getRow()+1,curr.getCol()));

		}
              else if(curr.getCol() != maze.getNumCols()-1 && visited[curr.getRow()][curr.getCol()+1] == false
      						&& !maze.isWall(curr.getRow(), curr.getCol()+1)){
      					stack.push(new MazeLocation(curr.getRow(),curr.getCol()+1));
      				}
              else if(curr.getCol() != 0 && visited[curr.getRow()][curr.getCol()-1] ==false
      						&& !maze.isWall(curr.getRow(), curr.getCol()-1)) {
      					stack.push(new MazeLocation(curr.getRow(),curr.getCol()-1));

      		}
              else {
      					stack.pop();
      					}
              }
            }catch (StackEmptyException e) {
			           e.printStackTrace();
		             }



              if(stack.isEmpty()) {
              	result = "";
              }else {
              	result = stack.toString();
              }
              return result.trim();
            }
}
