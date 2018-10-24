import java.util.*;

public class ShortestPathThroughBinaryMaze
{
	// class to store matrix cell coordinates
    static class Point 
    {
		public Point(int row, int col) 
		{
	    	this.x = row;
	    	this.y = col;
		}
		int x;
		int y;
    }

    static class QueueNode 
    {
		public QueueNode(Point src, int d) 
		{
	    	this.pt = src;
	    	this.dist = d;
		}
		Point pt; // The coordinates of a cell
		int dist; // cell's distance of from the source
    }

    boolean isValid(boolean[][] array, int row, int col) 
    {
		// return true if row number and column number
		// is in range
		if(row >= 0 && row < array.length && col >= 0 && col < array[0].length && array[row][col] == false)
		{
			return true;
		}
		else
		{
			return false;
		}
    }

    public int bfs(boolean[][] array, Point src, Point dst)
    {
    	int column = array[0].length;
    	int row = array.length;
    	boolean[][] visited = new boolean[row][column];
    	visited[src.x][src.y] = true;
    	LinkedList<QueueNode> list = new LinkedList<QueueNode>();
    	list.add(new QueueNode(src, 0));

    	for(int i=0; i<visited.length; i++)
    	{
    		for(int j = 0; j< visited[0].length; j++)
    		{
    			visited[i][j] = false;
    		}
    	}

    	while(!list.isEmpty())
    	{
    		QueueNode curr = list.remove();
	    	Point pt = curr.pt;

	    	// if at destination, return distance
	    	if (pt.x == dst.x && pt.y == dst.y)
	    	{
	    		return curr.dist;
	    	}

	    	// if we can walk on it and we havent visisted it
	    	if(isValid(array, pt.x+1, pt.y) == true && visited[pt.x+1][pt.y] == false)
	    	{
	    		visited[pt.x+1][pt.y] = true;
		    	list.add(new QueueNode(new Point(pt.x+1, pt.y), curr.dist + 1));
	    	}

	    	// if we can walk on it and we havent visisted it
	    	if(isValid(array,pt.x-1, pt.y) == true && visited[pt.x-1][pt.y] == false)
	    	{
	    		visited[pt.x-1][pt.y] = true;
		    	list.add(new QueueNode(new Point(pt.x-1, pt.y), curr.dist + 1));
	    	}

	    	// if we can walk on it and we havent visisted it
	    	if(isValid(array,pt.x, pt.y+1) == true && visited[pt.x][pt.y+1] == false)
	    	{
	    		visited[pt.x][pt.y+1] = true;
		    	list.add(new QueueNode(new Point(pt.x, pt.y+1), curr.dist + 1));
	    	}
	    	// if we can walk on it and we havent visisted it
	    	if(isValid(array,pt.x, pt.y-1) == true && visited[pt.x][pt.y-1] == false)
	    	{
	    		visited[pt.x][pt.y-1] = true;
		    	list.add(new QueueNode(new Point(pt.x, pt.y-1), curr.dist + 1));
	    	}

    	}
    	return -1;
    }

	public static void main(String[] args)
	{
		boolean[][] grid = new boolean[][] { {false, false, false, false}, 
											 {true, true, false, true}, 
											 {true, false, false, false}, 
											 {false, false, false, false}};

		Point source = new ShortestPathThroughBinaryMaze.Point(3, 0);
		Point dest = new ShortestPathThroughBinaryMaze.Point(0, 0);
		ShortestPathThroughBinaryMaze sp = new ShortestPathThroughBinaryMaze();
		int result = sp.bfs(grid, source, dest);
		System.out.println(result);

	}

	
}