import java.util.ArrayList;


public class Solution {

    /* 0  A
     * 1  B
     * 2  C
     * 
     * 25 Z
     * 26 AA
     * 
     * 
     * 676 YZ
     * 677 ZA
     */
    public int converToNum(String str) {
        char[] s = str.toCharArray();
        int sum = 0;
        
        int digit = 0;
        
        for (int i=s.length-1; i>=0; i--) {
            char c = s[i];
            int num = c - 'A' + 1;
            
            sum = sum + (int)(num*Math.pow(26, digit));
            digit++;
        }
        
        return sum;
    }
    
    public String convertToTitle(int n) {
        
        if (n <= 0)
            return "";
        
        int digit = 0;
        
        while (true) {
            digit++;
            long d = (long) Math.pow(26, digit);
            long q = n / d;
            if (q == 0)
                break;
        }
        
        digit--;
        
        ArrayList<Integer> v = new ArrayList<Integer>();
        while (digit >= 0) {
            int d = (int) Math.pow(26, digit);
            int q = n / d;
            v.add(q);
            n = n - (q*d);
            digit--;
        }
        
        for (int i=v.size()-1; i>0; i--) {
            if (v.get(i) == 0) {
                v.set(i-1, v.get(i-1) - 1);
                v.set(i, 26);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i=0; i<v.size(); i++) {
            if (i==0 && v.get(i) == 0)
                continue;
            
            sb.append((char)(v.get(i) + 'A' - 1));
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = sol.convertToTitle(702);
        System.out.println(s);
    }

}
