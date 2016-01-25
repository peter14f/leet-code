
public class SolutionB {

    public int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            cnt++;
        }
        
        return (m <<cnt); 
    }
    
    public static void main(String[] args) {
        int m = 8;
        int n = 15;
        
        Solution sol = new Solution();
        int ans = sol.rangeBitwiseAnd(m, n);
        System.out.println(ans);
    }

}
