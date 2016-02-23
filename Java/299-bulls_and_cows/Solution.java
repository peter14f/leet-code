public class Solution {

    public String getHint(String secret, String guess) {

        int n = secret.length();
        
        if (n==0)
            return "0A0B";
        
        int bulls = 0;
        
        int[] guesses = new int[10];
        
        int cows = 0;
        
        for (int i=0; i<n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            }
            else {
                guesses[g - '0']++;
            }
        }
        
        for (int i=0; i<n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if (s != g) {
                if (guesses[s - '0'] > 0) {
                    cows++;
                    
                    guesses[s - '0']--;
                }
            }
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
                                  // secret, guess 
        String result = sol.getHint("1122", "2211");
        System.out.println(result);
    }

}
