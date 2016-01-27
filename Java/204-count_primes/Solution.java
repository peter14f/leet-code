public class Solution {

    public int countPrimes(int n) {
        if (n < 2)
            return 0;
        
        boolean[] isNotPrime = new boolean[n];
        
        int limit = (int)Math.ceil(Math.sqrt(n));
        
        for (int num=2; num <= limit; num++) {
            
            int multiple = num;
            
            while (true) {
                int product = num * multiple;
                
                if (product < n)
                    isNotPrime[product] = true;
                else
                    break;
                
                multiple++;
            }    
        }
        
        int sum = 0;
        
        for (int i=2; i<n; i++) {
            if (!isNotPrime[i])
                sum++;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int cnt = sol.countPrimes(999999);
        System.out.println(cnt);
    }

}
