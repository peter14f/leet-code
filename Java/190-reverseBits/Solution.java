
public class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int num = 0;
        
        for (int i=0; i<32; i++) {
            int b = n & 1;
            num = num | (b << (31-i));
            n = n>>1;
        }
        
        return num;
    }
    
    public int reverseBitsOptimized(int n) {
        int[] table = new int[16];
        table[1] = 8;
        table[2] = 4;
        table[3] = 12;
        table[4] = 2;
        table[5] = 10;
        table[6] = 6; // 0110 
        table[7] = 14; // 0111 
        table[8] = 1; // 1000 
        table[9] = 9; // 1001
        table[10] = 5; // 1010
        table[11] = 13; // 1011
        table[12] = 3; // 1100
        table[13] = 11;   // 1101
        table[14] = 7;    // 1110
        table[15] = 15;   // 1111
        
        int number = 0;
        
        for (int i=0; i<8; i++) {
            int a = n & 0xF;
            
            number = number | (table[a] << 4*(7-i));
            
            n = n >> 4;
        }
        
        return number;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num = sol.reverseBits(43261596);
        
        int a = sol.reverseBitsOptimized(43261596);
        
        System.out.println(num);
        System.out.println(a);
    }

}
