import java.util.*;

public class Testing
{
	public static void main(String[] args)
	{
		int[] array = {4,25,2,8,12,22};
		ArrayList<Integer> arr = leaders(array);
		System.out.println(arr);

	}

	// second <> Type entry not needed
	LinkedList<String> queue = new LinkedList<>();
	Stack<String> stack = new Stack<String>();

	// string to integer
	int integer = Integer.parseInt("10");

	// revese an array
	public static ArrayList<Integer> reveseArray(int[] array)
	{
		Stack<Integer> stack = new Stack<Integer>();
		for(int element: array)
		{
			stack.push(element);
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!stack.isEmpty())
		{
			Integer element = stack.pop();
			list.add(element);
		}
		return list;
	}

	// leaders in array
	// all elements following are less than
	public static ArrayList<Integer> leaders(int[] array)
	{
		ArrayList<Integer> finalList = new ArrayList<Integer>();
		int arrayLength = array.length;
		for(int i=0; i < arrayLength; i++)
		{	
			int j;
			for(j=i+1; j < arrayLength; j++)
			{
				if(array[j] >= array[i])
				{
					break;
				}
			}
			if(j == arrayLength)
			{
				finalList.add(array[i]);
			}
		}
		return finalList;
	}

}