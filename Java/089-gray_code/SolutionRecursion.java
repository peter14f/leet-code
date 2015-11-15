import java.util.ArrayList;
import java.util.List;


public class SolutionRecursion {
    public List<Integer> grayCode(int n) {
        
        if (n < 0)
            throw new IllegalArgumentException("n must be a non-negative integer");
        if (n==0) {
            List<Integer> ans = new ArrayList<Integer>();
            ans.add(0);
            return ans;
        }
        else {
            List<Integer> prevAns = grayCode(n-1);
            
            int prevSize = prevAns.size();
            int toAdd = 1 << (n-1);
            
            for (int i=prevSize-1; i>=0; i--) {
                int newNum = prevAns.get(i) + toAdd;
                prevAns.add(newNum);
            }
            
            return prevAns;
        }
    }
    
    public static void main(String[] args) {
        SolutionRecursion sol = new SolutionRecursion();
        List<Integer> ans = sol.grayCode(1);
        System.out.println(ans);
    }

}
