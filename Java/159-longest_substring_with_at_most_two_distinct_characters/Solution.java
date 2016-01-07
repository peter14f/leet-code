import java.util.HashMap;


public class Solution {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2)
            return s.length();
        
        int max = 0;
        
        HashMap<Character, Integer> cnt = new HashMap<Character, Integer>();
        int first = 0;
        int second = -1;
        cnt.put(s.charAt(0), 1);
        
        for (int i=1; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (cnt.containsKey(c))
                cnt.put(c, cnt.get(c)+1);
            else {
                if (cnt.size() == 1) {
                    cnt.put(c, 1);
                    second = i;
                    continue;
                }
                else {
                    int t = 0;
                    for (char ch: cnt.keySet())
                        t += cnt.get(ch);
                    
                    if (t > max)
                        max = t;
                    
                    cnt.remove(s.charAt(first));
                    cnt.put(s.charAt(second), i-second);
                    cnt.put(c, 1);
                }
            }
            
            if (s.charAt(i) != s.charAt(i-1)) {
                first = second;
                second = i;
            }
        }
        
        int t = 0;
        for (char ch: cnt.keySet())
            t += cnt.get(ch);
        
        if (t > max)
            max = t;
        
        return max;
    }
    
    public static void main(String[] args) {
        //          01234
        String s = "ababc";
        Solution sol = new Solution();
        int l = sol.lengthOfLongestSubstringTwoDistinct(s);
        System.out.println(l);
    }

}
