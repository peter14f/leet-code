
public class SolutionB {

    public int hammingWeight(int n) {
        /* for each 2-bit group, subtract its high bit
         * 
         * 00 - 0 =  0 = 0
         * 01 - 0 =  1 = 1
         * 10 - 1 =  1 = 1
         * 11 - 1 = 10 = 2
         * 
         */
        
        n = n - ((n>>1) & 0x55555555);
        // every two-bit group (max value is 2)
        
        n = (n & 0x33333333) + ((n>>2) &0x33333333);
        // every four-bit group (max value is 4)
        
        n = (n & 0x0F0F0F0F) + (n>>4 & 0x0F0F0F0F);
        // every eight-bit group (max value is 8)
        
        // 0x0A0B0C0D * 0x01010101 -> we want A+B+C+d
        n = (n * 0x01010101) >> 24;
        
        return n;
    }
    
    public static void main(String[] args) {
        int n = -1;
        SolutionB sol = new SolutionB();
        int a = sol.hammingWeight(n);
        System.out.println(a);
    }

}
