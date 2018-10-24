import java.util.*;

public class SentenceReconstruction
{
	public static void main(String[] args)
	{
		String[] words = {"quick", "brown", "the", "fox"};
		String sentence = "thequickbrownfox";
		SentenceReconstruction sr = new SentenceReconstruction();
		ArrayList<String> result = sr.naive(sentence, words);
		System.out.println(result);
	}

	// O(ab)
	public ArrayList<String> naive(String sentence, String[] words)
	{
		ArrayList<String> result = new ArrayList<String>();

		int length = 0;
		for(String word: words)
		{
			if(sentence.contains(word) && (length + word.length()) <= sentence.length())
			{
				result.add(word);
			}
		}
		return result;
	}


}