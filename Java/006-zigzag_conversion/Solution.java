
public class Solution {

    /* There are 3 cases to consider
     * 1) nRows = 1
     * 2) nRows = 2
     * 3) nRows > 2
     */
    public String convert(String s, int nRows) {
        if (nRows==1)
            return s;
        
        char[] sArr = s.toCharArray();
        
        // how many sets of "-" and "/"
        int howmany = (int)Math.ceil((double)s.length() / (nRows + (nRows - 2)));
        
        /* total number of rows needed,
         * each set requires 1 + nRows - 2 rows
         */
        int gridSize = howmany * (nRows - 1);
        
        char[][] grid = new char[gridSize][nRows];
        int row = 0;
        int col = 0;
        boolean zag = false;
        
        for (int i=0; i<sArr.length; i++) {
            if (zag == false) {
                grid[row][col] = sArr[i];
                
                col++;
                
                if (col == nRows) {
                    zag = true;
                    col-=2;
                    row++;
                }
            }
            else {
                if (col==0) {
                    // only possible when nRows == 2
                    zag = false;
                    grid[row][col] = sArr[i];
                    col++;
                }
                else {
                    grid[row][col] = sArr[i];
                
                    col--;
                    row++;
                
                    if (col == 0)
                        zag = false;
                }
            }
        }
        
        StringBuffer sb = new StringBuffer();
        
        for (int j = 0; j < nRows; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] != '\0') {
                    sb.append(grid[i][j]);
                }
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] argv) {
        Solution sol = new Solution();
        String input = "PAYPALISHIRING";
        String output = sol.convert(input, 3);
        System.out.println(output);
        input = "ABC";
        output = sol.convert(input, 2);
        System.out.println(output);
        
        input = "ABCD";
        output = sol.convert(input, 2);
        System.out.println(output);
    }
}
