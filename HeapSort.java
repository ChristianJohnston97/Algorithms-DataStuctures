//similar to selection sort where we first find the maximum element and 
// place the maximum element at the end. 
// We repeat the same process for remaining element.


// Binary Heap = Complete Binary Tree, 
// represented as array. If the parent node is stored at index i
// the left child can be calculated by 2 * i + 1 and right child by 2 * i + 2 

import java.util.*;

public class HeapSort
{
	public static void main(String[] args)
	{
		int[] arr = {12, 11, 13, 5, 6, 7};
        int n = arr.length;
        HeapSort ob = new HeapSort();
        ob.sort(arr);
        System.out.println(Arrays.toString(arr));
	}

	public void sort(int array[])
    {
        int n = array.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
        {
            heapify(array, n, i);
        }
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }


	// O(logn)
	public void heapify(int[] array, int length, int i)
	{

		// Initialize largest as root
		int largest = i; 
        int l = 2*i + 1; 
        int r = 2*i + 2; 
 
        // If left child is larger than largest so far
        if(l < length && array[l] > array[largest])
        {
            largest = l;
        }
 
        // If right child is larger than largest so far
        if(r < length && array[r] > array[largest])
        {
            largest = r;
        }
 
        // If largest is not root
        if (largest != i)
        {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
 
            // Recursively heapify the affected sub-tree
            heapify(array, length, largest);
        }
	}
}