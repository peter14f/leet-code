import java.util.HashSet;


public class Solution {

    public int longestConsecutive(int[] nums) {
        
        if (nums.length ==0)
            return 0;
        
        HashSet<Integer> numbers = new HashSet<Integer>();
        
        for (int i=0; i<nums.length; i++)
            numbers.add(nums[i]);
        
        int maxLength = 0;
        
        for (int i=0; i<nums.length; i++) {
            if (numbers.contains(nums[i])) {
                int length = consectiveSequenceLength(nums, i, numbers);
                
                if (length > maxLength)
                    maxLength = length;
            }
        }
        
        return maxLength;
    }
    
    private int consectiveSequenceLength(
            int[] nums, int index, 
            HashSet<Integer> numbers) {
        
        int x = nums[index];
        
        int small = x - 1;
        int leftLength = 0;
        
        while (numbers.contains(small)) {
            numbers.remove(small);
            leftLength++;
            small--;
        }
        
        int big = x + 1;
        int rightLength = 0;
        
        while (numbers.contains(big)) {
            numbers.remove(big);
            rightLength++;
            big++;
        }
        
        return 1 + rightLength + leftLength;
    }
    
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        Solution sol = new Solution();
        
        int length = sol.longestConsecutive(nums);
        System.out.println(length);
    }

}
