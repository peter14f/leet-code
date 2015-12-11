
public class SolutionB {

    public int singleNumber(int[] nums) {
        
        int ones = 0, twos = 0, threes = 0;
        
        for (int i=0; i<nums.length; i++) {
            threes = twos & nums[i]; // bits that have already occurred twice, 
            twos = twos | (ones & nums[i]); // bits that have already occured twice | bits that have already occured twice
            ones = ones | nums[i];
            
            twos = twos & ~threes; // clear bits that have just been seen three times
            ones = ones & ~threes; // clear bits that have just been seen three times
        }
        
        return ones;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        SolutionB sol = new SolutionB();
        int single = sol.singleNumber(nums);
        System.out.println(single);
    }

}
