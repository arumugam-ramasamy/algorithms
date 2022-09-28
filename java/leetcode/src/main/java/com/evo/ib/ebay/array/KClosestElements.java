package com.evo.ib.ebay.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KClosestElements {

	public static List<Integer> kClosestElements(int[] arr, int k, int x) {
		if (arr == null || arr.length == 0) return null;
		int ind = findIndex(arr, x, 0, arr.length-1) ;
		int left = ind ;
		int right = ind +1 ;
		List<Integer> numList = new ArrayList<>() ;
		int count = 0 ;
		if (arr[left] == x ) {
			numList.add(arr[left]) ;
			--left ;
			++count ;
		}

		while (left >= 0 && right < arr.length && count < k) {
			if ((x-arr[left]) <= (arr[right] - x)) {
				numList.add(arr[left--]) ;
			}
			else {
				numList.add(arr[right++]) ;
			}
			count++ ;
		}
		Collections.sort(numList);
		return numList ;
	}

	public static int findIndex(int[] arr, int ele, int left, int right) {
		if (arr[right] <= ele) return right;
		if (arr[left] >= ele) return left;

		int mid = (left + right) / 2;
		if (arr[mid] <= ele && arr[mid + 1] > ele)
			return mid;

		if (arr[mid] > ele) return findIndex(arr, ele, left, mid - 1);
		else return findIndex(arr, ele, mid + 1, right);

	}

	public static void main(String[] args) {
		int arr[] = {12, 16, 22, 30, 35, 39, 42,
				45, 48, 50, 53, 55, 56
		};
		int n = arr.length;
		int x = 35, k = 4;
		System.out.println ( kClosestElements(arr, k, x)) ;
	}
}
