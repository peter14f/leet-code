import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canIWinRecursion(int maxChoosableInteger, int desiredTotal) {
        int n = maxChoosableInteger;
        int total = n*(1+n)/2;

        // desiredTotal not reachable
        if (total < desiredTotal) {
            return false;
        }

        int bitMask = (1<<n) - 1;
        return canIWinHelper(n, bitMask, 0, desiredTotal);
    }
    
    private boolean canIWinHelper(int n, int bitMask, int curSum, int target) {
        if (curSum >= target) {
            return true;
        }

        if (bitMask == 0) {
            return false;
        }

        for (int i=0; i<n; i++) {
            if ((bitMask & (1<<i)) > 0) {
                int num = i + 1;

                int newSum = curSum + num;
                if (newSum >= target) {
                    return true;
                }

                int bitMaskLeft = bitMask ^ (1<<i);
                // what's left -> if the other player cannot win
                if (!canIWinHelper(n, bitMaskLeft, newSum, target)) {
                    return true;
                }
            }
        }

        // non of the number I pick will result in the other player unable to win
        return false;
    }
    
    // player1 and player2 take turns
    // after pick, if the running total >= desiredTotal, then the player wins
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int n = maxChoosableInteger;
        int sum = n*(1+n)/2;

        // neither player will be able to win
        if (sum < desiredTotal) {
            return false;
        }

        int bitMaskLeft = (1 << n) - 1;

        Map<Integer, Boolean> memoization = new HashMap<>();
        return canPlayerWin(memoization, n, bitMaskLeft, 0, desiredTotal);
    }

    // curSum + newNum >= target, then player wins the game
    private boolean canPlayerWin(Map<Integer, Boolean> memoization, 
            int n, 
            int bitMask, int curSum, int target) {

        if (curSum >= target) {
            memoization.put(bitMask, true);
            return true;
        }

        if (bitMask == 0) {
            memoization.put(bitMask, false);
            return false;
        }

        for (int i=0; i<n; i++) {
            if (((1<<i) & bitMask) > 0) {
                int num = i + 1;
                int newBitMask = (1<<i)^bitMask; // what's left after I pick num
                int newSum = curSum + num;

                if (newSum >= target) {
                    return true;
                }

                if (memoization.containsKey(newBitMask) && !memoization.get(newBitMask)) {
                    memoization.put(bitMask, true);
                    return true;
                }

                // if I pick num, will the other player lose?
                if (!canPlayerWin(memoization, n, newBitMask, newSum, target)) {
                    memoization.put(bitMask, true);
                    return true;
                }
            }
        }

        // whatever available number left I pick will not lead to the other player losing...
        memoization.put(bitMask, false);
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean player1Win = sol.canIWin(20, 210);
        System.out.println(player1Win);
    }

}
