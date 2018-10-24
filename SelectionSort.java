\public class SelectionSort
{
	public static void main(String[] args)
	{
		int[] testArray = {35,6,3,6,1,8};
		int[] resultArray = sort(testArray);
		print(resultArray);
	}


	// SELECT the smallest element and move it to its correct position in the array
	public static int[] sort(int[] array)
	{
		int arrayLength = array.length;
		for(int i=0; i<arrayLength-1; i++)
		{
			int index = i;
			for(int j=i+1; j<arrayLength; j++)
			{
				if(array[j] < array[index])
				{
					index = j;
				}
			}
			//swap around element array[index] and array[i]
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
		return array;
	}


	public static void print(int[] array)
	{
		for(int arr: array)
		{
			System.out.println(arr);
		}
	}
}