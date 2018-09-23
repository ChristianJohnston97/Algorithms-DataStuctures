import java.util.*;
import java.lang.*;

public class AutoComplete
{
	public static void main(String[] args)
	{
		String input = "de";
		String[] arrayList = {"dog", "deer", "deal"};
		AutoComplete ac = new AutoComplete();
		ArrayList<String> result = ac.autocomplete(input, arrayList);
		printArray(result);

	}

	// given an input string and set of all possible query strings, returns all 
	// strings in the set which have the input string as a prefix 
	// eg [dog, deer, deal] and "de" 

	public ArrayList<String> autocomplete(String string, String[] queryStrings)
	{
		ArrayList<String> result = new ArrayList<String>();

		for(String query: queryStrings)
		{
			if(query.contains(string))
			{
				result.add(query);
			}
		}
		return result;
	}

	public static void printArray(ArrayList<String> array)
	{
		for(String string: array)
		{
			System.out.println(string);
		}
	}
}