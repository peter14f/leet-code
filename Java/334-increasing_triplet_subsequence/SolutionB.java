
public class SolutionB {

    public boolean increasingTriplet(int[] nums) {
        
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        
        for (int i=0; i<nums.length; i++) {
            
            if (nums[i] <= x) {
                x = nums[i]; // update smallest seen so far
            }
            else if (nums[i] <= y) {
                y = nums[i]; // update 2nd smallest seen so far
            }
            else {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1};
        SolutionB sol = new SolutionB();
        boolean ans = sol.increasingTriplet(nums);
        System.out.println(ans);
    }

}
