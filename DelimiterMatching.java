public class DelimiterMatching
{
	public static void main(String[] args)
	{

	}

	public boolean check(String string)
	{	
		int stringLength = string.length();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<stringLength; i++)
		{
			char c = string.charAt(i);
			switch(c)
			{
				case '{':
				case '[':
				case '(':
							stack.push(c);
							break;

				case ']':
				case '}':
				case ')':
							if(!stack.isEmpty())
							{
								char character = (char) stack.pop();
								if(c == '}' && character != '{')
								{
									return false;
								}
							}
							else
							{
								return false;
							}
							break;
				default:	break;
			}
		}
		return true;
	}
}	

