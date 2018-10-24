public class PathsWithSumN
{

	class Node
	{
		int value;
		Node left;
		Node right;
	}

	Node root;

	public static void main(String[] args)
	{

	}


	public int compute(Node node, int target)
	{
		if(node == null)
		{
			return 0;
		}

		int val1 = PathsWithSumNFromRoot(node, target, 0);
		int val2 = compute(node.left, target);
		int val3 = compute(node.right, target);

		int total = val1, val2, val3;
		return total;
	}	

	public int PathsWithSumNFromRoot(Node node, int target, int current)
	{
		int totalPaths = 0;

		if(node == null)
		{
			return 0;
		}
		
		current += node.data;
		

		if(current == target)
		{
			totalPaths++;
		}

		totalPaths += PathsWithSumNFromRoot(node.left, target, current);
		totalPaths += PathsWithSumNFromRoot(node.right, target, current);
		return totalPaths;
	}
}