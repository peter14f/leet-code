import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class Solution {

    /*  '1' = land
     *  '0' = water
     *  
     *  
     *    A
     *   BX
     *  
     */
    public int numIslands(char[][] grid) {
        
        int nextNum = 1;
        int m = grid.length;
        
        if (m==0)
            return 0;
        
        int n = grid[0].length;
        
        int[][] island = new int[m][n];
        ArrayList<Integer> labelTable = new ArrayList<Integer>();
        labelTable.add(0);
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                if (grid[row][col] == '1') {
                    int upIsland = -1;
                    int leftIsland = -1;
                    
                    if (row - 1 >= 0 && island[row-1][col] > 0)
                        upIsland = labelTable.get(island[row-1][col]);
                    
                    if (col - 1 >=0 && island[row][col-1] > 0)
                        leftIsland = labelTable.get(island[row][col-1]);
                    
                    if (leftIsland == -1 && upIsland == -1) {
                        island[row][col] = nextNum;
                        labelTable.add(nextNum);
                        nextNum++;
                    }
                    else if (leftIsland == -1) 
                        island[row][col] = upIsland;
                    else if (upIsland == -1)
                        island[row][col] = leftIsland;
                    else {
                        if (upIsland != leftIsland) {
                            int minBlob = Math.min(upIsland, leftIsland);
                            island[row][col] = minBlob;
                            if (labelTable.get(upIsland) > minBlob)
                                labelTable.set(upIsland, minBlob);
                            if (labelTable.get(leftIsland) > minBlob)
                                labelTable.set(leftIsland, minBlob);
                        }
                        else {
                            island[row][col] = upIsland;
                        }
                    }
                }
            }
        }
        
        for (int i=nextNum-1; i > 0; i--) {
            int t = i;
            while (labelTable.get(t) != t) {
                t = labelTable.get(t);
            }
            labelTable.set(i, t);
        }
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                if (island[row][col] > 0) {
                    island[row][col] = labelTable.get(island[row][col]);
                }
            }
        }
        
        HashSet<Integer> cnt = new HashSet<Integer>();
        
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                if (island[row][col] > 0) {
                    if (!cnt.contains(island[row][col]))
                        cnt.add(island[row][col]);
                }
            }
        }
        
        return cnt.size();
    }
    
    public static void main(String[] args) {
        char[][] grid = 
            {
                {'1', '1', '1', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '0', '1'},
                {'1', '0', '0', '0', '1', '0', '1'},
                {'1', '0', '1', '0', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '0', '1'},
                {'1', '1', '1', '1', '1', '1', '1'}
            };
        /*
         * "10110010111101011110",
         * "01001010111111011011",
         * "10010101011011100110",
         * "01100110111100100011",
         * "11010010001010111011",
         * "00001011001001011110",
         * "10111101101101110010",
         * "01100010010111001101",
         * "00001101001101001010",
         * "00111010101110111110",
         * "10101110111010101011",
         * "00111101110100011101",
         * "11100000110111011110",
         * "00111001001111110110",
         * "00011000011010011111",
         * "01110100111110111001",
         * "00001111000010000110",
         * "11111111110110111111",
         * "01001001111110101111",
         * "00111110001111110110" 
         *                                                                      17
         * [ 1,  0,  2,  2,  0,  0,  3,  0,  4,  4,  4,  4,  0,  4,  0,  4,  4,  4,  4,  0], 
         * [ 0,  7,  0,  0,  8,  0,  3,  0,  4,  4,  4,  4,  4,  4,  0,  4,  4,  0,  4,  4], 
         * [ 9,  0,  0, 10,  0, 11,  0, 12,  0,  4,  4,  0,  4,  4,  4,  0,  0,  4,  4,  0], 
         * [ 0, 14, 14,  0,  0, 11, 11,  0,  4,  4,  4,  4,  0,  0,  4,  0,  0,  0,  4,  4], 
         * [14, 14,  0, 17,  0,  0, 11,  0,  0,  0,  4,  0, 18,  0,  4,  4,  4,  0,  4,  4], 
         * [ 0,  0,  0,  0, 19,  0, 11, 11,  0,  0,  4,  0,  0,  4,  0,  4,  4,  4,  4,  0], 
         * [21,  0, 19, 19, 19, 19,  0, 11, 11,  0,  4,  4,  0,  4,  4,  4,  0,  0,  4,  0], 
         * [ 0, 19, 19,  0,  0,  0, 24,  0,  0, 25,  0,  4,  4,  4,  0,  0, 26, 26,  0, 27], 
         * [ 0,  0,  0,  0, 28, 28,  0, 29,  0,  0,  4,  4,  0,  4,  0,  0, 26,  0, 26,  0], 
         * [ 0,  0, 28, 28, 28,  0, 28,  0,  4,  0,  4,  4,  4,  0, 26, 26, 26, 26, 26,  0], 
         * [36,  0, 28,  0, 28, 28, 28,  0,  4,  4,  4,  0,  4,  0, 26,  0, 26,  0, 26, 26], 
         * [ 0,  0, 28, 28, 28, 28,  0,  4,  4,  4,  0, 26,  0,  0,  0, 26, 26, 26,  0, 26], 
         * [28, 28, 28,  0,  0,  0,  0,  0,  4,  4,  0, 26, 26, 26,  0, 26, 26, 26, 26,  0], 
         * [ 0,  0, 28, 28, 28,  0,  0, 41,  0,  0, 26, 26, 26, 26, 26, 26,  0, 26, 26,  0], 
         * [ 0,  0,  0, 28, 28,  0,  0,  0,  0, 26, 26,  0, 26,  0,  0, 26, 26, 26, 26, 26], 
         * [ 0, 28, 28, 28,  0, 26,  0,  0, 26, 26, 26, 26, 26,  0, 26, 26, 26,  0,  0, 26], 
         * [ 0,  0,  0,  0, 26, 26, 26, 26,  0,  0,  0,  0, 26,  0,  0,  0,  0, 49, 49,  0], 
         * [26, 26, 26, 26, 26, 26, 26, 26, 26, 26,  0, 26, 26,  0, 26, 26, 49, 49, 49, 49], 17
         * [ 0, 26,  0,  0, 26,  0,  0, 26, 26, 26, 26, 26, 26,  0, 26,  0, 49, 49, 49, 49], 
         * [ 0,  0, 26, 26, 26, 26, 26,  0,  0,  0, 26, 26, 26, 26, 26, 26,  0, 49, 49,  0]
         */
        String[] a = {"10110010111101011110","01001010111111011011","10010101011011100110","01100110111100100011","11010010001010111011","00001011001001011110","10111101101101110010","01100010010111001101","00001101001101001010","00111010101110111110","10101110111010101011","00111101110100011101","11100000110111011110","00111001001111110110","00011000011010011111","01110100111110111001","00001111000010000110","11111111110110111111","01001001111110101111","00111110001111110110"};
        grid = new char[a.length][];
        for (int i=0; i<a.length; i++) {
            grid[i] = a[i].toCharArray();
        }
        Solution sol = new Solution();
        int num = sol.numIslands(grid);
        System.out.println(num);
    }

}
