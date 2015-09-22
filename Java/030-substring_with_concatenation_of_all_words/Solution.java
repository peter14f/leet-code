import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Solution {

    /**
     * TC 96 "barfoofoobarthefoobarman" ["bar","foo","the"]
     * TC 36 "barfoothefoobarman" ["foo","bar"]
     * TC 137 "wordgoodgoodgoodbestword" ["word","good","best","good"]
     * TC 145 "aaaaaa", ["aaa", "aaa"]
     * TC 137 "barfoofoobarthefoobarman" ["bar","foo","the"]
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        
        int length = words[0].length();
        
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            }
            else {
                wordCount.put(word, 1);
            }
        }
        
        for (int i=0; i<s.length(); i++) {
            if (i + words.length * length - 1 >= s.length()) {
                break;
            }
            
            String s2 = s.substring(i, i + words.length * length);
            HashMap<String, Integer> cur = new HashMap<String, Integer>();
            cur.putAll(wordCount);
            
            for (int j=0; j<s2.length(); j=j+length) {
                String substring = s2.substring(j, j+length);
                if (wordCount.containsKey(substring) && cur.containsKey(substring)) {
                    int cnt = cur.get(substring);
                    if (cnt==1)
                        cur.remove(substring);
                    else
                        cur.put(substring, cnt - 1);
                }
                else {
                    break;
                }
            }
            if (cur.isEmpty())
                ans.add(i);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        String[] words = {"bar","foo", "the"};
        
        Solution sol = new Solution();
        
        List<Integer> ans = sol.findSubstring("barfoofoobarthefoobarman", words);
        
        System.out.println(ans);
    }

}
