// integer stack
// Linked List implementation 

public class MyStack<Integer>
{

	// Node to represent a plate in the stack
	// Each node has a value and a 'next' component 
	// which is the node beneath it

	private static class Node<Integer>
	{
		private int data;
		private Node<Integer> next;

		public Node(int data)
		{
			this.data = data;
		}
	}

	// top of the stack
	private Node<Integer> top;

	public int pop()
	{
		if(top == null)
		{
			throw new EmptyStackException();
		}

		int item = top.data;
		top = top.next;
		return item;
	}

	public int peek()
	{
		if(top == null)
		{
			throw new EmptyStackException();
		}
		int item = top.data;
		return item;
	}

	public void push(int item)
	{
		Node<Integer> newNode = new Node<Integer>(item);
		newNode.next = top;
		top = newNode;
	}

	public boolean isEmpty()
	{
		return top == null;
	}
}