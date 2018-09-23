import java.lang.*;

public class InertionSort
{

  public static void main(String[] args)
  {
    int[] testArray = {7, 11, 3, 2, 15, 52, 48, 43};
    InertionSort is = new InertionSort();
    is.sort(testArray);
    printArray(testArray);
  }

  static void printArray(int array[])
   {
       int n = array.length;
       for (int i=0; i<n; ++i)
           System.out.print(array[i]+" ");
   }

  public void sort(int[] array)
  {
    int arrayLength = array.length;

    for(int i=0; i < arrayLength; i++)
    {
      // for all of the elements to the left of the 'inserted' element
      for(int j=i; j > 0; j--)
      {
        if(array[j] < array[j-1])
        {
          int temp = array[j];
          array[j] = array[j-1];
          array[j-1] = temp;
        }
      }
    }
  }
}
