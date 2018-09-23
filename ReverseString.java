import java.util.*;
public class ReverseString
{
	public static void main(String[] args)
	{
		String testString = "revserse this string";
		String reverse = reverse(testString);
		System.out.println(reverse);

	}

	public static String reverse(String input)
	{
		// convert string to char array
		char[] charArr = input.toCharArray();
		int size = charArr.length;

		Stack stack = new Stack();

		for(int i=0; i < size; i++)
		{
			stack.push(charArr[i]);
		}
		// need to cast back to char as it is saved as an integer
		for(int i=0; i < size; i++)
		{
			charArr[i] = (char) stack.pop();
		}
		return String.valueOf(charArr);
	}
}