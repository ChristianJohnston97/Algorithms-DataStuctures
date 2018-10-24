import java.util.*;

// used when just integers uniformly distributed over a range 
// for example birthdays 

public class Bucketsort
{

  public static void main(String[] args)
  {
    int[] testArray = {7, 11, 36, 36, 2, 15, 52, 48, 43};
    Bucketsort bs = new Bucketsort();
    ArrayList<Integer> sorted = bs.sort(testArray);
    printArray(sorted);
  }

  static void printArray(ArrayList<Integer> array)
   {
      for(Integer val: array)
      {
        System.out.println(val);
      }
   }

  public ArrayList<Integer> sort(int[] array)
  {
    int maxElement = getMaxElement(array);
    // create an array of buckets of length (max element ) in this example it is 52.
    // need one more as array starts from 0 so need 49 buckets
    int[] buckets = new int[maxElement+1];

    // initialise all entries to 0 
    for (int i=0; i<buckets.length; i++)
    {
      buckets[i]=0;
    }

    for(int value : array)
    {
      buckets[value]++;
    }

    ArrayList<Integer> sorted = new ArrayList<Integer>();
    for(int i=0; i<buckets.length; i++)
    {
      for(int j = 0; j < buckets[i]; j++)
      {
        sorted.add(i);
      }
    }
    return sorted;
  }

  public int getMaxElement(int[] array)
  {
    int maxElem = 0;
    for(int value: array)
    {
      if(value > maxElem)
      {
        maxElem = value;
      }
    }
    return maxElem;
  }
}
