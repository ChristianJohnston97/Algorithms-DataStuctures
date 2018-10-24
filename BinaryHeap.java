//MIN binary heap
import java.util.*;
public class BinaryHeap
{
	private int capacity = 16;
	private int size = 0;


	int[] items = new int[capacity];


	private int getLeftChildIndex(int parentIndex)
	{
		int index = (2 * parentIndex) + 1;
		return index;
	}

	private int getRightChildIndex(int parentIndex)
	{
		int index = (2 * parentIndex) + 2;
		return index;
	}
	
	private int getParentIndex(int childIndex)
	{
		int index = (childIndex -1)/2;
		return index;
	}

	private boolean hasLeftChild(int index)
	{
		int indx = getLeftChildIndex(index);
		if(indx < size)
		{
			return true;
		}
		return false;
	}

	private boolean hasRightChild(int index)
	{
		int indx = getRightChildIndex(index);
		if(indx < size)
		{
			return true;
		}
		return false;
	}

	private boolean hasParent(int index)
	{
		int indx = getRightChildIndex(index);
		if(indx >= 0)
		{
			return true;
		}
		return false;
	}

	private int leftChildValue(int index)
	{
		return items[getLeftChildIndex(index)];
	}

	private int rightChildValue(int index)
	{
		return items[getRightChildIndex(index)];
	}

	private int parentValue(int index)
	{
		return items[getParentIndex(index)];
	}

	private void swap(int index1, int index2)
	{
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

	public void ensureExtraCapacity()
	{
		if(size == capacity)
		{
			items = Arrays.copyOf(items, capacity*2);
			capacity *= 2;
		}
	}

	public int peek()
	{
		if(size == 0)
		{
			throw new IllegalStateException();
		}
		else
		{
			return items[0];
		}
	}

	// returns and removes minimum element 
	public int removeMin()
	{
		if(size == 0)
		{
			throw new IllegalStateException();
		}
		else
		{
			int item = items[0];
			// move element at end to beginning
			items[0] = items[size-1];
			size--;
			heapifyDown();
			return item;
		}
	}


	public void addElement(int value)
	{
		ensureExtraCapacity();
		items[size] = value;
		size++;
		heapifyUp();
	}

	public void heapifyUp()
	{
		int index = size-1;
		while(hasParent(index) && getParentIndex(index) > items[index])
		{
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}


	public void heapifyDown()
	{
		int index = 0;
		//only need to check it has a right child 
		while(hasLeftChild(index))
		{
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && rightChildValue(index) < smallerChildIndex)
			{
				smallerChildIndex = getRightChildIndex(index);
			}
		
			if(items[index] < items[smallerChildIndex])
			{
				break;
			}
			else
			{
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}




}