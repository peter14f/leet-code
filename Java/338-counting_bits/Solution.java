import java.util.Arrays;

public class Solution {

    public int[] countBits(int num) {
        
        int[] bitCount = new int[num+1];
        
        if (num==0)
            return bitCount;
        
        bitCount[1] = 1;
        
        if (num==1)
            return bitCount;
        
        int i = 2;
        int msb = 2;
        int count = msb;
        
        while (i <= num) {
            if (count > 0) {
                // prevI is i with msb cleared
                int prevI = i & (msb-1);
                bitCount[i] = 1 + bitCount[prevI]; 
                count--;
                
                i++;
            }
            else {
                msb = msb << 1;
                count = msb;
            }
        }
        
        return bitCount;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] bitCount = sol.countBits(5);
         
        System.out.println(Arrays.toString(bitCount));
    }

}
