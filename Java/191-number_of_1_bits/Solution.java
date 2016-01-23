
public class Solution {

    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i=0; i<32; i++) {
            if ((n & 1) == 1) {
                cnt++;
            }
            n = n>>1;
        }
            
        return cnt;
    }
    
    public static void main(String[] args) {
        int n = -1;
        Solution sol = new Solution();
        int cnt = sol.hammingWeight(n);
        System.out.println(cnt);
    }

}
