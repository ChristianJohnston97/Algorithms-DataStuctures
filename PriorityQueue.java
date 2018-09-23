public class PriorityQueue
{
	private Comparable[] priorityQueue;
	private int index;

	public PriorityQueue(int capacity)
	{
		priorityQueue = new Comparable[capacity];
	}

	public void insert(Comparable item)
	{
		pQueue(index) = item;
		index++;
	}

	public int removeHighestPriority()
	{
		int maxIndex = 0;
		for(int i-0; i<priorityQueue.length; i++)
		{
			if(priorityQueue[i].compareTo(maxIndex))
			{
				maxIndex = i;
			}
		}

		Comparable result = pQueue[maxIndex];
		index--;
		pQueue[maxIndex] = pQueue[index];
		return result;
	}
}