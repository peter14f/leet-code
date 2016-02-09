
public class SolutionB {

    public int majorityElement(int[] nums) {
        
        int c = nums[0];
        int count = 1;
        
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == c) {
                count++;
            }
            else {
                count--;
                
                if (count == 0) {
                    c = nums[i];
                    count = 1;
                }
            }
        }
        
        return c;
    }
    
    public static void main(String[] args) {

        int[] nums = {2, 1, 2};
        SolutionB sol = new SolutionB();
        int maj = sol.majorityElement(nums);
        System.out.println(maj);
    }

}
