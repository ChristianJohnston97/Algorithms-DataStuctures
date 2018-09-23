public class DoublyLinkedList<Integer>
{
	private class Node
	{
		int data;
		Node next;
		Node previous;

		public Node(int data, Node next, Node previous)
		{
			this.data = data;
			this.next = next;
			this.previous = previous;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public int getSize()
	{
		return size;
	}

	public void addFirst(int data)
	{
		Node node = new Node(data, head, null);
		head.previous = node;
		head = node;
		size++;
	}

	public void addLast(int data)
	{
		Node node = new Node(data, null, tail);
		tail.next = node;
		tail = node;
		size++;
	}

	public void removeFirst()
	{
		head = head.next;
		head.previous = null;
		size--;
	}

	public void removeLast()
	{
		tail = tail.previous;
		tail.next = null;
		size--;
	}

	public void iterateForward()
	{
		Node temp = head;
		while(temp != null)
		{
			temp = temp.next;
		}
	}

}