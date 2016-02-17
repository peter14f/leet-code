import java.util.Arrays;
import java.util.LinkedList;


public class SolutionB {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return nums;
        
        int[] output = new int[nums.length-k+1];
        
        LinkedList<Integer> dequeue = new LinkedList<Integer>();
        
        for (int i=0; i<k; i++) {
            while (!dequeue.isEmpty() && nums[i] >= nums[dequeue.getLast()]) {
                dequeue.removeLast();
            }
            
            dequeue.add(i);
        }
        
        output[0] = nums[dequeue.getFirst()];
        
        /* Notice that the dequeue size always store <= k indices */
        for (int i=k; i<nums.length; i++) {
            while (!dequeue.isEmpty() && nums[i] >= nums[dequeue.getLast()]) {
                dequeue.removeLast();
            }
            
            while (!dequeue.isEmpty() && dequeue.getFirst() <= i-k) {
                dequeue.removeFirst();
            }
            
            dequeue.add(i);
            output[i-k+1] = nums[dequeue.getFirst()];
        }
        
        return output;
    }
    
    public static void main(String[] args) {
        int[] nums = {1};
        SolutionB sol = new SolutionB();
        int[] output = sol.maxSlidingWindow(nums, 1);
        System.out.println(Arrays.toString(output));
    }

}
