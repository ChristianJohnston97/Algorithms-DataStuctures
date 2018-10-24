public class RemoveToMakeAnagram
{
	public static void main(String[] args)
	{
		String str1 = "hello";
		String str2 = "helping";
		RemoveToMakeAnagram rm = new RemoveToMakeAnagram();
		int number = rm.compute(str1, str2);
		System.out.println(number);

	}

	public int compute(String string1, String string2)
	{
		int[] charCount = new int[26];
		int[] charCount2 = new int[26];

		for(int i=0; i<charCount.length; i++)
		{
			charCount[i] = 0;
		}
		for(int j=0; j<charCount2.length; j++)
		{
			charCount2[j] = 0;
		}

		for(int i=0; i<string1.length(); i++)
		{
			char c = string1.charAt(i);
			int offset = (int) 'a';
			int value = c - offset;
			charCount[value]++;
		}

		for(int i=0; i<string2.length(); i++)
		{
			char c = string2.charAt(i);
			int offset = (int) 'a';
			int value = c - offset;
			charCount2[value]++;
		}

		int total = 0;
		for(int j=0; j<charCount2.length; j++)
		{
			total += Math.abs(charCount[j] - charCount2[j]);
		}
		return total;
	}
}