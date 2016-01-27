
public class SolutionBasic {

    public int countPrimes(int n) {
        int cnt = 0;
        
        for (int i=2; i<n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private boolean isPrime(int num) {
        if (num == 2 || num == 3)
            return true;
        
        for (int factor=2; factor*factor <= num; factor++) {
            if (num % factor == 0)
                return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int n = 999999;
        SolutionBasic sol = new SolutionBasic();
        int cnt = sol.countPrimes(n);
        System.out.println(cnt);
    }

}
