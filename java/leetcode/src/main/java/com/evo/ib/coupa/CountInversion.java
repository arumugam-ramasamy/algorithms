package com.evo.ib.coupa;

import java.util.Arrays;

public class CountInversion {
    // Function to count the number of inversions
    // during the merge process
    private static int mergeAndCount(int[] arr, int l, int m, int r)
    {

        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        // Fill from the rest of the left subarray
        while (i < left.length)
            arr[k++] = left[i++];

        // Fill from the rest of the right subarray
        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }

    // Merge sort function
    private static int mergeSortAndCount(int[] arr, int l, int r)
    {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, l, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);

            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

    public static int merAndCount (int [] arr, int left, int right) {
        int count = 0 ;

        if (left < right) {
            int middle = (right+left) / 2 ;

            count += merAndCount(arr, left, middle) ;
            count += merAndCount(arr, middle+1, right) ;
            count += merSortAndCount (arr, left, middle, right) ;
        }
        return  count ;
    }

    public static int merSortAndCount(int [] arr, int left, int middle, int right) {
        int [] thisleft = Arrays.copyOfRange(arr, left, middle+1) ;
        int [] thisright = Arrays.copyOfRange(arr, middle+1, right+1) ;

        int i = 0 ;
        int j = 0 ;
        int k = left ;
        int swaps = 0 ;

        while (i < thisleft.length && j < thisright.length) {
            if (thisleft[i] < thisright[j]) {
                arr[k++] = thisleft[i++];
            } else {
                arr[k++] = thisright[j++];
                swaps += (middle + 1) - (left + i);
            }
        }
            while (i < thisleft.length){
                arr[k++] = thisleft[i++] ;
            }
            while (j < thisright.length) {
                arr[k++] = thisright[j++] ;
            }

        return  swaps ;
    }
    public static void main(String[] args)
    {
        int[] arr = { 10, 9, 8, 7, 6, 5,4,3,2,1};

        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1));
        int[] arr1 = { 10, 9, 8, 7, 6, 5,4,3,2,1};
        System.out.println(merAndCount(arr1, 0, arr.length-1));
    }

}
