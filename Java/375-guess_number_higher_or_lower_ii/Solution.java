import java.util.Arrays;

public class Solution {

    public int getMoneyAmount(int n) {

        int[][] minAmount = new int[n+1][n+1];

        for (int size=2; size<=n; size++) {
            for (int start=1; start<=n; start++) {
                int end = start+size-1;
                if (end > n)
                    break;

                int minCost = Integer.MAX_VALUE;
                for (int k=start; k<=end; k++) {
                    int cost = k;
                    
                    int worstCaseRemainingCost = Integer.MIN_VALUE;
                    // start... k-1
                    if (k-1 >= start) {
                        worstCaseRemainingCost = 
                                Math.max(worstCaseRemainingCost, minAmount[start][k-1]);
                    }

                    // k+1... end
                    if (end >= k+1) {
                        worstCaseRemainingCost = 
                                Math.max(worstCaseRemainingCost, minAmount[k+1][end]);
                    }
                    
                    cost += worstCaseRemainingCost;
                    minCost = Math.min(minCost, cost);
                }

                minAmount[start][end] = minCost;
            }
        }

        //System.out.println(Arrays.deepToString(minAmount));
        
        return minAmount[1][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.getMoneyAmount(11);
        System.out.println(ans);
    }

}
