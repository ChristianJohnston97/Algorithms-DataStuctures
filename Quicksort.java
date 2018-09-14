import java.lang.*;

public class Quicksort
{

  public static void main(String[] args)
  {
    int[] testArray = {7, 11, 36, 2, 15, 52, 48, 43};
    Quicksort qs = new Quicksort();
    qs.sort(testArray, 0, testArray.length -1);
    printArray(testArray);
  }


  public int partition(int[] array, int l, int r)
  {
    // Choose the pivot as the last element
    int pivot = array[r];

    // i is the index of a smaller elements
    int i = l-1;
    // we start from the leftmost element and keep track of index of smaller elements as i.
    // If we find a smaller element, we swap current element with arr[i].
    // Otherwise we ignore current element.
    for (int j=l; j<r; j++)
    {
      if(array[j] <= pivot)
      {
        i++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    int temp = array[i+1];
    array[i+1] = array[r];
    array[r] = temp;

    return i+1;
  }

  static void printArray(int array[])
   {
       int n = array.length;
       for (int i=0; i<n; ++i)
           System.out.print(array[i]+" ");
       System.out.println();
   }




  public void sort(int[] array, int l, int r)
  {
    if (l < r)
    {
      int partitionIndex = partition(array, l, r);
      sort(array, l, partitionIndex-1);
      sort(array, partitionIndex+1, r);
    }
  }
}
