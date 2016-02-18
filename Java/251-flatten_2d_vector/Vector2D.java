import java.util.ArrayList;
import java.util.List;



/* The 2D matrix is not strictly a rectangle
 * Each row may have different lengths
 * 
 * you may have empty rows
 */
public class Vector2D {
    List<List<Integer>> l;
    int row, col, m;
    
    public Vector2D(List<List<Integer>> vec2d) {
        l = vec2d;        
        m = l.size();
        row = 0;
        col = 0;
    }

    public int next() {
        
        if (col == l.get(row).size()) {
            col=0;
            row++;
        }
        
        int toReturn = l.get(row).get(col);
        
        col++;
        
        if (col == l.get(row).size()) {
            col = 0;
            row++;
        }
        
        return toReturn;
    }

    public boolean hasNext() {
        if (row < m && col < l.get(row).size())
            return true;
        else if (row < m) {
            row++;
            col=0;
            return hasNext();
        }
        else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        List<List<Integer>> vector = new ArrayList<List<Integer>>();
        List<Integer> row1 = new ArrayList<Integer>();
        List<Integer> row2 = new ArrayList<Integer>();
        List<Integer> row3 = new ArrayList<Integer>();
        
        //row1.add(1);
        //row1.add(2);
        
        //row2.add(3);
        
        row3.add(4);
        row3.add(5);
        row3.add(6);
        
        vector.add(row1);
        vector.add(row2);
        vector.add(row3);
        
        // System.out.println(vector);
        
        Vector2D v = new Vector2D(vector);
        
        while (v.hasNext()) {
            System.out.println(v.next());
        }
    }

}
