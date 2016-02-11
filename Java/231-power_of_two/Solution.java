
public class Solution {

    public boolean isPowerOfTwo(int n) {
        // number of bits set
        int numBits = 0;
        
        do {
            if ((n & 1) == 1) {
                numBits++;
                if (numBits > 1)
                    return false;
            }
            n = n >> 1;
        } while (n != 0);
        
        return (numBits==1);
    }
    
    public static void main(String[] args) {
        int n = 0x80000000;
        Solution sol = new Solution();
        boolean ans = sol.isPowerOfTwo(n);
        System.out.println(ans);
    }

}
