// Linked List implementation 
// Singly linked list 
import java.util.*;

public class Linkedlist<Integer>
{

	private static class Node
	{
		private int data;
		private Node next;

		private Node head;

		public Node(int data)
		{
			this.data = data;
			next = null;
		}

		public void appendToHead(int data)
		{
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}

		public void pairwiseSwap()
		{
			Node temp = head;
			while(temp != null && temp.next != null)
			{
				int k = temp.data;
				temp.data = temp.next.data;
				temp.next.data = k;
				temp = temp.next.next;
			}
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


		//finding middle element of LinkedList in single pass
		public int findMiddleNode(Node head)
		{
			Node current = head;
			Node middle = head;
			int length = 1;

			while(current.next != null)
			{
				current = current.next;
				length++;

				if(length % 2 == 0)
				{
					middle = middle.next;
				}

			}
			if(length%2 == 1)
			{
			 	middle = middle.next;
			}
			return middle.data;
		}

		public Node reverse(Node node)
		{
			Node current = head;
			Node previous = null;
			Node next = null;

			while(current != null)
			{
	            next = current.next;
	            current.next = previous;
	            previous = current;
	            current = next;
        	}
        	node = previous;
        	return node;
		}

		public void removeDupes(Node node)
		{
			HashSet set = new HashSet();
			Node previous = null;

			while(node != null)
			{
				if(set.contains(node.data))
				{
					previous.next = node.next;
				}
				else
				{
					set.add(node.data);
					previous = node;
				}

				node = node.next;
			}
		}
	}
}
