
public class Solution {

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int hammingDistance = 0;
        for (int i=0; i<32; i++) {
            if ((z & 1) == 1) {
                hammingDistance++;
            }
            z = z >>> 1;
        }
        return hammingDistance;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 8;
        
        Solution sol = new Solution();
        int ans = sol.hammingDistance(a, b);
        System.out.println(ans);
    }

}
