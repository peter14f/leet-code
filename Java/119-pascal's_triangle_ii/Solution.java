import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> prevRow = new ArrayList<Integer>();
        prevRow.add(1);
        
        if (rowIndex == 0) {
            return prevRow;
        }
        
        List<Integer> tmp = new ArrayList<Integer>();
        
        for (int row=1; row <= rowIndex; row++) {
            tmp.clear();
            
            for (int j=0; j<=row; j++) {
                if (j==0 || j==row) {
                    tmp.add(1);
                }
                else {
                    tmp.add(prevRow.get(j) + prevRow.get(j-1));
                }
            }
            
            if (row==rowIndex)
                return tmp;
            
            List<Integer> p = prevRow;
            prevRow = tmp;
            tmp = p;
        }
        
        return prevRow;
    }
    
    public static void main(String[] args) {

        Solution sol = new Solution();
        
        List<Integer> row = sol.getRow(3);
        System.out.println(row);
    }

}
