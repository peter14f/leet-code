
public class Solution {

    public int trailingZeroes(int n) {
        int sum = 0;
        
        long num = n;
        long d = 5;
        
        while (true) {
            long m = num / d;
            
            if (m < 1)
                break;
            
            sum += m;
            d = d * 5;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.trailingZeroes(1808548329);
        System.out.println(ans);
    }

}
