public class RemoveDuplicates
{
	public static void main(String[] args)
	{
		int[] sortedArrayWithDupes = {3, 4, 5, 7, 7, 8, 9, 12};
		int[] sortedWithoutDupes = removeDupes(sortedArrayWithDupes);
		printArray(sortedWithoutDupes);

	}

	public static int[] removeDupes(int[] array)
	{
		int j = 0;
		int i = 1;
		int arrayLength = array.length;
		while(i < arrayLength)
		{
			// i = 4
			// j = 3
			if(array[i] == array[j])
			{
				i++;
			}
			// i = 5
			// j = 3
			else
			{
				// array[4] = array[5]
				// then inrement i to 6
				array[++j] = array[i++];
			}

		}
		int[] output = new int[j+1];
        for(int k=0; k<output.length; k++)
        {
            output[k] = array[k];
        }
        return output;

	}

	public static void printArray(int[] array)
	{
		for(int elem: array)
		{
			System.out.println(elem);
		}
	}

}