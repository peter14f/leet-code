import java.util.ArrayList;
import java.util.List;


public class SolutionBottomUp {

    public List<Integer> grayCode(int n) {
        
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        
        if (n<1)
            return ans;
        
        ans.add(1);
        
        for (int i=2; i<=n; i++) {
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
        List<Integer> ans = sol.grayCode(10);
        System.out.println(ans);
    }

}
