// Leetcode Problem 493

import java.util.Scanner;

public class reversePairs{
    static int c = 0;

    void countPairs(int[] arr, int low, int mid, int high){
        int i, right = mid + 1;
        for(i = low; i <= mid; i++){
            while(right <= high && (long)arr[i] > 2L * arr[right]) right++;
            c += (right - (mid+1));
        }
    }

    private void merge(int arr[], int lb, int mid, int ub)
    {
        int i = lb, j = mid+1, k = 0;
        int b[] = new int[ub - lb + 1];
        while(i<=mid && j<=ub)
        {
            if(arr[i] < arr[j])
            {
                b[k++] = arr[i++];
            }
            else
            {
                b[k++] = arr[j++];
            }
        }
        while(i<=mid)
        b[k++] = arr[i++];
        while(j<=ub)
        b[k++] = arr[j++];

        for(int m = 0; m < b.length; m++) {
            arr[lb + m] = b[m];
        }
    }

    private void mergeSort(int array[], int low, int high) {
        if (low < high) {
          int mid = (low + high) / 2;
          mergeSort(array, low, mid);
          mergeSort(array, mid + 1, high);
          countPairs(array, low, mid, high);
          merge(array, low, mid, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        reversePairs ob = new reversePairs();
        int size;
        System.out.print("Enter the size of the array : ");
        size = sc.nextInt();
        int array[] = new int[size];
        System.out.println("Enter elements in the array");
        for(int i = 0; i < size; i++){
            System.out.print("Element " + (i+1) + ": ");
            array[i] = sc.nextInt();
        }

        ob.mergeSort(array, 0, size - 1);
        System.out.println("Number of reverse pairs = " + c);
        sc.close();
    }
}