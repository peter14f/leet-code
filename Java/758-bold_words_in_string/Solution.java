
public class Solution {

    public String boldWords(String[] words, String S) {

        int n = S.length();
        boolean[] isBold = new boolean[n];
        char[] ch = S.toCharArray();

        for (String word : words) {
            int l = word.length();
            char[] w = word.toCharArray();

            for (int i=0; i+l-1 < n; i++) {
                if (matchWordFromCh(w, ch, i, l)) {
                    for (int j=i; j<i+l; j++) {
                        isBold[j] = true;
                    }
                }
            }
        }

        boolean started = false;
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            if (isBold[i] && !started) {
                sb.append("<b>");
                started = true;
            } else if (!isBold[i] && started) {
                sb.append("</b>");
                started = false;
            }
            sb.append(ch[i]);
        }
        
        if (started) {
            sb.append("</b>");
            started = false;
        }
        return sb.toString();
    }
    
    private boolean matchWordFromCh(char[] w, char[] ch, int start, int l) {
        int j=0;
        for (int i=start; i<start+l; i++) {
            if (w[j] != ch[i]) {
                return false;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aabcd";
        String[] words = {
                "ab","bc"
        };
        String ans = sol.boldWords(words, s);
        System.out.println(ans);
    }

}
