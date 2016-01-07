
public class SolutionA {

    public int singleNumber(int[] nums) {
        
        int ones = 0;
        int twos = 0;
        
        for (int i=0; i<nums.length; i++) {
            twos = ones & nums[i]; 
            ones = ones | nums[i];
            
            ones = ones & ~twos;
        }
        
        return ones;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
