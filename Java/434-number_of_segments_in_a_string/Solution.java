
public class Solution {

    public int countSegments(String s) {
        int count = 0;

        boolean started = false;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (started) {
                    started = false;
                }
            } else {
                if (!started) {
                    started = true;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "Hello, my name is John";
        String s2 = "    is John";
        Solution sol = new Solution();
        int ans = sol.countSegments(s2);
        System.out.println(ans);
    }

}
