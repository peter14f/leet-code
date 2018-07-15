
public class Solution {

    public int totalHammingDistance(int[] nums) {
        int totalDistance = 0;

        for (int i=0; i<32; i++) {
            int numOnes = 0;
            int numZeros = 0;
            for (int j=0; j<nums.length; j++) {
                if ((nums[j] & 1) == 1) {
                    numOnes++;
                } else {
                    numZeros++;
                }
                nums[j] = nums[j] >>> 1;
            }
            totalDistance += (numOnes * numZeros);
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        Solution sol = new Solution();
        int ans = sol.totalHammingDistance(nums);
        System.out.println(ans);
    }

}
