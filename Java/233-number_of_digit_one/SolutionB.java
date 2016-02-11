
public class SolutionB {

    private int countOnes(int n) {
        int num = 0;
        
        while (n > 0) {
            if ((n % 10) == 1)
                num++;
            n = n / 10;
        }
        
        return num;
    }
    
    public int countDigitOne(int n) {
        int sum = 0;
        
        while (n > 0) {
            int num = countOnes(n);
            sum += num;
            n--;
        }
                
        return sum;
    }
    
    public static void main(String[] args) {
        int n = 11;
        SolutionB sol = new SolutionB();
        int ans = sol.countDigitOne(n);
        System.out.println(ans);
    }

}
