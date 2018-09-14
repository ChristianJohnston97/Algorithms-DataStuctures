// Linked List implementation 
// Singly linked list 

public class Linkedlist<Integer>
{

	private static class Node
	{
		private int data;
		private Node next;


		public Node(int data)
		{
			this.data = data;
			next = null;
		}

	public void appendToTail(int data)
	{
		Node endNode = new Node(data);
		Node n = this;
		while(n.next != null)
		{
			n = n.next;
		}
		n.next = endNode;
	}

	public Node deleteNode(Node head, int d)
	{
		Node n = head;
		if(n.data == d)
		{
			return head.next;
		}

		while(n.next != null)
		{
			if(n.next.data == d){
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}

}
}