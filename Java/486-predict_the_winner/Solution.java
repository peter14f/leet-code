import java.util.Arrays;

public class Solution {

    public boolean predictTheWinnerDp(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        // oneScore[i][j] is the maxScore that player1 can obtain in the 
        //  case where player2 does its very best when the input array is
        //  numbers from index i...j
        int[][] oneScore = new int[n][n];

        for (int size=1; size<=n; size++) {
            for (int start=0; start<n; start++) {
                int end=start+size-1;
                if (end >= n) {
                    break;
                }

                if (size==1) {
                    oneScore[start][end] = nums[start];
                    continue;
                }

                // size > 1
                //
                // player1 has two choices: pick start or end
                // 
                // player1 picks start -> leaves start+1... end
                // 
                // - player2 picks start+1 -> leaves start+2... end
                // - player2 picks end     -> leaves start+1... end-1
                int score1 = nums[start];
                int remainingScore1 = Integer.MAX_VALUE;
                if (end >= start+2) {
                    remainingScore1 = Math.min(remainingScore1, oneScore[start+2][end]);
                }
                if (end-1 >= start+1) {
                    remainingScore1 = Math.min(remainingScore1, oneScore[start+1][end-1]);
                }
                if (remainingScore1 != Integer.MAX_VALUE) {
                    score1 += remainingScore1;
                }

                // player1 picks nums[end] -> leaves start...end-1
                // - player2 picks start -> leaves start+1...end-1
                // - player2 picks end-1 -> leaves start...end-2
                int score2 = nums[end];
                int remainingScore2 = Integer.MAX_VALUE;
                if (end-1 >= start+1) {
                    remainingScore2 = Math.min(remainingScore2, oneScore[start+1][end-1]);
                }
                if (end-2 >= start) {
                    remainingScore2 = Math.min(remainingScore2, oneScore[start][end-2]);
                }
                if (remainingScore2 != Integer.MAX_VALUE) {
                    score2 += remainingScore2;
                }

                oneScore[start][end] = Math.max(score1, score2);
            }
        }

        int player1Score = oneScore[0][n-1];
        int player2Score = total - player1Score;

        return player1Score >= player2Score;
    }

    public boolean PredictTheWinner(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int playerOneScore = getScore(nums, 0, nums.length - 1);
        int playerTwoScore = total - playerOneScore;

        return playerOneScore > playerTwoScore;
    }

    private int getScore(int[] nums, int start, int end) {
        if (start == end) {
            // one element left
            return nums[start];
        }
        if (end < start) {
            return 0;
        }

        // player1 picks start
        int score1 = nums[start];
        // remaining nums -> start+1... end
        // player2 either picks start+1 -> which leaves start+2... end
        //             or picks end -> which leaves start+1... end-1
        int remainingScore1 = Math.min(
                getScore(nums, start+2, end),    // player2 picks start+1
                getScore(nums, start+1, end-1)); // player2 picks end
        score1 += remainingScore1;

        // player1 picks end
        // remaining nums -> start... end-1
        // player2 either picks start -> which leaves start+1... end-1
        //             or picks end-1 -> which leaves start... end-2
        int score2 = nums[end];
        int remainingScore2 = Math.min(
                getScore(nums, start+1, end-1), 
                getScore(nums, start, end-2));
        score2 += remainingScore2;

        return Math.max(score1, score2);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 5, 233, 7};
        
        boolean oneCanWin = sol.predictTheWinnerDp(nums);
        System.out.println(oneCanWin);
    }

}
