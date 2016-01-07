package distinct_sbusequences;

import java.util.Arrays;

public class SolutionDP {

    
    /*               T
     *               j
     *          r a b b i t
     *        0 1 2 3 4 5 6
     * S   0  1 0 0 0 0 0 0
     *   r 1  1 1 0 0 0 0 0
     *   a 2  1 1 1 0 0 0 0
     *   b 3  1 1 1 1 0 0 0
     * i b 4  1 1 1 2 1 0 0
     *   b 5  1 1 1 3 3 0 0
     *   i 6  1 1 1 3 3 3 0
     *   t 7  1 1 1 3 3 3 3
     */
    
    
    public int numDistinct(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        int[][] num = new int[sArr.length + 1][tArr.length + 1];
        
        /* first column, if you just delete all characters in s, you get
         * an empty string
         */
        for (int row=0; row<=sArr.length; row++) {
            num[row][0] = 1;
        }
        
        /* first row, no way to get to a non-empty string from
         * an empty string
         */
        for (int col=1; col<=tArr.length; col++) {
            num[0][col] = 0;
        }
        
        for (int row=1; row<=sArr.length; row++) {
            for (int col=1; col<=tArr.length; col++) {
                if (sArr[row-1] == tArr[col-1]) {
                    num[row][col] = num[row-1][col] +  // delete 'row'th charater in s
                                    num[row-1][col-1]; // do not delete 'row'th character in s
                }
                else {
                    num[row][col] = num[row-1][col];
                }
            }
        }
        
        return num[sArr.length][tArr.length];
    }
    
    public static void main(String[] args) {
        String s = "daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac";
        String t = "ceadbaa";
        
        SolutionDP sol = new SolutionDP();
        int num = sol.numDistinct(s, t);
        System.out.println(num);
    }

}
