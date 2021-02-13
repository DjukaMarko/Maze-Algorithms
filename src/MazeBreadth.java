import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Coords {
	int x;
	int y;
	int x_par;
	int y_par;
	int dist;
	Coords parent;
	
	public Coords(int x, int y, int dist, Coords parent) {
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.parent = parent;
	}
	public Coords(int x, int y, Coords parent) {
		this.x = x;
		this.y = y;
		this.parent = parent;
	}
	
	public Coords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	int getX() {
		return x;
	}
	int getY() {
		return y;
	}
	
	Coords getParent() {
		return parent;
	}

	
 	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Coords coords = (Coords) obj;
		if(coords.x == this.x && coords.y == this.y) {
			return true;
		}
		return false;
	}
}



public class MazeBreadth {
	
	public int [][] maze = 
		{ 		  {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				  {1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1},
				  {1,0,1,0,0,0,0,0,1,1,1,1,1,1,1,0,1,1},
				  {1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,1},
				  {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
				  {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
				  {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
				  {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
				  {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3,1},
				  {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}

		};
	
	public boolean isValid(int x, int y) {
		if((x >= 0 && x < maze.length) && (y >= 0 && y < maze[0].length)) {
			if(maze[x][y] == 0 || maze[x][y] == 3) {
				return true;
			}
		}
		return false;
	}
	
	public List<Coords> solve(int x, int y) {
		Queue<Coords> q = new LinkedList<>();
		List<Coords> visited = new ArrayList<>();
		Coords start = new Coords(x,y);
		
		q.add(start);
		visited.add(start);
		
		while(!q.isEmpty()) {
			Coords get = q.remove();
			
			if(maze[get.x][get.y] == 3) {
				System.out.println("found an exit!");
				System.out.println("Distance: " + get.dist);
				System.out.println("Parents X and Y's: " + get.getParent().getX() + ", " + get.getParent().getY());
				while(get.getParent() != null) {
					get = get.getParent();
					maze[get.x][get.y] = 2;
				}
				break;
			}
			
			if(!visited.contains(get)) {
				visited.add(get);
			}
			
			if(isValid(get.x-1, get.y)) {
				q.add(new Coords(get.x-1, get.y, get.dist+1, get));
			}
			if(isValid(get.x+1, get.y)) {
				q.add(new Coords(get.x+1, get.y, get.dist+1, get));
			}
			if(isValid(get.x, get.y-1)) {
				q.add(new Coords(get.x, get.y-1, get.dist+1, get));
			}
			if(isValid(get.x, get.y+1)) {
				q.add(new Coords(get.x, get.y+1, get.dist+1, get));
			}
			
			
		}
		return visited;
	}
	
	
	 public void printMaze() {
		 for(int i = 0; i < maze.length; i++) {
			 
			 for(int j = 0; j < maze[0].length; j++) {
				 System.out.print(maze[i][j] + " ");
			 }
			 
			 System.out.println();
		 }
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MazeBreadth mz = new MazeBreadth();
		mz.solve(1,1);
		mz.printMaze();
		
		


	}
}
