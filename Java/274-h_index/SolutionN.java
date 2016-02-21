import java.util.Arrays;


public class SolutionN {

    // note that it's impossible for a paper to have 
    // a negative number of citations
    public int hIndex(int[] citations) {
        int n = citations.length;
        
        if (n == 0) {
            // no papers
            return 0;
        }
        
        int[] cnt = new int[n+1];
        
        for (int i=0; i<n; i++) {
             
            if (citations[i] >= n) {
                // this paper has n+ citations -> use the last bucket to cnt
                cnt[n]++;
            }
            else {
                // this paper has x citations -> it's got its own bucket
                int x = citations[i];
                cnt[x]++;
            }
        }
        
        int numPapers = 0;
        for (int i=n; i>=0; i--) {
            numPapers += cnt[i];
            
            if (numPapers >= i) {
                return i;
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        SolutionN sol = new SolutionN();
        int[] citations = {3, 0, 6, 1, 5};
        
        int h = sol.hIndex(citations);
        System.out.println(h);
    }

}
