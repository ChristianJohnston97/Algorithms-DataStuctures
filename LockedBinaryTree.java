import java.util.*;

public class LockedBinaryTree
{
	public static void main(String[] args)
	{

	}


	class Node
	{
		int data;
		Node[] children;
		boolean locked;
		Node parent;

		Node(int data)
		{
			this.data = data;
			this.children = null;
			this.parent = null;
		}
	}

	private Node root;
	private int numLockedDescendants = 0;


	//  binary tree node can be locked or unlocked only 
	// if all of its descendants or ancestors are not locked.

	// is_locked, which returns whether the node is locked
	public boolean is_locked(Node node)
	{
		return node.locked;
	}

	// lock, which attempts to lock the node. If it cannot be locked, then it should return false. 
	// Otherwise, it should lock it and return true.
	public boolean checkParentsLocked(Node node)
	{
		while(node.parent != null)
		{
			if(is_locked(node.parent) == true)
			{
				return false;
			}
			else
			{
				checkParentsLocked(node.parent);
			}		
		}
		return true;
	}

	public boolean checkChildrenLocked(Node node)
	{
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(node);

		while(!list.isEmpty())
		{
			Node current = list.remove();
			for(Node nd: current.children)
			{
				if(nd.locked == true)
				{
					return false;
				}
				else
				{
					list.add(nd);
				}
			}
		}
		return true;
	}

	public boolean lock(Node node)
	{
		if(checkParentsLocked(node) == false)
		{
			return false;
		}

		if(checkChildrenLocked(node) == false)
		{
			return false;
		}
		else
		{
			node.locked = true;
			return true;
		}
	}

	
	// unlock, which unlocks the node. If it cannot be unlocked, then it should return false. 
	// Otherwise, it should unlock it and return true.

	public boolean unlock(Node node)
	{
		return true;
	}
}