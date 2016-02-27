
public class Solution {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitMaps = new int[n];
        
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<words[i].length(); j++) {
                char c = words[i].charAt(j);
                
                bitMaps[i] |= (1<<(c-'a'));
            }
        }
        
        int max = 0;
        
        for (int i=0; i<words.length; i++) {
            for (int j=i+1; j<words.length; j++) {
                if ((bitMaps[i] & bitMaps[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    
                    if (product > max) {
                        max = product;
                    }
                    
                }
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        String[] words = {
                "a", "ab", "abc", "d", "cd", "bcd", "abcd"
        };
        
        Solution sol = new Solution();
        int maxProduct = sol.maxProduct(words);
        System.out.println(maxProduct);
    }

}
