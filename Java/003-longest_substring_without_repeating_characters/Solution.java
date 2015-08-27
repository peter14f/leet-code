import java.util.HashMap;
import java.util.HashSet;


public class Solution {

    // O(n) time complexity using an array
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) {
            return 0;
        }
        
        int[] lastOccured = new int[256];
        char[] sArr = s.toCharArray();
        
        for (int i=0; i<lastOccured.length; i++) {
            lastOccured[i] = -1;
        }
        
        lastOccured[sArr[0]] = 0;
        
        int start = 0;
        int end = 1;
        int max = 1;
        
        while (end < sArr.length) {
            
            if (lastOccured[sArr[end]] >= start) {
                start = lastOccured[sArr[end]] + 1;
            }
            max = Math.max(max, end - start + 1);
            lastOccured[sArr[end]] = end;
            end++;
        }
        
        return max;
    }
    
    // O(n^2) time complexity
    public int lengthOfLongestSubstring1(String s) {
        char[] sArr = s.toCharArray();
        
        int maxSubstringLen = 0;
        
        for (int i=0; i < sArr.length; i++) {
            HashSet<Character> hashtable = new HashSet<Character>();
            hashtable.add(sArr[i]);
            
            if (sArr.length - i < maxSubstringLen) {
                break;
            }
            
            for (int j=i+1; j <= sArr.length; j++) {
                
                if (j==sArr.length || hashtable.contains(sArr[j])) {
                    String substring = s.substring(i, j);
                    if (substring.length() > maxSubstringLen) {
                        maxSubstringLen = substring.length();
                    }
                    break; // must stop extending the substring starting at index i
                }
                else {
                    hashtable.add(sArr[j]);
                }
            }
            
        }
        
        return maxSubstringLen;
    }
    
    // O(n) time complexity using a HashMap
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        
        HashMap<Character, Integer> lastOccured = new HashMap<Character, Integer>();
        char[] sArr = s.toCharArray();
        
        lastOccured.put(sArr[0], 0);
        
        int i=0;
        
        for (int j=1; j<sArr.length; j++) {
            
            if (lastOccured.containsKey(sArr[j]) && lastOccured.get(sArr[j]) >=i) {
                i = lastOccured.get(sArr[j]) + 1;
            }
            
            lastOccured.put(sArr[j], j);
            if (j-i+1 > max) {
                max = j-i+1;
            }
        }
        
        return max;
        
    }
    
    public static void main(String[] args) {
        //String s = "abcabcbb";
        String s = "abcabcbb";
        Solution sol = new Solution();
        
        int ans = sol.lengthOfLongestSubstring2(s);
        System.out.println(ans);

    }

}
