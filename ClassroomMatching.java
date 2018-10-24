import java.util.*;
// Sorting is O(NlogN) and the checking overlap is O(N). So overall it’s O(NlogN).
public class ClassroomMatching
{

	public static void main(String[] args)
	{
		int[][] timings = {{1,4}, {5,6}, {8,9}, {2,6}};
		ClassroomMatching cm = new ClassroomMatching();
		int result = cm.sort(timings);
		System.out.println(result);

	}
	public int sort(int[][] timings)
	{
		int counter = 1;
		Arrays.sort(timings, new Comparator<int[]>() {
            	public int compare(final int[] entry1, final int[] entry2) {
                int startingTime1 = entry1[0];
                int startingTime2 = entry2[0];
                return startingTime1 - startingTime2;
            }
        });

        for(int i = 0; i < timings.length-1; i++)
        {
        	// if the next interval’s start point is larger than the current one’s end point.
        	if(timings[i+1][0] > timings[i][1])
        	{
        		counter++;
        	}
        }

		return counter;
	}

	public void print(int[][] array)
	{
		for (int[] s : array) {
            System.out.println(s[0] + " " + s[1]);
        }
	}
}