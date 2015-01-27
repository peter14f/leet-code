import java.util.LinkedList;
import java.util.List;


public class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        char[] s_arr = s.toCharArray();
        boolean[][] tab = new boolean[n][n];
        
        // single character string is always a palindrome
        for (int row=0; row<n; row++) {
            tab[row][row] = true;
        }
        
        // two character string
        for (int row=0; row<n; row++) {
            int col = row+1;
            if (col < n) {
                if (s_arr[row] == s_arr[col]) {
                    tab[row][col] = true;
                }
            }
        }
        
        /* now s[i..j] is a palindrome if
        ** s[i] == s[j] and s[i+1..j-1] is a palindrome
        */
        // consider strings of lengths 2..n
        for (int l=3; l<=n; l++) {
            for (int row=0; row<n; row++) {
                int col = row + l - 1;
                
                if (col < n && 
                    s_arr[row] == s_arr[col] &&
                    tab[row+1][col-1]) {
                    tab[row][col] = true;
                }
                
            }
        }
        
        LinkedList<List<String>> ans = new LinkedList<List<String>>();
        LinkedList<String> list = new LinkedList<String>();
        
        attemptToBuildSolution(list, tab, s_arr, n-1, ans, n);
        
        return ans;
    }
    
    private void attemptToBuildSolution(
            LinkedList<String> list,
            boolean[][] tab, char[] s_arr, 
            int col, LinkedList<List<String>> ans,
            int n) {
        
        int originalSize = list.size();
        
        // go through each row in col
        for (int row=0; row<=col; row++) {
            if (tab[row][col]) {
                list.addFirst(String.copyValueOf(s_arr, row, col-row+1));
                
                if (row==0) {
                    ans.add(new LinkedList<String>(list));
                    list.removeFirst();
                }
                else {
                    attemptToBuildSolution(list, tab, s_arr, row-1, ans, n);
                    if (list.size() > originalSize)
                        list.removeFirst();
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> ans = s.partition("efe");
        System.out.println(ans);
    }
}
