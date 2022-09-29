package com.evo.ib.ebay.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.HashMap;
import java.util.Map;

public class ArraySum {

        private static<K, V> void insert(Map<K, List<V>> hashMap, K key, V value)
        {
            // if the key is seen for the first time, initialize the list
            hashMap.putIfAbsent(key, new ArrayList<>());
            hashMap.get(key).add(value);
        }

        // Utility function to print subarray `nums[i, j]`
        public static void printSubarray(int[] nums, int i, int j)
        {
            System.out.println(IntStream.range(i, j + 1)
                    .mapToObj(k -> nums[k])
                    .collect(Collectors.toList()));
        }

        // Function to find subarrays with the given sum in an array
        public static void printAllSubarrays(int[] nums, int target)
        {
            // create a map for storing the end index of all subarrays with
            // the sum of elements so far
            Map<Integer, List<Integer>> hashMap = new HashMap<>();

            // To handle the case when the subarray with the given sum starts
            // from the 0th index
            insert(hashMap, 0, -1);

            int sum_so_far = 0;

            // traverse the given array
            for (int index = 0; index < nums.length; index++)
            {
                // sum of elements so far
                sum_so_far += nums[index];

                // check if there exists at least one subarray with the given sum
                if (hashMap.containsKey(sum_so_far - target))
                {
                    List<Integer> list = hashMap.get(sum_so_far - target);
                    for (Integer value: list) {
                        printSubarray(nums, value + 1, index);
                    }
                }

                // insert (target so far, current index) pair into the map
                insert(hashMap, sum_so_far, index);
            }
        }

    public static int countSubarraysWithSumK(int[] a, int K) {
        int n = a.length;
        int count = 0;
        List<List<Integer>> total = new ArrayList<>() ;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                List<Integer> list = new ArrayList<>() ;
                for (int k = i; k <= j; k++) {
                    sum += a[k];
                    list.add(a[k]) ;
                }
                if (sum == K) total.add(list) ;
                count += (sum == K ? 1 : 0);
            }
        }

        return count;
    }

        public static void main (String[] args)
        {
            //int[] nums = { 3, 4, -7, 1, 3, 3, 1, -4 };
            int [] nums = {10, 1, 2, 7, 6, 1, 5} ;
            //Arrays.sort(nums);
            int target = 8;

            printAllSubarrays(nums, target);
            countSubarraysWithSumK(nums, target) ;
        }



}
