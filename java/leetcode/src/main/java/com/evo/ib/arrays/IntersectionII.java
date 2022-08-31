package com.evo.ib.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionII {
    public static int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0) return null ;
        if (nums2 == null || nums2 .length == 0) return null ;
        List<Integer> common = new ArrayList<>() ;
        Map<Integer, Integer> nums1Freq = new HashMap<>() ;
        for (int num : nums1) {
            if (nums1Freq.containsKey(num)) {
                nums1Freq.put(num, nums1Freq.get(num) +1) ;
            }
            else  {
                nums1Freq.put(num, 1) ;
            }
        }
        for (int num : nums2) {
            if (nums1Freq.containsKey(num)) {
                common.add(num) ;
                nums1Freq.put(num, nums1Freq.get(num) -1) ;
                if (nums1Freq.get(num) == 0){
                    nums1Freq.remove(num) ;
                }
            }
        }
        int [] commarr = new int[common.size()] ;
        int i = 0 ;
        for (int num : common) {
            commarr [i++] = num ;
        }
        return commarr ;
    }

    public static void main(String[] args) {
    }
}
