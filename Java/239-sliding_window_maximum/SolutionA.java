import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


public class SolutionA {

    // can assume k to be valid
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return nums;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] output = new int[nums.length-k+1];
        
        for (int i=0; i<k; i++) {
            pq.offer(nums[i]);
        }
        output[0] = pq.peek();
        
        for (int i=k; i<nums.length; i++) {
            int toRemove = nums[i-k];
            pq.remove(toRemove);
            pq.offer(nums[i]);
            output[i-k+1] = pq.peek();
        }
        
        return output;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        SolutionA sol = new SolutionA();
        int[] output = sol.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(output));
    }

}
