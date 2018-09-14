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
}
