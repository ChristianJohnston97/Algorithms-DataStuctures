import java.util.*;

public class ReverseBinaryTree
{
	class Node
	{
		int data;
		Node left;
		Node right;

		Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}


	private Node root;


	public void reverse(Node node)
	{
		if(node != null)
		{
			Node temp = node.left;
    		node.left = node.right;
    		node.right = temp;
 
    		if(node.left!=null)
    		{
    			reverse(node.left);
    		}
    		if(node.right!=null)
    		{
    			reverse(node.right);
			}   
		}
	}


	public Node reverseTreeNonRecusrive(Node node) 
	{
		LinkedList<Node> queue = new LinkedList<Node>();
 
	    if(node != null)
	    {
	        queue.add(node);
	    }
 
    	while(!queue.isEmpty())
    	{
    		Node p = queue.remove();
    		if(p.left!=null)
    		{
            	queue.add(p.left);
    		}
    		if(p.right!=null)
    		{
            	queue.add(p.right);
    		}
	        Node temp = p.left;
	        p.left = p.right;
	        p.right = temp;
    	}
   		return node;    
	}

}