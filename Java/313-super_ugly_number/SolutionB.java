import java.util.ArrayList;
import java.util.List;


public class SolutionB {

    public int nthSuperUglyNumber(int n, int[] primes) {
        
        List<Integer> results = new ArrayList<Integer>();
        int k = primes.length;
        
        // all indices initialized to zero
        int[] index = new int[k];
        
        results.add(1);
        
        while (results.size() < n) {
            
            int min = Integer.MAX_VALUE;
            
            for (int i=0; i<k; i++) {
                if (primes[i] * results.get(index[i]) < min) {
                    // saving minIndex in here would not catch multiple min indices
                    min = primes[i] * results.get(index[i]);
                }
            }
            
            results.add(min);
            
            // you may have to catch more than one list
            for (int i=0; i<k; i++) {
                if (primes[i] * results.get(index[i]) == min) {
                    index[i]++;
                }
            }
        }
        
        return results.get(n-1);
    }
    
    public static void main(String[] args) {
        SolutionB sol = new SolutionB();
        int[] primes = {2, 7, 13, 19};
        
        int ans = sol.nthSuperUglyNumber(12, primes);
        
        System.out.println(ans);
    }

}
