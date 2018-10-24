import java.lang.*;
import java.util.*;
// Recursive algorithm - divide and conquer 
// Pick a pivot element - choose the end element 
// Get all elements less than pivot and swap them with the left elements
// Finally, swap pivot element with the next element in the list

public class Quicksort
{

  public static void main(String[] args)
  {
    int[] testArray = {7, 11, 36, 2, 15, 52, 48, 43};
    Quicksort qs = new Quicksort();
    qs.sort(testArray, 0, testArray.length -1);
    System.out.println(Arrays.toString(testArray));
  }


  public int partition(int[] array, int l, int r)
  {
    // Choose the pivot as the last element
    int pivot = array[r];

    int i = l-1;
    // we start from the leftmost element and keep track of index of smaller elements as i.
    // If we find a smaller element, we swap current element with arr[i].

    for (int j=l; j<r; j++)
    {
      if(array[j] <= pivot)
      {
        // swap array[i] and array[j]
        i++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    // swap pivot element with element in its 'place' at position i+1 
    // i.e. put the pivot back in place
    int temp = array[i+1];
    array[i+1] = array[r];
    array[r] = temp;

    return i+1;
  }


  public void sort(int[] array, int l, int r)
  {
    if (l < r)
    {
      // don't include the pivot element
      int partitionIndex = partition(array, l, r);
      sort(array, l, partitionIndex-1);
      sort(array, partitionIndex+1, r);
    }
  }
}
