import java.lang.*;

public class Mergesort
{

  public static void main(String[] args)
  {
    int[] testArray = {7, 11, 36, 6, 15, 52, 48, 2};
    Mergesort ms = new Mergesort();
    ms.sort(testArray, 0, testArray.length-1);
    printArray(testArray);
  }

  // Merges two subarrays of arr[].
  // First subarray is arr[l..m]
  // Second subarray is arr[m+1..r]

  public void merge(int[] array, int l, int m, int r)
  {
    // the left side includes the middle 
    int leftLength = m-l+1;
    int rightLength = r-m;

    // helper arrays
    int[] tempLeft = new int[leftLength];
    int[] tempRight = new int[rightLength];

    for (int i=0; i < leftLength; i++)
    {
      tempLeft[i] = array[l + i];
    }

    for (int j=0; j < rightLength; j++)
    {
      tempRight[j] = array[m + 1 + j];
    }

    int i = 0;
    int j = 0;

    // IMPORTANT
    int k = l;

    // comparing elements in the two helper arrays
    while (i < leftLength && j < rightLength)
    {
      if (tempLeft[i] <= tempRight[j])
      {
        array[k] = tempLeft[i];
        i++;
      }
      else
      {
        array[k] = tempRight[j];
        j++;
      }

      k++;
    }

    // Copy remaining elements of left helper (if any)
    while (i < leftLength)
      {
        array[k] = tempLeft[i];
        i++;
        k++;
      }

    // Copy remaining elements of right helper (if any)
    while (j < rightLength)
      {
        array[k] = tempRight[j];
        j++;
        k++;
      }
  }

// sort an array by splitting the array into two 
// sort left hand side and right hand side and then merge the two together 
  public void sort(int[] array, int l, int r)
  {
    if (l < r)
    {
      int middle = (l+r)/2;
      sort(array, l, middle);
      sort(array, middle+1, r);
      merge(array, l, middle, r);
    }
  }

    static void printArray(int arr[]) { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
}
