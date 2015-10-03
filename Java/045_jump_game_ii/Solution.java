
public class Solution {
    
    // return the minimum number of jumps
    public int jump(int[] nums) {
        
        if (nums.length <= 1)
            return 0;
        
        int maxReachableIndex = nums[0];
        int k = 1; // counts the number of jumps made
        int steps = nums[0]; // how many more steps can I make to be considered having taken a total of only k jumps
        
        for (int i=1; i <= maxReachableIndex; i++) {
            steps--;
            
            if (i == nums.length - 1)
                return k;
                        
            if (i + nums[i] > maxReachableIndex) {
                maxReachableIndex = i + nums[i];
            }
            
            // must make at another jump to go further
            if (steps <= 0) {
                k++;
                
                // maxReachableIndex is the farthest location we can get
                // after making k jumps 
                steps = maxReachableIndex - i;
            }
        }
        
        return k;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        //            0 1 2 3 4
        
        //            2 4 4 4 8
        
        //            2 1 0 2 1
        int[] nums = {2,3,0,1,4};
        int minNumJumps = sol.jump(nums);
        
        System.out.println(minNumJumps);
    }

}
