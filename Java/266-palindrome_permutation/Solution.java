import java.util.HashMap;


public class Solution {

    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (frequency.containsKey(c)) {
                frequency.put(c, frequency.get(c) + 1);
                
                if (frequency.get(c) == 2) {
                    frequency.remove(c);
                }
            }
            else {
                frequency.put(c, 1);
            }
        }
        
        return (frequency.isEmpty() || frequency.size() == 1);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        boolean palindromPermutation = sol.canPermutePalindrome("aabbcc");
        
        System.out.println(palindromPermutation);
    }

}
