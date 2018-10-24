import java.util.*;

public class CommonSubstring
{
	public static void main(String[] args)
	{		
		CommonSubstring cs = new CommonSubstring();
		String string1 = "hello";
		String string2 = "help";
		System.out.println(cs.longestCommonSubstring(string1, string2));
	}


	public boolean computeNaive(String string1, String string2)
	{
		char[] array1 = string1.toCharArray();
		char[] array2 = string2.toCharArray();

		for(int i=0; i<array1.length; i++)
		{
			for(int j=0; j<array2.length; j++)
			{
				if(array1[i] == array2[j])
				{
					return true;
				}
			}
		}
		return false;
	}


	public boolean computeBetter(String string1, String string2)
	{
		char[] array1 = string1.toCharArray();
		char[] array2 = string2.toCharArray();

		//vector for getting character occurences
		boolean v[]=new boolean[26];
		Arrays.fill(v,false); 

	 	for (int i = 0; i < string1.length(); i++)
	 	{
	 		int offset = (int) 'a';
	 		int value = array1[i] - offset;
			v[value] = true; 
	 	} 
      
        for (int i = 0; i < string2.length(); i++)
        {
  			int offset = (int) 'a';
	 		int value = array2[i] - offset;
			if(v[value] == true)
			{
				return true;
			}         
        }
          
        return false;      
    }

    public int longestCommonSubstring(String string1, String string2)
    {
    	int n = string1.length();
    	int m = string2.length();

    	char[] array1 = string1.toCharArray();
		char[] array2 = string2.toCharArray();

    	// Let dp[i][j] be the length of the common substring ending at a[i] and b[j].

    	int[][] dp = new int[n][m];
    	int maxLength = 0;
    	int row = 0;
    	int col = 0;
 
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				if(array1[i] == array2[j])
				{
					if(i==0 || j==0)
					{
						dp[i][j]=1;
					}
					else
					{
						dp[i][j] = dp[i-1][j-1]+1;
					}
 
					if(maxLength < dp[i][j])
					{
						maxLength = dp[i][j];
						row = i; 
                        col = j;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(array1[row]);
		while (dp[row][col] != 0 && row > 0 && col > 0) 
		 { 
            sb = sb.append(array1[row-1]);  

            // move diagonally up to previous cell 
            row--; 
            col--; 
        }
        
        String backwards = sb.toString();
		String result = new StringBuilder(backwards).reverse().toString();      
		System.out.println(result);
		return maxLength;
	}
}