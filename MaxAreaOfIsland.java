import java.util.*;

public class MaxAreaOfIsland
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
    	Point start; // The coordinates of a cell

		public QueueNode(Point start) 
		{
	    	this.start = start;
		}
    }

    boolean isValid(boolean[][] array, int row, int col) 
    {
		// return true if row number and column number
		// is in range
		if(row >= 0 && row < array.length && col >= 0 && col < array[0].length && array[row][col] == true)
		{
			return true;
		}
		else
		{
			return false;
		}
    }

    public int bfs(boolean[][] array, Point src)
    {

    	int column = array[0].length;
    	int row = array.length;
    	boolean[][] visited = new boolean[row][column];

    	for(int i=0; i<visited.length; i++)
    	{
    		for(int j = 0; j< visited[0].length; j++)
    		{
    			visited[i][j] = false;
    		}
    	}

    	visited[src.x][src.y] = true;

    	//Queue
    	LinkedList<QueueNode> list = new LinkedList();
    	list.add(new QueueNode(src));

    	int absoluteBiggest = 1;
    	int greatest = 1;


    	
    	while(!list.isEmpty())
    	{

    		QueueNode curr = list.remove();
	    	Point pt = curr.start;

	    	// if we can walk on it and we havent visisted it
	    	if(isValid(array, pt.x+1, pt.y) == true && visited[pt.x+1][pt.y] == false)
	    	{
	    		visited[pt.x+1][pt.y] = true;
		    	list.add(new QueueNode(new Point(pt.x+1, pt.y)));
		    	greatest++;
		    	if(greatest > absoluteBiggest)
		    	{
		    		absoluteBiggest = greatest;
		    	}
	    	}

	    	// if we can walk on it and we havent visisted it
	    	if(isValid(array,pt.x-1, pt.y) == true && visited[pt.x-1][pt.y] == false)
	    	{
	    		visited[pt.x-1][pt.y] = true;
	    		list.add(new QueueNode(new Point(pt.x-1, pt.y)));
		    	greatest++;
		    	if(greatest > absoluteBiggest)
		    	{
		    		absoluteBiggest = greatest;
		    	}
	    	}

	    	// if we can walk on it and we havent visisted it
	    	if(isValid(array,pt.x, pt.y+1) == true && visited[pt.x][pt.y+1] == false)
	    	{
	    		visited[pt.x][pt.y+1] = true;
	    		list.add(new QueueNode(new Point(pt.x, pt.y+1)));

		    	greatest++;
		    	if(greatest > absoluteBiggest)
		    	{
		    		absoluteBiggest = greatest;
		    	}
	    	}
	    	// if we can walk on it and we havent visisted it
	    	if(isValid(array,pt.x, pt.y-1) == true && visited[pt.x][pt.y-1] == false)
	    	{
	    		visited[pt.x][pt.y-1] = true;
	    		list.add(new QueueNode(new Point(pt.x, pt.y-1)));
		    	greatest++;
		    	if(greatest > absoluteBiggest)
		    	{
		    		absoluteBiggest = greatest;
		    	}
	    	}
    	}
    	return absoluteBiggest;
    }

	public static void main(String[] args)
	{
		boolean[][] grid = new boolean[][] { {true, false, false, false}, 
											 {true, true, false, true}, 
											 {true, true, true, false}, 
											 {false, false, false, false}};

		Point source = new MaxAreaOfIsland.Point(0, 0);
		MaxAreaOfIsland sp = new MaxAreaOfIsland();
		int result = sp.bfs(grid, source);
		System.out.println(result);

	}

	
}