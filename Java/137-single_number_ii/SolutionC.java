
public class SolutionC {

    public int singleNumber(int[] nums) {

        int result = 0;

        // for each bit
        for (int k=0; k<32; k++) {
            int sum = 0; // the number of 1s we see at bit k

            // for each number
            for (int i=0; i<nums.length; i++) {
                if ((nums[i] & (1 << k)) != 0) {
                    // bit k is set
                    sum = sum + 1;
                }
            }

            // set bit k in result
            if ((sum % 3) != 0) {
                result = result | (1 << k);
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        
    }

}
