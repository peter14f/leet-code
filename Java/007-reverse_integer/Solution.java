
public class Solution {

    public int reverse(int x) {
        
        int ans = 0;
        
        boolean negative = false;
        
        if (x < 0) {
            negative = true;
            x = Math.abs(x);
        }
        
        do {
            int num = x % 10;
            int multiply = ans*10; // + num;
            
            if (ans != 0 && multiply/10 != ans) {
                return 0;
            }
            
            int new_ans = multiply + num;
            
            if (new_ans < ans) {
                return 0;
            }
            
            ans = new_ans;
            
            x = x / 10;
        } while (x > 0);
        
        if (negative) {
            ans = -ans;
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int ans;
        
        int input = -2147483648;
        ans = sol.reverse(input);
        System.out.println(ans);        
    }

}
