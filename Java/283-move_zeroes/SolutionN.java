import java.util.Arrays;


public class SolutionN {

    public void moveZeroes(int[] nums) {
        int i = 0;
        
        int j = 0; // the index of to write the value to
        
        while (i < nums.length) {
            
            if (nums[i] != 0) {
                // write to location i, bump both i and j
                
                nums[j] = nums[i];
                i++;
                j++;
            }
            else {
                // the location to write to remains the same
                
                i++;
            }
        }
        
        // now j is the location to write the next element, but
        // there no more non-zero elements to write, so let's null
        // out elements starting at index j
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        SolutionN sol = new SolutionN();
        
        sol.moveZeroes(nums);
        
        System.out.println(Arrays.toString(nums));
    }

}
