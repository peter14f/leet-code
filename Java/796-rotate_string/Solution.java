import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        int n = A.length();
        
        if (n==0) return true;

        char[] aArr = A.toCharArray();
        char[] bArr = B.toCharArray();

        Map<Character, Integer> aCnt = new HashMap<>();
        for (int i=0; i<n; i++) {
            aCnt.put(aArr[i], 1 + aCnt.getOrDefault(aArr[i], 0));
        }
        for (int i=0; i<n; i++) {
            aCnt.put(bArr[i], aCnt.getOrDefault(bArr[i], 0) - 1);
            if (aCnt.get(bArr[i]) == 0) {
                aCnt.remove(bArr[i]);
            }
        }
        
        if (!aCnt.isEmpty()) return false;

        int aStart = 0;
        while (aStart < n) {
            if (rotateEquals(aArr, bArr, aStart, n)) {
                return true;
            }
            aStart++;
        }
        
        return false;
    }

    private boolean rotateEquals(char[] aArr, char[] bArr, int aStart, int n) {
        int bStart = 0;

        while (bStart < n) {
            if (aArr[aStart] != bArr[bStart]) {
                return false;
            }
            
            bStart++;
            aStart++;

            if (aStart == n) {
                aStart -= n;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String a = "abcdf";
        String b = "cdeab";
        
        Solution sol = new Solution();
        boolean ans = sol.rotateString(a, b);
        System.out.println(ans);
    }

}
