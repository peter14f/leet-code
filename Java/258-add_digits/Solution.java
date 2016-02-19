
public class Solution {

    // the test cases did not throw a negative input
    public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            while (num != 0) {
                int a = num % 10;
                sum += a;
                num = num / 10;
            }
            
            num = sum;
        }
        
        return num;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int result = sol.addDigits(11);
        System.out.println(result);
        
    }

}
