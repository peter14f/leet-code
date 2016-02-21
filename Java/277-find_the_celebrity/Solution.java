import java.util.ArrayList;
import java.util.List;


public class Solution {

    /* The knows API is
     * 
     * boolean knows(int a, int b)
     * 
     * the celebrity knows no body, but is known by n-1 people
     * 
     */
    
    private boolean knows(int a, int b) {
        return false;
    }
    
    public int findCelebrity(int n) {       
        
        // 0 = haven't asked
        // 1 = knows
        // 2 = don't know
        int[][] rowKnowsCol = new int[n][n];
        
        for (int i=0; i<n; i++) {
            // do people know i?
            
            int num = 0;
            
            for (int j=0; j<n; j++) {
                if (j==i)
                    continue;
                
                if (rowKnowsCol[j][i] == 0)
                    rowKnowsCol[j][i] = knows(j, i) ? 1: 2;
                    
                if (rowKnowsCol[j][i] == 1)
                    num++;
                else 
                    break;
                
            }
            
            if (num == n-1) {
                // i is potentially a celebrity - known by everyone else
                
                // number of people i knows
                int numPpl = 0;
                
                for (int j=0; j<n; j++) {
                    if (j==i)
                        continue;
                    
                    if (rowKnowsCol[i][j] == 0)
                        rowKnowsCol[i][j] = (knows(i, j)) ? 1 : 2;
                    
                    if (rowKnowsCol[i][j] == 1){
                        numPpl++;
                        break;
                    }
                }
                
                if (numPpl == 0)
                    return i;
            }
        }
        
        // return -1 if no celebrity found
        return -1;
    }
    
    public static void main(String[] args) {
        
    }

}
