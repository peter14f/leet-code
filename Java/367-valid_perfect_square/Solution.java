
public class Solution {

    public boolean isPerfectSquare(int num) {

        long left = 0;
        long right = num;

        while (right >= left) {
            long m = left + (right-left)/2;
            
            long squared = m * m;
            
            if (squared == num) {
                return true;
            } 
            
            if (squared > num) {
                // too big
                right = m - 1;
            } else {
                // too small
                left = m + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean ans = sol.isPerfectSquare(2147483647);
        System.out.println(ans);
    }

}
