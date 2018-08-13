import java.util.LinkedList;

public class MovingAverage {
    LinkedList<Integer> ll;
    int sum;
    int maxSize;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.ll = new LinkedList<>();
        this.sum = 0;
        this.maxSize = size;
    }
    
    public double next(int val) {
        if (this.ll.size() == this.maxSize) {
            this.sum -= this.ll.removeFirst();
        }
        this.ll.add(val);
        this.sum += val;
        return ((double)this.sum) / this.ll.size();
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
