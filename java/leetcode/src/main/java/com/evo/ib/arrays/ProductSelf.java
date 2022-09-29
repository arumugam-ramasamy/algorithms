package com.evo.ib.arrays;



import java.util.Arrays;

public class ProductSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) return null ;
        if (nums.length <= 1) return nums ;
        int [] ans = new int[nums.length] ;
        Boolean TwoZero = null ;
        int product = 1 ;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == 0) {
                if (TwoZero == null) {
                    TwoZero = new Boolean(false) ;
                    Arrays.fill(ans, 0);
                }
                else {
                    TwoZero = true ;
                    return ans ;
                }
            }
            else {
                product = product * nums[i] ;
            }
        }
        for (int i = 0 ; i < nums.length ; i++){
            if (TwoZero == null) {
                ans[i] = product / nums[i] ;
            }
            else {
                if (nums[i] == 0) {
                    ans[i] = product;
                    break;
                }
            }
        }
    return ans ;
    }
}
