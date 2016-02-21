
public class Solution {

    /* boolean isBadVersion(int version);
     * 
     */
    
    private boolean isBadVersion(int version) {
        return false;
    }
    
    public int firstBadVersion(int n) {
        int l = 1;
        int h = n;
        
        int minFound = n;
        
        while (l <= h) {
            int m = l + (h-l)/2;
            
            boolean bad = isBadVersion(m);
            
            if (bad) {
                minFound = Math.min(minFound, m);
                // could have a lower bad version
                h = m - 1;
            }
            else {
                // could have a higher bad version
                l = m + 1;
            }
        }
        
        return minFound;
    }
    
    public static void main(String[] args) {
        
    }

}
