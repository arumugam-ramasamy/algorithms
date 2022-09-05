package com.evo.ib.top.streams;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianStream {
    PriorityQueue<Double> minHeap;
    PriorityQueue<Double> maxHeap;


    public MedianStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (!minHeap.isEmpty() && num < minHeap.peek()) {
            maxHeap.offer((double) num);
            if (maxHeap.size() > (minHeap.size() + 1)) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            minHeap.offer((double) num);
            if (minHeap.size() > (maxHeap.size() + 1)) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return ((maxHeap.peek() + minHeap.peek()) / 2);
    }
}
