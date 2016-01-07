
public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] arr3 = s3.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr1 = s1.toCharArray();
        
        if (arr1.length + arr2.length != arr3.length)
            return false;
        
        System.out.println(arr1.length + " " + arr2.length + " " + arr3.length);
        
        if (arr1.length == 0)
            return arrayMatch(arr2, 0, arr3, 0);
        
        if (arr2.length == 0)
            return arrayMatch(arr1, 0, arr3, 0);
        
        return isInterleave(arr1, 0, 
                            arr2, 0,
                            arr3, 0);
    }
    
    private boolean arrayMatch(char[] a, int i, 
                               char[] b, int j) {
        
        while (i < a.length) {
            if (a[i] != b[j])
                return false;
            i++;
            j++;
        }
        
        return true;
    }
    
    private boolean isInterleave(char[] arr1, int i, 
                                 char[] arr2, int j, 
                                 char[] arr3, int k) {
        
        System.out.println("i=" + i + " j=" + j + " k=" + k);
        
        if (i == arr1.length) {
            // becomes a straightforward linear matching
            return arrayMatch(arr2, j, arr3, k);
        }
        
        if (j == arr2.length) {
         // becomes a straightforward linear matching
            return arrayMatch(arr1, i , arr3, k);
        }
        
        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;
        
        if (i < arr1.length) {
            if (arr3[k] == arr1[i]) {
                b1 = isInterleave(arr1, i+1, 
                                  arr2, j,
                                  arr3, k+1);
                if (b1)
                    return true;
                
                if (j < arr2.length) {
                    if (arr3[k] == arr2[j]) {
                        b2 = isInterleave(arr1, i, 
                                arr2, j+1,
                                arr3, k+1);
                        
                        if (b2)
                            return true;
                    }
                }
            }
        }
        
        if (j < arr2.length) {
            if (arr3[k] == arr2[j]) {
                b3 = isInterleave(arr1, i, 
                                  arr2, j+1,
                                  arr3, k+1);
                if (b3)
                    return true;
                
                if (i < arr1.length) {
                    if (arr3[k] == arr1[i]) {
                        b4 = isInterleave(arr1, i+1, 
                                arr2, j,
                                arr3, k+1);
                        
                        if (b4)
                            return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    /*
     * "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc"
     * "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb"
     * "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb"
     * 
     * 
     * TC LONG
     * "cacbbbaaabbacbbbbabbcaccccabaaacacbcaacababbaabbaccacbaabac"
     * "cbcccabbbbaaacbaccbabaabbccbbbabacbaacccbbcaabaabbbcbcbab"
     * "ccbcccacbabbbbbbaaaaabbaaccbabbbbacbcbcbaacccbacabbaccbaaabcacbbcabaabacbbcaacaccbbacaabababaabbbaccbbcacbbacabbaacb"
     * 
     */
    
    public static void main(String[] args) {

        Solution sol = new Solution();
        
        String s1 = "cacbbbaaabbacbbbbabbcaccccabaaacacbcaacababbaabbaccacbaabac"; 
        String s2 = "cbcccabbbbaaacbaccbabaabbccbbbabacbaacccbbcaabaabbbcbcbab";
        String s3 = "ccbcccacbabbbbbbaaaaabbaaccbabbbbacbcbcbaacccbacabbaccbaaabcacbbcabaabacbbcaacaccbbacaabababaabbbaccbbcacbbacabbaacb";
        
        boolean isInterleave = sol.isInterleave(s1, s2, s3);
        System.out.println(isInterleave);
    }

}
