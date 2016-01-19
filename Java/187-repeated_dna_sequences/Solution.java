import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        HashMap<String, Integer> cnt = new HashMap<String, Integer>();
        
        // s.length() - x = 10
        // x = s.length() - 10
        for (int i=0; i<=s.length()-10; i++) {
            String str = s.substring(i, i+10);
            
            if (!cnt.containsKey(str))
                cnt.put(str, 1);
            else
                cnt.put(str, cnt.get(str) + 1);
        }
        
        for (String str: cnt.keySet()) {
            if (cnt.get(str) > 1) {
                ans.add(str);
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> ans = sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(ans);
    }

}
