import java.lang.*;

public class Bubblesort
{

  public static void main(String[] args)
  {
    int[] testArray = {7, 11, 36, 2, 15, 52, 48, 2};
    Bubblesort bs = new Bubblesort();
    bs.sort(testArray);
    printArray(testArray);
  }

  public void sort(int[] array)
  {
    int arrayLength = array.length;
    for(int i=0; i < arrayLength-1; i++)
    {
      for(int j=0; j<arrayLength-i-1; j++)
      {
        if(array[j] > array[j+1])
        {
          int temp = array[j];
          array[j] = array[j+1];
          array[j+1] = temp;
        }
      }
    }
  }

  static void printArray(int arr[]) 
  {
    int n = arr.length; 
    for (int i=0; i<n; ++i)
    {
      System.out.print(arr[i] + " "); 
    }
  }  
}
