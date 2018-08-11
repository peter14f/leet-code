
public class Solution {

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();

        int l = 0;
        for (int i=S.length()-1; i>=0; i--) {
            char c = S.charAt(i);
            if (c != '-') {
                if (l > 0 && l % K == 0) {
                    sb.append('-');
                }
                sb.append(Character.toUpperCase(c));
                l++;
            }
        }

        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String S = "2-5g-3-J";
        String ans = sol.licenseKeyFormatting(S, 2);
        System.out.println(ans);
    }

}
