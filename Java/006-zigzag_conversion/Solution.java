import java.util.Arrays;


public class Solution {
    
    public String convert2(String s, int numRows) {
        if (numRows==1)
            return s;
        
        StringBuffer sb = new StringBuffer();
        
        int n = s.length();
        
        for (int row=0; row < numRows; row++) {
            
            if (row >= n)
                break;
            
            // self
            sb.append(s.charAt(row));
            
            if (row==0 || row==numRows-1) {
                int downSteps = numRows - 1;
                int upSteps = numRows - 1;
                int index = row;
                index += downSteps + upSteps;
                while (index < n) {
                    sb.append(s.charAt(index));
                    index += downSteps + upSteps;
                }
            }
            else {
                // down -> up, up -> down
                int part1Steps = 2*(numRows - 1 - row);
                int part2Steps = 2*row;
                
                int index = row;
                
                
                index += part1Steps;
                boolean one = false;
                
                while (index < n) {
                    sb.append(s.charAt(index));
                    
                    if (one) {
                        index += part1Steps;
                        one = false;
                    }
                    else {
                        index += part2Steps;
                        one = true;
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        
        int numColsMiddle = numRows - 2;
        
        int n = s.length();
        
        int numCols = 0;
        
        int charsLeft = n;
        while (charsLeft > 0) {
            charsLeft -= numRows;
            numCols++;
            
            for (int j=numColsMiddle; j>0; j--) {
                if (charsLeft <= 0 ) {
                    break;
                }
                charsLeft -= 1;
                numCols++;
            }
        }
        
        char[][] board = new char[numRows][numCols];
        
        int row = -1;
        int col = 0;
        boolean down = true;
        
        for (int i=0; i<s.length(); i++) {
            if (down && row == numRows - 1) {
                down = false;
            }
            else if (!down && row==0) {
                down = true;
            }
            
            if (down) {
                row++;
            }
            else {
                row--;
                col++;
            }
            
            board[row][col] = s.charAt(i);
        }
        
        StringBuffer sb = new StringBuffer();
        for (int i=0; i < numRows; i++) {
            for (int j=0; j < numCols; j++) {
                if (board[i][j] != '\0')
                    sb.append(board[i][j]);
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
       // String s = "PAYPALISHIRING";
        //String ans = sol.convert2(s, 4);
        
        //String s = "ABC";
        //String ans = sol.convert2(s, 2);
        
        String s = "A";
        String ans = sol.convert2(s, 2);
        
        System.out.println(ans);
    }

}
