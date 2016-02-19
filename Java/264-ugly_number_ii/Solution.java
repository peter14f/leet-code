import java.util.ArrayList;
import java.util.List;


public class Solution {

    public int nthUglyNumber(int n) {
        
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        List<Integer> l3 = new ArrayList<Integer>();
        
        int num = 1;
        int index = 1;
        
        int i=0; 
        int j=0;
        int k=0;
        
        while (index < n) {
            expandLists(l1, l2, l3, num);
            
            num = Math.min(l1.get(i), Math.min(l2.get(j), l3.get(k)));
            index++;
            
            if (num == l1.get(i))
                i++;
            if (num == l2.get(j))
                j++;
            if (num == l3.get(k))
                k++;
        }
        
        /*
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        */
        
        return num;
    }
    
    private void expandLists(List<Integer> l1, List<Integer> l2, List<Integer> l3, int num) {
        l1.add(num * 2);
        l2.add(num * 3);
        l3.add(num * 5);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ugly = sol.nthUglyNumber(10);

        System.out.println(ugly);
    }

}
