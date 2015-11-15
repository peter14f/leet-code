import java.util.ArrayList;
import java.util.List;


public class SolutionBottomUp {

    public List<Integer> grayCode(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be a non-negative integer");
        
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        
        for (int i=1; i<=n; i++) {
            int origSize = ans.size();
            int toAdd = 1 << (i-1);
            
            for (int j=origSize - 1; j >= 0; j--) {
                ans.add(ans.get(j) + toAdd);
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        SolutionBottomUp sol = new SolutionBottomUp();
        List<Integer> ans = sol.grayCode(2);
        System.out.println(ans);
    }

}
