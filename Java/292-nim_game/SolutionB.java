
public class SolutionB {

    public boolean canWinNim(int n) {
        
        if (n < 1)
            return false;
        else if (n <= 3)
            return true;
        
        boolean prev3 = true;
        boolean prev2 = true;
        boolean prev1 = true;
        
        boolean cur = false;
        
        for (int i=4; i<=n; i++) {
            
            if  (prev1 && prev2 && prev3) {
                cur = false;
            }
            else {
                cur = true;
            }
            
            prev3 = prev2;
            prev2 = prev1;
            prev1 = cur;
            
        }
        
        return prev1;
    }
    
    public static void main(String[] args) {
        SolutionB sol = new SolutionB();
        boolean canWin = sol.canWinNim(1348820612);
        System.out.println(canWin);
    }

}
