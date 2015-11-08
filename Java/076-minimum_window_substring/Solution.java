import java.util.HashMap;

public class Solution {
    
    public String minWindow(String s, String t) {
        
        char[] arrT = t.toCharArray();
        char[] arrS = s.toCharArray();
        
        HashMap<Character, Integer> cnt = new HashMap<Character, Integer>();
        
        // how many times each character in t appears in t
        for (int i=0; i<arrT.length; i++) {
            if (cnt.containsKey(arrT[i])) {
                cnt.put(arrT[i], cnt.get(arrT[i])+1);
            }
            else {
                cnt.put(arrT[i], 1);
            }
        }
        
        // check if we've seen all characters in t
        HashMap<Character, Integer> curCnt = new HashMap<Character, Integer>();
        
        int end = 0;
        int numCharSeen = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = -1;
        
        while (end < arrS.length) {
            
            char c = arrS[end];
            
            if (cnt.containsKey(c)) {
                
                if (curCnt.containsKey(c)) {
                    if (curCnt.get(c) < cnt.get(c))
                        numCharSeen++;
                    
                    curCnt.put(c, curCnt.get(c) + 1);
                }
                else {
                    curCnt.put(c, 1);
                    numCharSeen++;
                }
            }
            
            if (numCharSeen == arrT.length) {
                char startC = arrS[start];
                while (!cnt.containsKey(startC) || curCnt.get(startC) > cnt.get(startC)) {
                    
                    if (cnt.containsKey(startC)) {
                        // moving start forward means the window has one fewer character
                        curCnt.put(startC, curCnt.get(startC) - 1);
                    }
                    
                    start++;
                    startC = arrS[start];
                }
                
                int length = end-start+1;
                if (length < minLength) {
                    minLength = length;
                    minStart = start;
                }
            }
            
            end++;
        }
        
        if (minStart == -1)
            return "";
        else
            return new String(arrS, minStart, minLength);
    }
    
    public static void main(String[] args) {
        //          0123456789012
        String s = "ADOBECODEBANC";
        //          *  * *   ** *
        String t = "ABC";
        
        Solution sol = new Solution();
        String ans = sol.minWindow(s, t);
        
        System.out.println(ans);
    }

}
