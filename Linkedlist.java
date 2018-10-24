// Linked List implementation 
// Singly linked list 
import java.util.*;

public class Linkedlist<Integer>
{

	private static class Node
	{
		private int data;
		private Node next;
		private boolean visited;

		private Node head;

		public Node(int data)
		{
			this.data = data;
			this.next = null;
			this.visited = false;
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

		public Node findKthToLastElement(Node node, int k)
		{
			Node reference = head;
			Node main = head;

			for(int i=0; i<k; i++)
			{
				reference = reference.next;
			}

			while(reference != null)
			{
				reference = reference.next;
				main = main.next;
			}

			return main;
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

		// O(n)
		public Node reverse(Node node)
		{
			Node current = head;
			Node previous = null;
			Node next = null;

			while(current != null)
			{
				// need to store next node for looping purposes
	            next = current.next;

	            // change next of current to previous
	            current.next = previous;
	            previous = current;

	            // move on one
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

		// intersection of two linked lists
		// O(m+n) but requires additional information with each node (visited)

		// could also hash set
		public int interesection(Node node1, Node node2)
		{
			while(node1 != null)
			{
				node1.visited = true;
				node1 = node1.next;
			}

			while(node2 != null)
			{
				if(node2.visited == true)
				{
					return node2.data;
				}
				else
				{
					node2 = node2.next;
				}
			}
			return -1;
		}
	}
}
