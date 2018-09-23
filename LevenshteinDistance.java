import java.util.*;

public class LevenshteinDistance
{
	public static void main(String[] args)
	{

	}

	public int computeDistance(String string1, String string2)
	{
		string1 = string1.toLower();
		string2 = string2.toLower();

		int length1 = string1.length();
		int length2 = string2.length();

		int distance = new int[length1+1][length2+1];

		for(int i =0; i <= length1; i++)
		{
			array[i][0] = i;
		}
		for(int j = 0; j<= length2; j++)
		{
			array[0][j] = j;
		}

		for(int i=0; i <= length1; i++)
		{
			for(int j=0; j <= length2; j++)
			{
				distance[i][j] = minimum(distance[i])
			}
		}


	}
}