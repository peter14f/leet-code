import java.util.ArrayList;
import java.util.List;


public class SolutionB {

    public int nthUglyNumber(int n) {
        
        int index = 1;
        int ugly = 1;
        
        List<Integer> l = new ArrayList<Integer>();
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (index < n) {
            
            l.add(ugly*2);
            l.add(ugly*3);
            l.add(ugly*5);
            
            ugly = Math.min(l.get(3*i), 
                           Math.min(l.get(3*j+1), 
                                    l.get(3*k+2)));
            
            index++;
            
            if (ugly == l.get(3*i))
                i++;
            if (ugly == l.get(3*j+1))
                j++;
            if (ugly == l.get(3*k+2))
                k++;
            
        }
        
        return ugly;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution sol = new Solution();
        int ugly = sol.nthUglyNumber(7);
        System.out.println(ugly);
    }

}
