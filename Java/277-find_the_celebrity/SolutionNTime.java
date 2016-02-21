
public class SolutionNTime {

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
        if (n <= 1) {
            return -1;
        }
    
        // step 1: find potential candidate
        int l = 0;
        int h = n - 1;
        
        while (l < h) {
            if (knows(l, h))
                l++;
            else
                h--;
        }
        
        // h and l are the same number now
        
        // step 2: verify the candidate is a celebrity
        
        for (int i=0; i<n; i++) {
            if (i==h)
                continue;
            
            if (!knows(i, h) || knows(h, i)) {
                // somebody doesn't know me OR
                // I know somebody
                return -1;
            }
        }
        
        return h;
    }
    
    public static void main(String[] args) {

    }

}
