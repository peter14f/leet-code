
public class Solution {

    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (right >= left) {
            int sum = left*left + right*right;
            if (sum == c) {
                return true;
            }

            if (sum > c) {
                // too big
                right--;
            } else {
                // too small
                left++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean ans = sol.judgeSquareSum(2147482647);
        System.out.println(ans);
    }

}
