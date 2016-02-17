import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(n, false);
    }
    
    private List<String> findStrobogrammatic(int n, boolean leadingZero) {
        
        List<String> ans = new ArrayList<String>();
        
        if (n <= 0)
            return ans;
        
        if (n==1) {
            // single digit strobogrammatic characters are '0', '1', '8'
            ans.add("0");
            ans.add("1");
            ans.add("8");
            return ans;
        }
        
        if (n==2) {
            if (leadingZero)
                ans.add("00");
            
            ans.add("11");
            ans.add("69");
            ans.add("88");
            ans.add("96");
        }
        
        List<String> strs = findStrobogrammatic(n-2, true);
        List<Character> left = new ArrayList<Character>();
        List<Character> right = new ArrayList<Character>();
        
        if (leadingZero) {
            left.add('0');
            right.add('0');
        }
        
        left.add('1');
        right.add('1');
        left.add('6');
        right.add('9');
        left.add('8');
        right.add('8');
        left.add('9');
        right.add('6');
        
        for (String s: strs) {
            for (int i=0; i<left.size(); i++) {
                StringBuffer sb = new StringBuffer();
                sb.append(left.get(i));
                sb.append(s);
                sb.append(right.get(i));
                ans.add(sb.toString());
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> ans = sol.findStrobogrammatic(4);
        System.out.println(ans);
    }

}
