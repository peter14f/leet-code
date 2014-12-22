import java.util.ArrayList;
import java.util.HashMap;


public class Solution {

    public String longestPalindrome(String s) {
        HashMap<Character, ArrayList<Integer>> charIndex = 
                new HashMap<Character, ArrayList<Integer>>();
        
        String ans = "";
        
        char[] sArr = s.toCharArray();
        
        // store indices for each char in s
        for (int i = 0; i < s.length(); i++) {
            if (charIndex.containsKey(sArr[i])) {
                charIndex.get(sArr[i]).add(i);
            }
            else {
                ArrayList<Integer> indexArr = new ArrayList<Integer>();
                indexArr.add(i);
                charIndex.put(sArr[i], indexArr);
            }
        }
        
        // i is the starting index of the potential palindrom
        for (int i = 0; i < s.length(); i++) {
            char c = sArr[i];
            ArrayList<Integer> indexArr = charIndex.get(c);
            
            /* traversing from the tail of the ArrayList because we want to 
             * look for longer palindrome first
             */
            for (int j = indexArr.size() - 1; j >= 0; j--) {
                int tailIndex = indexArr.get(j);
                int palindromLength = tailIndex - i + 1;
                
                if (palindromLength <= ans.length()) {
                    break;
                }
                
                int head = i;
                int tail = tailIndex;
                boolean isPalindrom = true;
                
                while (tail >= i && head <= tailIndex) {
                    if (sArr[head] != sArr[tail]) {
                        isPalindrom = false;
                        break;
                    }
                    tail--;
                    head++;
                }
                
                if (isPalindrom) {
                    ans = s.substring(i, tailIndex+1);
                    /* once a palindrome is found, there is no point looking
                     * for a shorter palindrome starting at index i
                     */
                    break;
                }
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        String ans = s.longestPalindrome("aaabaaaa");
        System.out.println(ans);
    }
}
