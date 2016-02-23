import java.util.Collections;
import java.util.PriorityQueue;


public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        
        if (maxHeap.size() == minHeap.size()) {
            maxHeap.offer(num);
        }
        else {
            // size off by 1, insert to smaller heap
            if (minHeap.size() < maxHeap.size()) {
                minHeap.offer(num);
            }
            else {
                maxHeap.offer(num);
            }
        }
        
        while (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            maxHeap.offer(minHeap.poll());
            minHeap.offer(maxHeap.poll());
        }
        
        //System.out.println("minHeao=" + minHeap);
        //System.out.println("maxHeao=" + maxHeap);
    }

    // Returns the median of current data stream
    public double findMedian() {
        
        if (minHeap.size() > maxHeap.size())
            return minHeap.peek();
        else if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return (double)(minHeap.peek() + maxHeap.peek())/2;
    }
    
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        
        mf.addNum(1);
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(1);
        mf.addNum(1);
        
        System.out.println(mf.findMedian());
    }

}
