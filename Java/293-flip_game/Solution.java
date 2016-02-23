import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> nextState = new ArrayList<String>();
        
        StringBuffer sb = new StringBuffer(s);
        
        for (int start=0; start<s.length()-1; start++) {
            
            if (s.charAt(start) == '+' && s.charAt(start+1) == '+') {
                // temporary flip sb
                sb.setCharAt(start, '-');
                sb.setCharAt(start+1, '-');
                
                // save a copy into nextState
                nextState.add(sb.toString());
                
                // undo the change on sb
                sb.setCharAt(start, '+');
                sb.setCharAt(start+1, '+');
            }
            
        }
        
        return nextState;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> strs = sol.generatePossibleNextMoves("++");
        System.out.println(strs);
    }

}
