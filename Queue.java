// integer queue
// Linked List implementation 

public class Queue
{

	// Node to represent an object in the queue
	// Each node has a value and a 'next' component 
	// which is the node BEHIND it

	private static class Node
	{
		private int data;
		private Node next;

		public Node(int data)
		{
			this.data = data;
		}
	}

	// front and back of the queue
	private Node front;
	private Node back;

	public int dequeue()
	{
		int item = front.data;
		front = front.next;
		if(front == null)
		{
			back = null;
		}
		return item;
	}

	public int peek()
	{
		int item = front.data;
		return item;
	}

	public void add(int item)
	{
		Node newNode = new Node(item);
		
		if(back != null)
		{
			back.next = newNode;
		}
		back = newNode;
		if(front == null)
		{
			front = back;
		}
	}

	public boolean isEmpty()
	{
		return front == null;
	}
}