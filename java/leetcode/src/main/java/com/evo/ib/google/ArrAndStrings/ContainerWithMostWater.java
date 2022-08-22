package com.evo.ib.google.ArrAndStrings;

public class ContainerWithMostWater {

    public static int maxArea(int height[]) {
        int l = 0 ;
        int r = height.length-1 ;
        int area = 0 ;

        while (l < r) {

            area = Math.max(area, Math.min(height[l], height[r]) * (r-l)) ;
            if (height[l] < height[r])
                l+=1 ;
            else
                r -= 1 ;
        }
        return area ;
    }

    public static void main(String[] args)
    {
        int a[] = {1, 5, 4, 3};
        int b[] = {3, 1, 2, 4, 5};

        int len1 = 4;
        System.out.println( maxArea(a)+"\n" );

        int len2 = 5;
        System.out.println( maxArea(b) );
    }
}
