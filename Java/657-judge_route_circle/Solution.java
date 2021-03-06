
public class Solution {

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (int i=0; i<moves.length(); i++) {
            char c = moves.charAt(i);

            if (c == 'U') {
                x--;
            } else if (c=='R') {
                y++;
            } else if (c=='D') {
                x++;
            } else if (c=='L') {
                y--;
            }
        }
        
        return x==0 && y==0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean ans = sol.judgeCircle("LL");
        System.out.println(ans);
    }

}
