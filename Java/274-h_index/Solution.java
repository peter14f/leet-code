
public class Solution {

    public int hIndex(int[] citations) {
        int n = citations.length;
        
        int h = n;
        
        while (h > 0) {
            
            if (satisfyH(h, citations)) {
                return h;
            }
            
            h--;
        }
        
        return h;
    }
    
    private boolean satisfyH(int h, int[] citations) {
        int numEnough = 0; // # papers having >= h citations
        
        for (int i=0; i<citations.length; i++) {
            if (citations[i] >= h)
                numEnough++;
        }
        
        return numEnough >= h;
    }
    
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        Solution sol = new Solution();
        int h = sol.hIndex(citations);
        System.out.println("h=" + h);
    }

}
