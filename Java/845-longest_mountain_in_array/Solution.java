
public class Solution {

    public int longestMountain(int[] A) {
        int maxLength = 0;
        int n = A.length;

        if (n < 3) {
            return 0;
        }

        for (int i=1; i<n-1; ) {
            if (A[i] > A[i-1] && A[i+1] < A[i]) {
                // i is the peak
                int l = i-1;
                int r = i+1;
                while (r+1 < n && A[r+1] < A[r]) {
                    r++;
                }
                while (l-1 >= 0 && A[l-1] < A[l]) {
                    l--;
                }
                
                int length = r - l + 1;
                i = r + 1;
                maxLength = Math.max(length, maxLength);
            } else {
                i++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] input = {2,1,4,7,3,2,5};
        //int[] input = {2,2,2};
        Solution sol = new Solution();
        int ans = sol.longestMountain(input);
        System.out.println(ans);
    }

}
