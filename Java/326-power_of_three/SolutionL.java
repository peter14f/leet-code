
public class SolutionL {

    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        
        int x = (int) (Math.log10(n) / Math.log10(3));
        
        System.out.println("x=" + x);
        
        return (Math.pow(3, x) == n);
    }
    
    public static void main(String[] args) {
        SolutionL sol = new SolutionL();
        boolean isP3 = sol.isPowerOfThree(27);
        System.out.println(isP3);
    }

}
