
public class Solution {

    public boolean isOneEditDistance(String s, String t) {
         int sMinusT = s.length() - t.length();
         String shortStr, longStr;
         
         if (sMinusT > 1 || sMinusT < -1)
             return false;
         
         if (sMinusT >= 1) {
             longStr = s;
             shortStr = t;
         }
         else {
             longStr = t;
             shortStr = s;
         }
        
         int i = 0; // to traverse longStr
         int j = 0; // to traverse shortStr
         int numOperation = 0;
         
         while (i < longStr.length()) {
             if (j == shortStr.length()) {
                 numOperation++;
                 break;
             }
             
             if (longStr.charAt(i) == shortStr.charAt(j)) {
                 i++;
                 j++;
             }
             else {
                 numOperation++;
                 
                 if (numOperation > 1)
                     return false;
                 
                 i++;
                 
                 if (sMinusT == 0) {
                     j++;
                 }
             }
         }
         
         return numOperation == 1;
    }
    
    public static void main(String[] args) {
        String s = "abc";
        String t = "avc";
        
        Solution sol = new Solution();
        boolean ans = sol.isOneEditDistance(s, t);
        System.out.println(ans);
    }

}
