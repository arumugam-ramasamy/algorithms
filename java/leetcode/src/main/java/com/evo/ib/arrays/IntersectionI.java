package com.evo.ib.arrays;

import java.util.HashSet;
import java.util.Set;

public class IntersectionI {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null) return null ;
        if (nums2 == null) return null ;
        Set<Integer> common = new HashSet<>() ;
        Set<Integer> numsPresent = new HashSet<>() ;
        for (int i = 0; (i < nums1.length) ; i++) {
            numsPresent.add(nums1[i]) ;
        }
        for (int i = 0 ; i < nums2.length ; i++) {
            if (numsPresent.contains(nums2[i]))
                common.add(nums2[i]) ;
        }

        int [] commarr = new int[common.size()] ;
        int i = 0 ;
        for (int num : common) {
            commarr[i++] = num ;
        }
        return commarr ;
    }
}
