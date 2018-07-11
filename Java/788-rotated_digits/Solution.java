
public class Solution {

    public int rotatedDigits(int N) {
        int count = 0;
        for (int i=1; i<=N; i++) {
            int k = rotateEachDigit(i);
            if (k != -1 && k != i) {
                count++;
            }
        }
        return count;
    }

    private int rotateEachDigit(int x) {
        int ans = 0;
        int i=0;

        while (x > 0) {
            int d = x % 10;
            int a = 0;
            if (d==3 || d==4 || d==7) {
                return -1;
            }
            if (d==1 || d==0 || d == 8) {
                a = d;
            } else if (d == 2) {
                a = 5;
            } else if (d == 5) {
                a = 2;
            } else if (d == 6) {
                a = 9;
            } else {
                a = 6;
            }

            for (int j=0; j<i; j++) {
                a = a * 10;
            }
            ans += a;
            x = x / 10;
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = sol.rotatedDigits(15);
        System.out.println(ans);
    }

}
