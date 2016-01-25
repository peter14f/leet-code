
public class Solution {

    public int rangeBitwiseAnd(int m, int n) {
        int result = m;
        
        for (int i=m+1; i<=n; i++) {
            result = result & i;
            if (result == 0)
                break;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int m = 5;
        int n = 7;
        
        Solution sol = new Solution();
        int ans = sol.rangeBitwiseAnd(m, n);
        System.out.println(ans);
    }

}
