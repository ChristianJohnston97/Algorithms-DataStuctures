// integer queue
// Linked List implementation 

public class Queue<Integer>
{

	// Node to represent an object in the queue
	// Each node has a value and a 'next' component 
	// which is the node behind it

	private static class Node<Integer>
	{
		private int data;
		private Node<Integer> next;

		public Node(int data)
		{
			this.data = data;
		}
	}

	// front and back of the queue
	private Node<Integer> front;
	private Node<Integer> back;

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
		Node<Integer> newNode = new Node<Integer>(item);
		
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