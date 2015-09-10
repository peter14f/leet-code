
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        
        if (strs.length == 0)
            return "";
        else if (strs.length == 1)
            return strs[0];
        
        int minLength = Integer.MAX_VALUE;
        int minIndex = -1;
        int end = -1;
        boolean done = false;
        
        for (int i=0; i<strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
                minIndex = i;
            }
        }
        
        for (int i=0; i<minLength; i++) {
            
            for (int j=0; j<strs.length; j++) {
                if (j == minIndex)
                    continue;
                
                if (strs[j].charAt(i) != strs[minIndex].charAt(i)) {
                    done = true;
                    break;
                }
            }
            
            if (done)
                break;
            
            end = i;
        }
        
        return strs[minIndex].substring(0, end+1);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String[] strs = {"abced", "abcccccc", "abcdef"};
        
        String ans = sol.longestCommonPrefix(strs);
        System.out.println(ans);
    }

}
