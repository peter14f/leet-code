import java.util.Arrays;


public class Solution {

    public int minCut(String s) {
        char[] sArr =  s.toCharArray();
        int n = sArr.length;
        
        boolean[][] isPalindrome = new boolean[n][n];
        
        for (int row=0; row<n; row++) {
            isPalindrome[row][row] = true;

            if (row + 1 < n) {
                if (sArr[row] == sArr[row+1]) {
                    isPalindrome[row][row+1] = true;
                }
            }
        }
        
        int dist = 2;
        
        while (dist < n) {
            for (int row=0; row<n; row++) {
                if (row + dist < n) {
                    if (isPalindrome[row+1][row+dist-1] && sArr[row] == sArr[row+dist]) {
                        isPalindrome[row][row+dist] = true;
                    }
                }
            }
            dist++;
        }
        
        int[] minCut = new int[n];
        
        for (int start = n-1; start>=0; start--) {
            minCut[start] = n-1-start; // chop into single characters
                                       // this is the maximum number of cuts needed
            
            if (isPalindrome[start][n-1]) {
                // no need to look for a smaller number of cuts needed
                minCut[start] = 0;
            }
            else {
                for (int cut=start; cut<=n-1; cut++) {
                    if (isPalindrome[start][cut]) {
                        minCut[start] = Math.min(1 + minCut[cut+1], minCut[start]);
                    }
                }
            }
        }
        
        return minCut[0];
    }
    
    public static void main(String[] args) {
        String s = "aba";
        Solution sol = new Solution();
        int cuts = sol.minCut(s);
        System.out.println(cuts);
    }

}
