import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int findMaximumXOR(int[] nums) {
        int maxXor = 0;

        int maskUpToNow = 0;
        for (int i=31; i>=0; i--) {
            int mask = 1<<i;
            int curGuessedMax = maxXor | mask;

            Set<Integer> set = new HashSet<>();
            maskUpToNow = maskUpToNow | mask; // include one more bit in mask
            for (int num : nums) {
                int numMasked = maskUpToNow & num;
                if (!set.contains(numMasked)) {
                    set.add(numMasked);
                }
            }

            boolean guessedWrong = true;
            for (int numMasked : set) {
                if (set.contains(numMasked ^ curGuessedMax)) {
                    if (guessedWrong)
                        guessedWrong = false;
                }
            }
            if (!guessedWrong) {
                maxXor = curGuessedMax;
            }
        }

        return maxXor;
    }

    public static void main(String[] args) {
        int[] nums = {14, 11, 7, 2};
        Solution sol = new Solution();
        int maxXOR = sol.findMaximumXOR(nums);
        System.out.println(maxXOR);
    }

}
