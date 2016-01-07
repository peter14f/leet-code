

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    // count the number of distinct subsequences of t in s
    public int numDistinct(String s, String t) {
        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();
        
        List<List<Integer>> indices = new ArrayList<List<Integer>>();
        
        HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        HashSet<Character> tChars = new HashSet<Character>();
        
        for (int i=0; i<tArr.length; i++) {
            tChars.add(tArr[i]);
        }
        
        for (int i=0; i<sArr.length; i++) {
            char c = sArr[i];
            
            if (tChars.contains(c)) {
                if (map.containsKey(c)) {
                    List<Integer> index = map.get(c);
                    index.add(i);
                }
                else {
                    List<Integer> index = new ArrayList<Integer>();
                    index.add(i);
                    map.put(c, index);
                }
            }
        }
        
        for (int i=0; i<tArr.length; i++) {
            char c = tArr[i];
            if (!map.containsKey(c))
                return 0;
            
            indices.add(map.get(c));
        }
        
        System.out.println(indices);
        
        int[] ans = {0};
        countNumDistinctSubsequences(indices, 0, new ArrayList<Integer>(), ans);
        return ans[0];
    }
    
    private void countNumDistinctSubsequences(List<List<Integer>> indices, int i, List<Integer> curList, int[] ans) {
        
        List<Integer> numbers = indices.get(i);
        
        if (numbers.isEmpty())
            return;
        
        for (int j=0; j<numbers.size(); j++) {
            int num = numbers.get(j);
            
            if (curList.isEmpty() || num > curList.get(curList.size() - 1)) {
                curList.add(num);
                
                if (curList.size() == indices.size()) {
                    ans[0]++;
                }
                else {
                    countNumDistinctSubsequences(indices, i+1, curList, ans);
                }
                
                curList.remove(curList.size() - 1);
            }
        }

    }
    
    /* TC LONG
     * "daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac"
     * "ceadbaa"
     * 
     * TC LONG
     * "aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe"
     * "bddabdcae"
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "rabbbit";
        String t = "rabbit";
        
        Solution sol = new Solution();
        int num = sol.numDistinct(s, t);
        System.out.println(num);
    }

}
