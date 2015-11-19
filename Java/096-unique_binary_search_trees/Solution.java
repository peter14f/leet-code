
public class Solution {

    public int numTrees(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be a non-negative integer");
        else if (n==0)
            return 1;
        
        int[] numTreesWithNodes = new int[n+1];
        numTreesWithNodes[0] = 1;
        numTreesWithNodes[1] = 1;
        
        for (int i=2; i<=n; i++) {
            int cnt = 0;
            
            for (int root=1; root<=i; root++) {
                
                // number of nodes smaller than root
                int numSmaller = root - 1;
                int numLeftSubBSTs = numTreesWithNodes[numSmaller];
                
                // number of nodes bigger than root
                int numBigger = i - root;
                int numRightSubBSTs = numTreesWithNodes[numBigger];
                cnt += numRightSubBSTs * numLeftSubBSTs;
            }
            
            numTreesWithNodes[i] = cnt;
        }
        
        return numTreesWithNodes[n];
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num = sol.numTrees(4);
        System.out.println(num);
    }

}
