import java.util.ArrayList;
import java.util.List;


public class Vector2DB {

    List<List<Integer>> l;
    int row, col, m;
    
    public Vector2DB(List<List<Integer>> vec2d) {
        l = vec2d;        
        m = l.size();
        row = 0;
        col = 0;
    }
    
    public int next() {
        int toReturn = l.get(row).get(col);
        col++;
        return toReturn;
    }
    
    public boolean hasNext() {
        while (row < m) {
            if (col < l.get(row).size())
                return true;
            col=0;
            row++;
        }
        
        return false;
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
        
        Vector2DB v = new Vector2DB(vector);
        
        while (v.hasNext()) {
            System.out.println(v.next());
        }
    }

}
