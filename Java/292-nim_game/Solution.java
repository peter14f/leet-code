import java.util.Arrays;


public class Solution {

    public boolean canWinNim(int n) {
        if (n < 1)
            return false;
        else if (n <= 3)
            return true;
        
        boolean[] canWinWithIStones = new boolean[n+1];
        
        canWinWithIStones[1] = true;
        canWinWithIStones[2] = true;
        canWinWithIStones[3] = true;
        
        for (int i=4; i<= n; i++) {
            
            // with (i-1) stones left, (i-2) stones left, (i-3) stones left
            // will play B win? 
            if (canWinWithIStones[i-1] && canWinWithIStones[i-2] && canWinWithIStones[i-3]) {
                // I take 1, or 2, or 3 Player B is going to win
                canWinWithIStones[i] = false;
            }
            else {
                canWinWithIStones[i] = true;
            }
        }
        
        System.out.println(Arrays.toString(canWinWithIStones));
        
        return canWinWithIStones[n];
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean win = sol.canWinNim(12);
        System.out.println(win);
    }

}
