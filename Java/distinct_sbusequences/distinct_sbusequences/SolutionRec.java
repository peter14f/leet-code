package distinct_sbusequences;

public class SolutionRec {

    public int numDistinct(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        int[] num = {0};
        
        numDistinct(sArr, 0, tArr, 0, num);
        
        return num[0];
    }
    
    private void numDistinct(char[] sArr, int i, char[] tArr, int j, int[] num) {
        
        if (i==sArr.length || j==tArr.length)
            return;
        
        if (sArr[i] == tArr[j]) {
            if (j == tArr.length - 1) {
                num[0]++;
            }

            numDistinct(sArr, i+1, tArr, j+1, num);
            numDistinct(sArr, i+1, tArr, j, num);
            
        }
        else {
            numDistinct(sArr, i+1, tArr, j, num);
        }
    }
    
    public static void main(String[] args) {
        String s = "daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac";
        String t = "ceadbaa";
        
        SolutionRec sol = new SolutionRec();
        int ans = sol.numDistinct(s, t);
        
        System.out.println(ans);
    }

}
