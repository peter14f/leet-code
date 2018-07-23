import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    // may assume the given input string is always valid
    public String nextClosestTime(String time) {
        int[] input = new int[4];

        input[0] = time.charAt(0) - '0';
        input[1] = time.charAt(1) - '0';
        input[2] = time.charAt(3) - '0';
        input[3] = time.charAt(4) - '0';

        int min = Math.min(input[0], Math.min(input[1], Math.min(input[2], input[3])));
        
        int[] output = new int[4];
        for (int i=3; i>=0; i--) {
            output[0] = input[0];
            output[1] = input[1];
            output[2] = input[2];
            output[3] = input[3];

            // at location i, what's the smallest number that I can put that's bigger
            int smallestBiggerNum = 10;
            for (int z=0; z<input.length; z++) {
                if (z != i && input[z] > input[i] && input[z] < smallestBiggerNum) {
                    smallestBiggerNum = input[z];
                }
            }

            if (smallestBiggerNum > input[i] && smallestBiggerNum < 10) {
                output[i] = smallestBiggerNum;
                // at all locations j > i, now use the min number
                for (int j=i+1; j<4; j++) {
                    output[j] = min;
                }
                if (isValidTime(output)) {
                    return "" + output[0] + "" + output[1] + ":" + output[2] + "" + output[3];
                }
            }
        }

        return "" + min + "" + min + ":" + min + "" + min;
    }

    private boolean isValidTime(int[] input) {
        if (input.length != 4) {
            return false;
        }

        if (input[0] < 0 || input[0] > 2) {
            return false;
        }

        if (input[0] == 0 || input[0] == 1) {
            if (input[1] < 0 || input[1] > 9) {
                return false;
            }
        } else {
            // 2
            if (input[1] < 0 || input[1] > 3) {
                return false;
            }
        }

        if (input[2] < 0 || input[2] > 5) {
            return false;
        }

        if (input[3] < 0 || input[3] > 9) {
            return false;
        }

        return true;
    }

    // 13:55 -> 15:11
    // 19:34 -> 19:39
    // 23:59 -> 23:92 x -> 25:22 x -> 32:22 x -> 22:22
    public static void main(String[] args) {
        Solution sol = new Solution();
        String ans = sol.nextClosestTime("19:34");
        System.out.println(ans);
    }

}
