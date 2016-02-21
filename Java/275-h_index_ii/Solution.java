
public class Solution {

    public int hIndex(int[] citations) {
        
        int n = citations.length;
        
        // no papers
        if (n==0)
            return 0;
        
        int l = 0;
        int h = n-1;
        
        int ans = 0;
        
        while (l <= h) {
            
            int m = l + (h-l)/2;
            
            //System.out.println("m=" + m);
            
            // number of citations
            int num = citations[m];
            
            int papers = n - m;
            
            if (papers >= num) {
                ans = Math.max(ans, citations[m]);
                l = m + 1;
            }
            else {
                ans = Math.max(ans, papers);
                h = m - 1;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        
        int[] citations = {3, 5};
        
        Solution sol = new Solution();
        int h = sol.hIndex(citations);
        
        System.out.println(h);
        
    }

}
