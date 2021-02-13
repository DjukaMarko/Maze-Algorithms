
public class MazeSolver {
	
	public int [][] maze = 
		{ {1,1,1,1,1,1,1,1,1,1,1,1,1},
		  {1,0,1,0,1,0,1,3,0,0,0,0,1},
		  {1,0,1,0,0,0,1,0,1,1,1,0,1},
		  {1,0,0,0,1,1,1,0,0,0,0,0,1},
		  {1,0,1,0,0,0,0,0,1,1,1,0,1},
		  {1,0,1,0,1,1,1,0,1,0,0,0,1},
		  {1,0,1,0,1,0,0,0,1,1,1,0,1},
		  {1,0,1,0,1,1,1,0,1,0,1,0,1},
		  {1,0,0,0,0,0,0,0,0,0,1,0,1},
		  {1,1,1,1,1,1,1,1,1,1,1,1,1}

		};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MazeSolver mazes = new MazeSolver();
		mazes.printDiff();
		mazes.solve(8, 1);
		System.out.println();
		mazes.printDiff();
		System.out.println();
		
		
	}

	private boolean solve(int x, int y) {
		// TODO Auto-generated method stub
		if(backtrack(x, y)) {
			return true;
		}
		System.out.println("No possible solutions!");
		return false;
	}

	private boolean backtrack(int x, int y) {
		// TODO Auto-generated method stub
		if(maze[x][y] == 3) {
			return true;
		}
		if(maze[x][y] == 1 || maze[x][y] == 2) {
			return false;
		}
		maze[x][y] = 2;
		
		if(backtrack(x, y+1)) {return true;}
		if(backtrack(x, y-1)) {return true;}
		if(backtrack(x+1, y)) {return true;}
		if(backtrack(x-1, y)) {return true;}
		
		maze[x][y] = 0;
		
		return false;
	}
	
	public void printMaze() {
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[0].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void printDiff() {
		char[][] rmaze = new char[10][13];
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[0].length; j++) {
				if (maze[i][j] == 1) {
					rmaze[i][j] = '#';
				}
				else if(maze[i][j] == 0) {
					rmaze[i][j] = '-';
				}
				else if(maze[i][j] == 3) {
					rmaze[i][j] = 'X';
				} else {
					rmaze[i][j] = 'o';
				}
			}
		}
		for(int i = 0; i < rmaze.length; i++) {
			for(int j = 0; j < rmaze[0].length; j++) {
				System.out.print(rmaze[i][j] + " ");
			}
			System.out.println();
		}
	}

}
