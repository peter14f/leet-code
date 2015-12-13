import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        char[] sArr = s.toCharArray();
        int n = sArr.length;
        boolean[][] inDict = new boolean[n][n];
        
        for (int start=0; start<n; start++) {
            for (int end=start; end<n; end++) {
                String str = new String(sArr, start, end-start+1);
                
                if (wordDict.contains(str)) {
                    inDict[start][end] = true;
                }
            }
        }
        
        
        boolean[] canBreak = new boolean[n];
        
        for (int start=n-1; start>=0; start--) {
            
            if (inDict[start][n-1]) {
                canBreak[start] = true;
            }
            else {
                for (int cut=start; cut<n; cut++) {
                    if (inDict[start][cut] && canBreak[cut+1]) {
                        canBreak[start] = true;
                        break;
                    }
                }
            }
        }
        
        List<String> partitions = new ArrayList<String>();
        
        if (canBreak[0])
            dfs(inDict, 0, partitions, new ArrayList<String>(), sArr);
        
        return partitions;
    }
    
    private void dfs(boolean[][] inDict, int start, List<String> partitions, List<String> curList, char[] sArr) {
        int n = inDict.length;
        
        for (int end=start; end<n; end++) {
            
            if (inDict[start][end]) {
                String str = new String(sArr, start, end-start+1);
                curList.add(str);
                
                if (end < n-1) {
                    dfs(inDict, end+1, partitions, curList, sArr);
                }
                else if (end==n-1){
                    StringBuffer sb = new StringBuffer();
                    int i=0;
                    for (; i<curList.size()-1; i++) {
                        sb.append(curList.get(i));
                        sb.append(" ");
                    }
                    sb.append(curList.get(i));
                    
                    partitions.add(sb.toString());
                }
                
                curList.remove(curList.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<String>();
        
        /*
        String s = "catsanddog";
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        */
        
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaab";
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaa");
        dict.add("aaaaa");
        dict.add("aaaaaa");
        dict.add("aaaaaaa");
        dict.add("aaaaaaaa");
        dict.add("aaaaaaaaa");
        
        Solution sol = new Solution();
        List<String> partitions = sol.wordBreak(s, dict);
        System.out.println(partitions);
    }

}
