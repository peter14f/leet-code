
public class Solution {

    public int compareVersion(String version1, String version2) {
        int numDots1 = 0;
        int numDots2 = 0;
        
        for (int i=0; i<version1.length(); i++) {
            if (version1.charAt(i) == '.')
                numDots1++;
        }
        
        for (int i=0; i<version2.length(); i++) {
            if (version2.charAt(i) == '.')
                numDots2++;
        }
        
        if (numDots1 > numDots2) {
            int diff = numDots1 - numDots2;
            version2 = expandVersionNumber(version2, diff);
        }
        else if (numDots2 > numDots1) {
            int diff = numDots2 - numDots2;
            version1 = expandVersionNumber(version1, diff);
        }
        
        int i=0; // to traverse version1
        int j=0; // to traverse version2
        
        int numChunks = Math.max(numDots1, numDots2);
        
        for (int chunks=0; chunks<= numChunks; chunks++) {
            int v1 = 0;
            while (i < version1.length()) {
                char c = version1.charAt(i);
                
                i++;
                
                if (c == '.') 
                    break;
                
                v1 = v1 * 10 + (int)(c - '0');
            }
            
            int v2 = 0;
            while (j < version2.length()) {
                char c = version2.charAt(j);
                
                j++;
                
                if (c == '.')
                    break;
                
                v2 = v2 * 10 + (int)(c - '0');
            }
            
            if (v1 > v2)
                return 1;
            else if (v2 > v1)
                return -1;
        }
        
        return 0;
    }
    
    private String expandVersionNumber(String str, int numDots) {
        StringBuffer sb = new StringBuffer(str);
        
        while (numDots > 0) {
            sb.append(".0");
            numDots--;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int ans = sol.compareVersion("3.0.11", "3.0.100");
        System.out.println(ans);
    }

}
