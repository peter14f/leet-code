import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        
        /* we sort the input array right away because OJ requires that the
         * inner lists be in lexicographical order
         */
        Arrays.sort(strs);
        
        HashMap<String, List<String>> anagrams = new HashMap<String, List<String>>();
        List<List<String>> ans = new ArrayList<List<String>>();
        
        for (int i=0; i<strs.length; i++) {
            char[] s_arr = strs[i].toCharArray();
            Arrays.sort(s_arr);
            String key = new String(s_arr);
            
            if (anagrams.containsKey(key)) {
                anagrams.get(key).add(strs[i]);
            }
            else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                anagrams.put(key, list);
            }
        }
        
        for (List<String> list : anagrams.values()) {
            ans.add(list);
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = sol.groupAnagrams(strs);
        System.out.println(ans);
    }

}
