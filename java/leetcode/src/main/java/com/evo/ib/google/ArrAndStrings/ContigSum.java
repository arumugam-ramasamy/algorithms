package com.evo.ib.google.ArrAndStrings;

import java.nio.file.FileSystemNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ContigSum {

    public static Set<String> contigSubSum(int[] arr, int target) {

        int sum = 0;
        int start = 0;
        Set<String> sols = new TreeSet<>();
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == target) {
                String sol = start + ":" + i;
                System.out.println(sol);
                sols.add(sol);
            }
            if (sum > target) {
                while (sum > target) {
                    sum -= arr[start];
                    start++;
                }
            }
        }
        if (sum == target) {
            String sol = start + ":" + (i - 1);
            System.out.println(sol);
            sols.add(sol);
        }

        return sols;
    }

    public static Set<String> contigMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Set<String> sols = new HashSet<>();
        int curr_max = arr[0] ;
        int start = 0;
        int end = 0;
        int new_max = 0;
        int newStart = 0 ;
        boolean newSeen = false ;
        for (int i = 1; i < arr.length; i++) {
            new_max = new_max + arr[i] ;
            if (new_max < 0) {
                newSeen = true ;
                newStart = i ;
                new_max = 0;
            }
            else if (new_max > curr_max) {
                sols.clear();
                curr_max = new_max;
                if (newSeen) {
                    newSeen = false ;
                    start = newStart +1;
                }
                end = i;
                sols.add(start + ":" + end + " " + curr_max);
            }


        }
        return sols;
    }

    static int maxSubArraySum(int a[],int size)
    {

        int max_so_far = a[0], max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;

        /* Do not compare for all
           elements. Compare only
           when max_ending_here > 0 */
            else if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;

        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        System.out.println(contigSubSum(arr, 23));
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(contigMaxSum(a));
        System.out.println(maxSubArraySum(a, a.length));
    }
}
