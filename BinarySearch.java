import java.lang.*;

public class BinarySearch
{

  public static void main(String[] args)
  {
    int[] testArray = {3, 4, 6, 9, 11, 23, 53, 67};
    BinarySearch bs = new BinarySearch();
    int length = testArray.length;
    int middle = bs.binarySearch(testArray, 0, length-1,  11);
    System.out.println(middle);
  }

  public int binarySearch(int[] array, int l, int r, int x)
  {
    int arrayLength = array.length;
    int middle = arrayLength / 2;

    if(x == array[middle])
    {
      return middle;
    }

    if(x > array[middle])
    {

      return binarySearch(array, middle+1, r, x );
    }

    if(x > array[middle])
    {

      return binarySearch(array, l, middle-1, x );
    }

    return 0;
  }

  public int binarySearchNonRecursive(int[] array, int key)
  {
    int arrayLength = array.length;
    int start = 0;
    int end = arrayLength - 1;


    while(start <= end)
    {
      int middle = (start + end)/2;

      if(array[middle] == key)
      {
        return middle;
      }
      if(key >= array[middle])
      {
        start = middle+1;
      }
      else
      {
        end = middle -1;
      }
    }
    return -1;
  }



}
