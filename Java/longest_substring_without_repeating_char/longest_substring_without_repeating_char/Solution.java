package longest_substring_without_repeating_char;

public class Solution {

    public int longestStringNoRepeat(String s) {
        
        if (s.length() == 0)
            return 0;
        
        int start = 0;
        char[] s_arr = s.toCharArray();
        int[] lastIndex = new int[128];
        
        for (int i=0; i<lastIndex.length; i++) {
            lastIndex[i] = -1;
        }
        
        lastIndex[s_arr[0]] = 0;
        int maxLength = 1;
        int maxStart = 0;
        
        for (int i=1; i<s_arr.length; i++) {
            if (lastIndex[s_arr[i]] >= start) {
                start = lastIndex[s_arr[i]] + 1;
            }
            else {
                if (i - start + 1 > maxLength) {
                    maxStart = start;
                    maxLength = i - start + 1;
                }
            }
            lastIndex[s_arr[i]] = i;
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        String s = "dvdf";
        
        Solution sol = new Solution();
        
        int ans = sol.longestStringNoRepeat(s);
        System.out.println(ans);
    }

}
