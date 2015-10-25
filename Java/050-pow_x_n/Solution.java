
public class Solution {

    public double myPow(double x, int n) {
        
        if (n==0)
            return 1;
        else if (n==1)
            return x;
        else if (n==-1)
            return 1/x;
        
        if (n%2 == 0) {
            // even power
            int halfPower = n/2;
            double subAns = myPow(x, halfPower);
            return subAns*subAns;
        }
        else {
            // odd power
            if (n < 0) {
                int evenPower = n + 1;
                double subAns = myPow(x, evenPower);
                return subAns * (1/x);
            }
            else {
                int evenPower = n - 1;
                double subAns = myPow(x, evenPower);
                return subAns * x;
            }
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        double ans = sol.myPow(2, 3);
        System.out.println(ans);
    }

}
