package com.evo.javateaching.arrays;

import java.util.ArrayList;
import java.util.Random;

public class Array1D {

    int [] arr ;
    int [] sortedArr ;
    int sizearr ;
    int maxRandom ;
    Random rand = new Random() ;
    int max ;
    int min ;

    public Array1D () {
        this.sizearr = rand.nextInt(1000) + 100 ;
        this.maxRandom = rand.nextInt(1000) + 100 ;
        this.arr = new int[this.sizearr] ;
        this.sortedArr  = new int[this.sizearr] ;
        for (int i = 0 ; i < this.sizearr ; i++) {
            this.arr[i] = rand.nextInt(this.maxRandom) - rand.nextInt(1000);
            this.sortedArr[i]= this.arr[i] ;
        }
    }

    public int returnMax () {
        this.max = Integer.MIN_VALUE ;
        for (int i = 0 ; i < this.arr.length ; i++) {
            if (this.max < this.arr[i])
                this.max = this.arr[i] ;
        }
        return this.max ;
    }

    public int returnMin () {
        this.min = Integer.MAX_VALUE ;
        for (int i = 0 ; i < this.arr.length ; i++) {
            if (this.min > this.arr[i])
                this.min = this.arr[i] ;
        }
        return this.min ;
    }

    public void selectionSort () {

        for (int i = 0 ; i < this.sortedArr.length - 1 ; i++) {
            int j ;
            int min = i ;
            for (j = i +1 ; j < this.sortedArr.length ; j++) {
                if (this.sortedArr[j] < this.sortedArr[min]) {
                    min = j ;
                }
            }
            if (min != i) {
                int temp = this.sortedArr[i] ;
                this.sortedArr[i] = this.sortedArr[min] ;
                this.sortedArr[min] = temp ;
            }
        }
    }

    public void bubbleSort () {
        boolean swapped ;

        for (int i = 0 ; i < this.sortedArr.length - 1; i++) {

            swapped = false ;
            for (int j = 0 ; j < this.sortedArr.length -i  -1 ; j++) {
                if (this.sortedArr[j] > this.sortedArr[j+1]) {
                    int temp = this.sortedArr[j] ;
                    this.sortedArr[j] = this.sortedArr[j+1] ;
                    this.sortedArr[j+1] = temp ;
                    swapped = true ;
                }
            }
            if (swapped == false) break ;
        }
    }



    public void insertionSort() {

            for (int i = 1 ; i < sortedArr.length ; i++) {
                int key = sortedArr[i] ;
                int j = i - 1 ;
                while (j >= 0 ) {
                    if (sortedArr[j] > key) {
                        sortedArr[j + 1] = sortedArr[j];
                        j--;
                    }
                    else break ;
                }
                sortedArr[j+1] = key ;
            }
    }

    public void printArr(int [] arr) {
        if (arr.length > 1) System.out.print(arr[0]) ;
        for (int i = 1 ; i < arr.length ; i++){
            System.out.print(" , " + arr[i]) ;
        }
        System.out.println();
    }

    public void restoreOrig () {
        for (int i = 0 ; i < this.arr.length ; i++) {
            this.sortedArr[i] = this.arr[i] ;
        }
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getSizearr() {
        return sizearr;
    }

    public void setSizearr(int sizearr) {
        this.sizearr = sizearr;
    }

    public int getMaxRandom() {
        return maxRandom;
    }

    public void setMaxRandom(int maxRandom) {
        this.maxRandom = maxRandom;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int[] getSortedArr() {
        return sortedArr;
    }

    public void setSortedArr(int[] sortedArr) {
        this.sortedArr = sortedArr;
    }

    public static void main(String[] args) {
        Array1D arr1D = new Array1D() ;
        System.out.println(arr1D.returnMax() + " , " + arr1D.returnMin());
        arr1D.printArr(arr1D.getSortedArr());
        arr1D.selectionSort();
        arr1D.printArr(arr1D.getSortedArr());
        arr1D.restoreOrig();
        arr1D.bubbleSort(); ;
        arr1D.printArr(arr1D.getSortedArr());
        arr1D.restoreOrig();
        arr1D.insertionSort();
        arr1D.printArr(arr1D.getSortedArr());
    }
}
