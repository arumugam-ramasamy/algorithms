package com.evo.ib.google.ArrAndStrings;

public class MinJump {
    public static boolean canJump(int[] nums) {
        if (minJumps(nums, nums.length) != Integer.MAX_VALUE)
            return true ;
        return false;
    }

    public static int minJumps(int arr[], int n)
    {
        // jumps[0] will hold the result
        int[] jumps = new int[n];
        int min;

        // Minimum number of jumps needed to reach last
        // element from last elements itself is always 0
        jumps[n - 1] = 0;

        // Start from the second element, move from right to
        // left and construct the jumps[] array where
        // jumps[i] represents minimum number of jumps
        // needed to reach arr[m-1] from arr[i]
        for (int i = n - 2; i >= 0; i--) {
            // If arr[i] is 0 then arr[n-1] can't be reached
            // from here
            if (arr[i] == 0)
                jumps[i] = Integer.MAX_VALUE;

                // If we can directly reach to the end point
                // from here then jumps[i] is 1
            else if (arr[i] >= n - i - 1)
                jumps[i] = 1;

                // Otherwise, to find out the minimum number of
                // jumps needed to reach arr[n-1], check all the
                // points reachable from here and jumps[] value
                // for those points
            else {
                // initialize min value
                min = Integer.MAX_VALUE;

                // following loop checks with all reachable
                // points and takes the minimum
                for (int j = i + 1;
                     j < n && j <= arr[i] + i; j++) {
                    if (min > jumps[j])
                        min = jumps[j];
                }

                // Handle overflow
                if (min != Integer.MAX_VALUE)
                    jumps[i] = min + 1;
                else
                    jumps[i] = min; // or Integer.MAX_VALUE
            }
        }
        //System.out.println(jumps[0]) ;

        return jumps[0];
    }

    public static int minJump(int[] arr, int n)
    {
        // jumps[n-1] will hold the
        int jumps[] = new int[n];
        // result
        int i, j;

        // if first element is 0,
        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;
        // end cannot be reached

        jumps[0] = 0;

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j]
                        && jumps[j]
                        != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }

    // driver program to test above function
    public static void main(String[] args)
    {
        int arr[] = { 1, 3, 6, 1, 0, 9 };

        System.out.println("Minimum number of jumps to reach end is : "
                + minJumps(arr, arr.length));
    }
}
