
public class Solution {

    public int mySqrt(int x) {
        
        if (x < 0)
            throw new IllegalArgumentException();
        
        for (int i=1; i<=x; i++) {
            long product = (long)i * i;
            
            if (product == x) {
                return i;
            }
            else if (product > x) {
                return i - 1;
            }
        }
        
        return 0;
    }
    
    
    // TC 1
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.mySqrt(Integer.MAX_VALUE);
        
        System.out.println(ans);
    }

}
