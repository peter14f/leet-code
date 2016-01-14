
public class Solution {

    public int titleToNumber(String s) {
        int sum = 0;
        int digit = 0;
        
        for (int i=s.length()-1; i>=0; i--) {
            int d = (int)Math.pow(26, digit);
            int num = s.charAt(i) - 'A' + 1;
            
            sum += num*d;
            
            digit++;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num = sol.titleToNumber("YZ");
        System.out.println(num);
    }

}
