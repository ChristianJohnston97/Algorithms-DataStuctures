import java.util.*;

public class RunningMedian
{

	public double[] getMedian(int[] array)
	{
		// min heap
		PriorityQueue<Integer> highers = new PriorityQueue();

		// max heap
		PriorityQueue<Integer> lowers = new PriorityQueue(Collections.reverseOrder());
		double[] medians = new double[array.length];
		for(int i=0; i<array.length; i++)
		{
			int number = array[i];
			addNumber(number, lowers, highers);
			rebalance(lowers, highers);
			medians[i] = getMedian(lowers, highers);
		}
		return medians;
	}

	public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers)
	{
		if(lowers.size() == 0 || number < lowers.peek())
		{
			lowers.add(number);
		}
		else
		{
			highers.add(number);
		}
	}

	public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers)
	{
		PriorityQueue<Integer> biggerHeap = lowers;
		PriorityQueue<Integer> smallerHeap = highers;

		if(highers.size() > lowers.size())
		{
			biggerHeap = highers;
			smallerHeap = lowers;
		}

		if(biggerHeap.size() - smallerHeap.size() > 1)
		{
			smallerHeap.add(biggerHeap.remove());
		}
	}

	public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers)
	{
		PriorityQueue<Integer> biggerHeap = lowers;
		PriorityQueue<Integer> smallerHeap = highers;

		if(highers.size() > lowers.size())
		{
			biggerHeap = highers;
			smallerHeap = lowers;
		}

		if(biggerHeap.size() == smallerHeap.size())
		{
			return ((double)biggerHeap.peek() + smallerHeap.peek()) / 2;
		}
		else
		{
			return biggerHeap.peek();
		}
	}


}
