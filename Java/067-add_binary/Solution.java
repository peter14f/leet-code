
public class Solution {

    public String addBinary(String a, String b) {
        
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        
        int aIndex = aChars.length - 1;
        int bIndex = bChars.length - 1;
        
        StringBuffer sb = new StringBuffer();
        
        int carryBit = 0;
        while (aIndex >= 0 && bIndex >= 0) {
            int aBit = aChars[aIndex] - '0';
            int bBit = bChars[bIndex] - '0';
            int sum = aBit + bBit + carryBit;
            
            if (sum < 2) {
                carryBit = 0;
                sb.append(sum);
            }
            else {
                if (carryBit==0)
                    carryBit = 1;
                
                if (sum == 2) {
                    sb.append(0);
                }
                else {
                    // must be 3
                    sb.append(1);
                }
            }
            
            aIndex--;
            bIndex--;
        }
        
        int longIndex = -1;
        char[] longChars = null;
        if (aIndex >= 0) {
            longIndex = aIndex;
            longChars = aChars;
        }
        else if (bIndex >=0) {
            longIndex = bIndex;
            longChars = bChars;
        }
        
        while (longIndex >= 0) {
            int bit = longChars[longIndex] - '0';
            int sum = carryBit + bit;
            
            if (sum < 2) {
                carryBit = 0;
                sb.append(sum);
            }
            else {
                if (carryBit==0)
                    carryBit = 1;
                
                sb.append(0);
            }
            
            longIndex--;
        }
        
        if (carryBit==1)
            sb.append(1);
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        String a =  "11";
        String b =  "11";
        
        Solution sol = new Solution();
        String c = sol.addBinary(a, b);
        System.out.println(c);
    }

}
