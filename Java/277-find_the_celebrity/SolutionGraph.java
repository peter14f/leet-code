import java.util.ArrayList;
import java.util.List;


public class SolutionGraph {

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
        
        int[] indegrees = new int[n];
        int[] outdegrees = new int[n];
        
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                
                if (knows(i, j)) {
                    indegrees[j]++;
                    outdegrees[i]++;
                }
                
                if (knows(j, i)) {
                    indegrees[i]++;
                    outdegrees[j]++;
                }
            }
        }
        
        for (int i=0; i<n; i++) {
            if (outdegrees[i] == 0 && indegrees[i] == n-1)
                return i;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        
    }

}
