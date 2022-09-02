package com.evo.ib.top.array;

public class GetMedianSortedArray {
    public static int getMedianSortedArray(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int count;
        int n = nums1.length;
        int m = nums2.length;
        int m1 = -1, m2 = -1;

        if ((m + n) % 2 == 1) {
            for (count = 0;
                 count <= (n + m) / 2;
                 count++) {
                if (i != n && j != m) {
                    m1 = (nums1[i] > nums2[j]) ?
                            nums2[j++] : nums1[i++];
                } else if (i < n) {
                    m1 = nums1[i++];
                } else {
                    m1 = nums2[j++];
                }
            }
            return m1;
        } else {
            for (count = 0;
                 count <= (n + m) / 2;
                 count++) {
                m2 = m1;
                if (i != n && j != m) {
                    m1 = (nums1[i] > nums2[j]) ?
                            nums2[j++] : nums1[i++];
                } else if (i < n) {
                    m1 = nums1[i++];
                } else {
                    m1 = nums2[j++];
                }
            }
            return (m1 + m2) / 2;
        }
    }
}

