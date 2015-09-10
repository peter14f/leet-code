
public class Solution {

    public int romanToInt(String s) {
       int i = 0;
       char[] s_arr = s.toCharArray();
       int n = s_arr.length;
       
       int sum = 0;
       
       while (i < n) {
           
           if (i + 1 < n) {
               int subtraction = getSubtraction(s_arr[i], s_arr[i+1]);
               
               if (subtraction > 0) {
                   sum += subtraction;
                   i++;
               }
               else {
                   sum += getSingleRomanCharToInt(s_arr[i]);
               }
           }
           else {
               sum += getSingleRomanCharToInt(s_arr[i]);
           }
           
           i++;
       }
       
       return sum;
    }
    
    private int getSingleRomanCharToInt(char c) {
        int num = 0;
        switch(c) {
            case 'I':
                num = 1;
                break;
            case 'V':
                num = 5;
                break;
            case 'X':
                num = 10;
                break;
            case 'L':
                num = 50;
                break;
            case 'C':
                num = 100;
                break;
            case 'D':
                num = 500;
                break;
            case 'M':
                num = 1000;
                break;
            default:
                num = 0;
        }
        return num;
    }
    
    /**
     * I -    1
     * V -    5
     * X -   10
     * L -   50
     * C -  100
     * D -  500
     * M - 1000
     */
    private int getSubtraction(char cur, char next) {
        int subtraction = 0;
        
        if (cur == 'I') {
            if (next == 'V')
                subtraction = 4;
            else if (next == 'X')
                subtraction = 9;
        }
        else if (cur == 'X') {
            if (next == 'L')
                subtraction = 40;
            else if (next == 'C')
                subtraction = 90;
        }
        else if (cur == 'C') {
            if (next == 'D')
                subtraction = 400;
            else if (next == 'M')
                subtraction = 900;
        }
        
        return subtraction;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "MMMCMXCIX";
        int ans = sol.romanToInt(s);
        System.out.println(ans);
    }

}
