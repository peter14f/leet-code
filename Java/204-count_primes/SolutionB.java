
public class SolutionB {

    public int countPrimes(int n) {
        
        boolean[] isNotPrime = new boolean[n];
        
        for (int i=2; i*i < n; i++) {
            
            /* if a number has been marked not prime, its multiples must 
             * have also been marked as well
             */
            if (isNotPrime[i])
                continue;
            
            /* multiple starts at i because all multiples of smaller numbers
             * have been marked
             */
            for (int mult=i; mult*i < n; mult++) {
                if (!isNotPrime[mult*i])
                    isNotPrime[mult*i] = true;
            }
        }
        
        
        int cnt = 0;
        
        for (int i=2; i<n; i++) {
            if (!isNotPrime[i])
                cnt++;
        }
        
        return cnt;
    }
    
    public static void main(String[] args) {
        SolutionB sol = new SolutionB();
        int cnt = sol.countPrimes(999999);
        System.out.println(cnt);
    }

}
