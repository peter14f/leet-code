
public class SolutionDP {

    public boolean isScramble(String s1, String s2) {
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        if (arr1.length != arr2.length)
            return false;
        
        int L = arr1.length;
        boolean result[][][] = new boolean[L+1][L][L];
        
        // k=1 strings of length 1
        for (int i=L-1; i >=0; i--) {
            for (int j=L-1; j>=0; j--) {
                if (arr1[i] == arr2[j])
                    result[1][i][j] = true;
            }
        }
        
        // work from strings of length 2 all the way to strings of length L
        for (int k=2; k<=L; k++) {
            
            for (int i=L-k; i>=0; i--) {
                for (int j=L-k; j>=0; j--) {
                    
                    boolean r = false;
                    // k is the length of the whole substring in question
                    // m is the length of the left partitioned string
                    // k-m is the length of the right partitioned string
                    for (int m=1; m<k; m++) {
                        
                        r = (result[m][i][j] && result[k-m][i+m][j+m]) ||
                            (result[m][i][j+k-m] && result[k-m][i+k-m][j]);
                        
                        if (r) {
                            // already found one way to partition the substrings of length k
                            // such that they are scrambles of one another
                            result[k][i][j] = r;
                            break;
                        }
                    }
                    
                }
            }
        }
        
        return result[L][0][0];
    }
    
    public static void main(String[] args) {
        String s1 = "abb";
        String s2 = "bab";
        
        SolutionDP sol = new SolutionDP();
        
        boolean isScramble = sol.isScramble(s1, s2);
        System.out.println(isScramble);
    }

}
