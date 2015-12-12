import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Solution {

    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        
        boolean[][] dict = new boolean[n][n];
        char[] sArr = s.toCharArray();
        
        for (int start=0; start<n; start++) {
            for (int end=start; end<n; end++) {
                String str = new String(sArr, start, end-start+1);
                
                if (wordDict.contains(str)) {
                    dict[start][end] = true;
                }
            }
        }
        
        // canBreak[i] is true is s(i,n-1) is breakable
        boolean[] canBreak = new boolean[n];
        
        for (int start=n-1; start >=0; start--) {
            if (dict[start][n-1]) {
                canBreak[start] = true;
            }
            else {
                for (int cut=start; cut<n-1; cut++) {
                    if (dict[start][cut] && canBreak[cut+1]) {
                        canBreak[start] = true;
                        // already figured out that s(start, n-1) is breakable
                        // move to the next start index
                        break;
                    }
                }
            }
        }
        
        return canBreak[0];
    }
    
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");
        String s = "leetcode";
        
        Solution sol = new Solution();
        boolean canBreak = sol.wordBreak(s, dict);
        System.out.println(canBreak);
    }

}
