
public class Solution {

    public int numDecodings(String s) {
        char[] sArr = s.toCharArray();
        int[] ans = {0};
        
        if (sArr.length == 0)
            return ans[0];
        
        numDecodings(sArr, 0, ans);
        
        return ans[0];
    }
    
    private void numDecodings(char[] sArr, int index, int[] ans) {
        
        
        int number = sArr[index] - '0';
        if (number >= 1 && number <=26) {
            if (index == sArr.length - 1) {
                ans[0]++;
            }
            else {
                numDecodings(sArr, index+1, ans);
            }
        }
        else {
            return;
        }
        
        if (index + 1 < sArr.length) {
            number = 10*(sArr[index] - '0') + (sArr[index+1] - '0');
            
            if (number >=1 && number <= 26) {
                if (index + 1 == sArr.length - 1) {
                    ans[0]++;
                }
                else {
                    numDecodings(sArr, index+2, ans);
                }
            }
            else {
                return;
            }
        }
    }
    
    /* TC LONG: "6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155"
     * 
     * "2256189527388216593418335868559242458839728466495756982511325823929498298876598988548338883519346822"
     * "7541387519572282368613553811323167125532172369624572591562685959575371877973171856836975137559677665"
     */
    public static void main(String[] args) {
        /* 122
         *
         * 1, 2, 2
         * 12, 2
         * 1, 22
         *
         */
        
        Solution sol = new Solution();
        int ans = sol.numDecodings("7541387519572282368613553811323167125532172369624572591562685959575371877973171856836975137559677665");
        System.out.println(ans);
    }

}
