import java.util.*;
import java.math.BigInteger;

public class Algorithms
{
    public static void main(String[] args)
    {
        Algorithms test = new Algorithms();
        int size = 10;
        int range = 1000;
        //int[] arr = new int[10];
        //arr = test.createArray(size,range);
       // int key = 3;
        long time = System.nanoTime();

        //merge sort
        /*
        int numbers[] = test.createArray(size, range);
        //System.out.println("Given Array");
        //test.printArray(numbers);
        test.mergeSort(numbers, 0, numbers.length - 1);
        time = System.nanoTime() - time;
        System.out.println("It took: " + time + " nanoseconds for merge sort to sort this array.");
        System.out.println("\nMerge sort sorted array");
       // test.printArray(numbers);
       */

       
        /*
        //selection sort
        int numbers[] = test.createArray(size, range);
        test.selectionSort(numbers);
        time = System.nanoTime() - time;
        //System.out.println("Selection sort sorted array");
        System.out.println("It took " + time + " nanoseconds for selection sort to sort this array.");
        */

        //quick sort
        /*
        int numbers[] = test.createArray(size, range);
        Arrays.sort(numbers);
        time = System.nanoTime() - time;
        System.out.println("It took " + time + " nanoseconds for quick sort to sort this array.");
        */

        //insertion sort
        
        int numbers[] = test.createArray(size, range);
        test.insertionSort(numbers);
        time = System.nanoTime() - time;
        System.out.println("Insertion sort sorted array");
        System.out.println("It took " + time + " nanoseconds for insertion sort to sort this array.");
        
        
    }
     public static int[] createArray(int size, int range)
    {
        int[] arr = new int[size];

        for(int i = 0; i <arr.length; i++)
        {
            arr[i] = (int)(Math.random()*range + 1);
        }
        return arr;
    }

   //Merge Sort Algorithm
    public void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    public void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
  
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
  
    //Selection Sort Algorithms
    
    public void selectionSort(int arr[])
    {
        int n = arr.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }


     public void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    /* A utility function to print array of size n */
    
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
  
}
