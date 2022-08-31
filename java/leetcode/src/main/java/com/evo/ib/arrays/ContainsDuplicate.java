package com.evo.ib.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>() ;

        for (int num : nums) {
            if (numbers.contains(num))
                return true ;
            numbers.add(num) ;
        }
        return false ;
    }
}
