import java.util.ArrayList;
import java.util.List;


public class SolutionDFS {

    public boolean canWin(String s) {
        return canWinCheck(s);
    }
    
    private boolean canWinCheck(String s) {
        
        List<String> nextMoves = generatePossibleNextMoves(s);
        
        for (String move : nextMoves) {
            boolean toReturn = !canWin(move);
            
            if (toReturn)
                return true;
        }
        
        // none of the moves generated leads to victory
        return false;
    }
    
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
        SolutionDFS sol = new SolutionDFS();
        boolean canWin = sol.canWin("+++++");
        System.out.println(canWin);
    }

}
