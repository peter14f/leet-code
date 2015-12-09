import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> partitions = new ArrayList<List<String>>();
        if (s == null || s.length() == 0)
            return partitions;
        
        char[] sArr = s.toCharArray();
        int n = sArr.length;
        boolean[][] isPalindrome = new boolean[n][n]; 
        
        for (int row=0; row<n; row++) {
            isPalindrome[row][row] = true;
            if (row+1 < n) {
                if (sArr[row] == sArr[row+1]) {
                    isPalindrome[row][row+1] = true;
                }
            }
        }
        
        int dist = 2;
        
        while (dist < n) {
            for (int row=0; row < n; row++) {
                if (row + dist < n) {
                    if (isPalindrome[row+1][row+dist-1] && sArr[row] == sArr[row+dist]) {
                        isPalindrome[row][row+dist] = true;
                    }
                }
            }
            
            dist++;
        }
        
        dfs(sArr, isPalindrome, 0, new ArrayList<String>(), partitions);
        
        return partitions;
    }
    
    private void dfs(char[] sArr, boolean[][] isPalindrome, int start, 
                     List<String> curList, List<List<String>> partitions) {
        
        int n = sArr.length;
        
        for (int col=start; col<n; col++) {
            if (isPalindrome[start][col]) {
                String str = new String(sArr, start, col-start+1);
                curList.add(str);
                
                if (col < n-1) {
                    dfs(sArr, isPalindrome, col+1, curList, partitions);
                }
                else {
                    partitions.add(new ArrayList<String>(curList));
                }
                
                curList.remove(curList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        Solution sol = new Solution();
        List<List<String>> partitions = sol.partition(s);
        System.out.println(partitions);
    }
}
