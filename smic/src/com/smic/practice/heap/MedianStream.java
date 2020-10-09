package com.smic.practice.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class MedianStream {
    PriorityQueue<Integer> minHeap ;
    PriorityQueue<Integer> maxHeap ;

    MedianStream() {
        minHeap = new PriorityQueue<>() ;
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()) ;
    }

    public void addNum (int num ) {
        if (!minHeap.isEmpty() && num < minHeap.peek()) {
            maxHeap.offer(num) ;
            if (maxHeap.size() > (minHeap.size() +1)) {
                minHeap.offer(maxHeap.poll()) ;
            }
        }
        else {
            minHeap.offer(num) ;
            if (minHeap.size() > (maxHeap.size()+1)) {
                maxHeap.offer(minHeap.poll()) ;
            }
        }
        System.out.println(minHeap.size() + "," + maxHeap.size());
    }

    public int getMedian () {
        System.out.println("The size are " + minHeap.size() + "," + maxHeap.size());
        System.out.println("The top elements are " + minHeap.peek() + "," + maxHeap.peek());
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek() ;
        }
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek() ;
        }
        return ((maxHeap.peek() + minHeap.peek()) / 2 ) ;
    }

    public static void main(String[] args) {
        Random rand = new Random() ;
        MedianStream md = new MedianStream() ;
        for (int i = 0 ; i < 100 ; i++) {
            md.addNum(rand.nextInt(1000) - 500);
            if (rand.nextInt(100) < 50) {
                System.out.println(md.getMedian());
            }
        }
    }
}
