
public class Solution {

    public int numWays(int n, int k) {
        
        if (n<1)
            return 0;
        
        if (n==1) {
            // one house only
            return k;
        }
        
        int sameColorCnt = k * 1; // 1st house you get k choices, 2nd house you must
                                  // choose the color used in the prev house
        
        int diffColorCnt = k * (k-1); // 1st house you get k choices, 2nd house you
                                      // get (k-1) choices
        
        int totalNumCnt = sameColorCnt + diffColorCnt;
        
        for (int i=3; i<=n; i++) {
            int oldDiffColorCnt = diffColorCnt;
            diffColorCnt = (k-1)*totalNumCnt; // get (k-1) choices
                                              // just don't use the prev color used
            
            sameColorCnt = oldDiffColorCnt;
            
            totalNumCnt = diffColorCnt + sameColorCnt;
        }
        
        return totalNumCnt;
    }
    
    public static void main(String[] args) {
        int n = 3; // 4 posts
        int k = 3; // 3 colors
        
        Solution sol = new Solution();
        int numWays = sol.numWays(n, k);
        
        System.out.println(numWays);
    }

}
