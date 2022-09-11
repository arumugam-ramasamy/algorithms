package com.evo.ib.heap;

import java.util.PriorityQueue;

public class KLargestElement {

        public static void main(String[] args) {


            int  [] num= {11,14,8,8, 9, 7, 6, 5, 4,3,2, 100};
            int k=3;
            PriorityQueue<Integer> largestNum=findElem(num,k);
            int i = largestNum.size() ;
            while (i> 0) {
                System.out.println("The " + k + "Biggest Numbers:" + largestNum.poll());
                --i ;
            }

        }

        public static PriorityQueue<Integer> findElem(int []num, int k){

            PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();

            //int  [] num= {11,14,8,8, 9, 7, 6, 5, 4,3,2, 100};

            for(int i=0;i<k;i++) {
                minHeap.add(num[i]);
            }

            for(int i=k;i<num.length;i++) {
                if (num[i] > minHeap.peek()) {
                    minHeap.offer(num[i]);
                    minHeap.remove();
                }
            }


            return minHeap;

        }





}
