package com.evo.ib.top.array;

public class FindPeak {
    // A binary search based function that returns index of
    // a peak element
    public int findPeakElement(int nums[])
    {
        if (nums == null || nums.length == 0) return -1 ;
        if (nums.length == 1) return 0 ;
        int n = nums.length ;
        int l = 0;
        int r = n-1;
        int mid = 0;

        while (l <= r) {

            // finding mid by binary right shifting.
            mid = (l + r) >> 1;

            // first case if mid is the answer
            if ((mid == 0
                    || nums[mid - 1] <= nums[mid])
                    && (mid == n - 1
                    || nums[mid + 1] <= nums[mid]))
                break;

            // move the right pointer
            if (mid > 0 && nums[mid - 1] > nums[mid])
                r = mid - 1;

                // move the left pointer
            else
                l = mid + 1;
        }

        return mid;
    }

}
