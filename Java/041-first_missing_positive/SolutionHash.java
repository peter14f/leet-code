import java.util.Arrays;
import java.util.HashSet;


public class SolutionHash {

    public int firstMissingPositive(int[] nums) {
        
        HashSet<Integer> positiveNums = new HashSet<Integer>();
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                positiveNums.add(nums[i]);
            }
        }
        
        int i=1; 
        
        while (true) {
            if (!positiveNums.contains(i))
                return i;
            i++;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1,-55, -100};
        
        SolutionHash sol = new SolutionHash();
        int firstMissing = sol.firstMissingPositive(nums);
        
        System.out.println(firstMissing);
    }

}
