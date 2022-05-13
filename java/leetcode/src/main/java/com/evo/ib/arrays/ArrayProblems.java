package com.evo.ib.arrays;

import java.util.*;

public class ArrayProblems {

    public static void removeDuplicates(List<Integer> arr) {

        int i = 1, j = 0;

        while (i < arr.size()) {
            while (i < arr.size() && arr.get(i) == arr.get(j)) {
                i++;
            }
            if (i == arr.size()) break;
            j++;
            if (i != j)
                arr.set(j, arr.get(i));
            i++;

        }
        j++;
        arr.set(j, arr.get(i - 1));
        Iterator<Integer> itr = arr.listIterator();
        int k = 0;
        while (k < j) {
            itr.next();
            k++;
        }
        while (itr.hasNext()) {
            itr.remove();
            itr.next();
        }
    }

    private static Object resizeArray(Object oldArray, int newSize) {
        int oldSize = java.lang.reflect.Array.getLength(oldArray);
        Class elementType = oldArray.getClass().getComponentType();
        Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize);
        int preserveLength = Math.min(oldSize, newSize);
        if (preserveLength > 0)
            System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
        return newArray;
    }

    public static int removeDuplicatesArr(int[] arr) {

        int i = 1, j = 0;
        if (arr == null) return 0;
        if (arr.length <= 1) return arr.length;
        while (i < arr.length) {
            while (i < arr.length && arr[i] == arr[j]) {
                i++;
            }
            if (i == arr.length) break;
            j++;
            if (i != j)
                arr[j] = arr[i];
            i++;

        }
        j++;
        System.out.println(i + " , " + j);
        if (i != j)
            arr[j] = arr[i - 1];
        if (j < (arr.length))
            arr = (int[]) resizeArray(arr, j);
        ArrayProblems.printpureAr(arr);
        return j;
    }

    public static void printpureAr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("end");
    }

    public static void printArr(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + ",");
        }
        System.out.println("end");
    }

    public static void rotateArr(int[] arr, int steps) {
        if (arr == null) return;
        if (steps > arr.length) steps = steps % arr.length;
        if (arr.length <= 1) return;
        int a = arr.length - steps;
        reverseArr(arr, 0, a - 1);
        reverseArr(arr, a, arr.length - 1);
        reverseArr(arr, 0, arr.length - 1);
        printpureAr(arr);

    }

    public static void reverseArr(int[] arr, int left, int right) {
        if (arr == null) return;
        if (arr.length <= 1) return;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] productExceptSelf(int[] nums) {

        if (nums == null) return null;
        if (nums.length <= 1) return null;
        int numZeroes = 0;
        int product = 1;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZeroes++;
                if (numZeroes > 1) break;
                continue;
            } else {
                product *= nums[i];
            }
        }

        if (numZeroes > 1) {
            for (int i = 0; i < nums.length; i++) {
                ans[i] = 0;
            }
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            if (numZeroes == 1) {
                if (nums[i] == 0) {
                    ans[i] = product;
                } else {
                    ans[i] = 0;
                }
            } else {
                ans[i] = product / nums[i];
            }
        }
        return ans;
    }

    public static void iterativeQsort(int[] numbers) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        stack.push(numbers.length);
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (end - start < 2) {
                continue;
            }
            int p = start + ((end - start) / 2);
            p = partition(numbers, p, start, end);
            stack.push(p + 1);
            stack.push(end);
            stack.push(start);
            stack.push(p);
        }
    } /* * Utility method to partition the array into smaller array, and * comparing numbers to rearrange them as per quicksort algorithm. */

    private static int partition(int[] input, int position, int start, int end) {
        int l = start;
        int h = end - 2;
        int piv = input[position];
        swap(input, position, end - 1);
        while (l < h) {
            if (input[l] < piv) {
                l++;
            } else if (input[h] >= piv) {
                h--;
            } else {
                swap(input, l, h);
            }
        }
        int idx = h;
        if (input[h] < piv) {
            idx++;
        }
        swap(input, end - 1, idx);
        return idx;
    }

    /**
     * Utility method to swap two numbers in given array * * @param arr - array on which swap will happen * @param i * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static  boolean containsDuplicate(int[] nums) {
        iterativeQsort(nums);
        int i = 1 ;
        while (i < (nums.length)) {
            if (nums[i] == nums[i-1])  return true ;
            i++ ;
        }
        return false ;

    }

    public static  boolean containsDuplicateBySet(int[] nums) {
        Set<Integer> uniqs = new HashSet<>() ;

        int i = 0 ;
        while (i < (nums.length)) {
           if (uniqs.contains(nums[i]))
               return true ;
           else
               uniqs.add(nums[i]) ;
            i++ ;
        }
        uniqs = null ;
        return false ;

    }

    public static int singleNumber(int[] nums) {
        int eornum = 0 ;

        for (int i = 0 ; i < nums.length ; i++) {
            eornum ^= nums[i] ;
        }
        return eornum ;
    }

}
