import java.util.ArrayList;
import java.util.List;


public class SolutionB {

    public List<String> findStrobogrammatic(int n) {
        List<String> prevPrev = new ArrayList<String>();
        char[] left = {'0', '1', '6', '8', '9'};
        char[] right = {'0', '1', '9', '8', '6'};
        
        if (n <= 0)
            return prevPrev;
        
        prevPrev.add("0");
        prevPrev.add("1");
        prevPrev.add("8");
        
        if (n == 1)
            return prevPrev;
        
        List<String> prev = new ArrayList<String>();
        prev.add("11");
        prev.add("69");
        prev.add("88");
        prev.add("96");
        
        if (n == 2)
            return prev;
        
        // digit 2 list can have leading zero when building list for higher digit
        prev.add("00");
        
        List<String> cur = null;
        
        for (int digit=3; digit<=n; digit++) {
            cur = new ArrayList<String>();
            for (String s: prevPrev) {
                for (int i= (digit==n) ? 1 : 0; i<left.length; i++) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(left[i]);
                    sb.append(s);
                    sb.append(right[i]);
                    cur.add(sb.toString());
                }
            }
            prevPrev = prev;
            prev = cur;
        }
        
        return cur;
    }
    
    public static void main(String[] args) {
        SolutionB sol = new SolutionB();
        List<String> ans = sol.findStrobogrammatic(5);
        System.out.println(ans);
    }

}
