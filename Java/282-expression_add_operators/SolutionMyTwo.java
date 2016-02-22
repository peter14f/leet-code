import java.util.ArrayList;
import java.util.List;


public class SolutionMyTwo {

    public List<String> addOperators(String num, int target) {
        
        List<String> result = new ArrayList<String>();
        
        dfsAddToResult(num, 0, target, 
                       0,  
                       "",
                       0,
                       result);
        
        return result;
    }
    
    /* prevNum is needed when trying to add a '*' because the new sum won't be
     * 
     * curSum * a
     * 
     * Instead we need to know the prevNum and set curSum to 
     * 
     * curSum - prevNum + prevNum * a
     * 
     */
    private void dfsAddToResult(String num, int start, int target,
                                long curSum,
                                String curStr,
                                long prevNum,
                                List<String> result) {
        
        if (start == num.length()) {
            if (curSum == target)
                result.add(curStr);
            return;
        }
        
        for (int end=start; end<num.length(); end++) {
            String aStr = num.substring(start, end+1);
            
            if (aStr.length() > 1 && num.charAt(start) == '0')
                break;
            
            long a = Long.parseLong(aStr);
            
            if (curStr.isEmpty()) {
                dfsAddToResult(num, end+1, target, 
                               curSum + a, 
                               curStr + a,
                               a,
                               result); 
            }
            else {
                // put a '+'
                dfsAddToResult(num, end+1, target,
                               curSum + a,
                               curStr + '+' + a,
                               a,
                               result);
                
                // put a '-'
                dfsAddToResult(num, end+1, target,
                               curSum - a,
                               curStr + "-" + a,
                               -a,
                               result);
                
                // put a '*'
                dfsAddToResult(num, end+1, target,
                               curSum-prevNum + prevNum*a,
                               curStr + "*" + a,
                               prevNum*a,
                               result);
            }
        } // for end
    }
    
    public static void main(String[] args) {
        SolutionMyTwo sol = new SolutionMyTwo();
        List<String> ans = sol.addOperators("123456789", 45);
        System.out.println(ans);
        System.out.println(ans.size());
    }

}
