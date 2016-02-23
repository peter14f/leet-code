import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {

    public boolean canWin(String s) {
        Queue<String> q1 = new LinkedList<String>();
        Queue<String> q2 = new LinkedList<String>();
        
        q1.offer(s);
        
        while (!q1.isEmpty() || !q2.isEmpty()) {
            
            if (!q1.isEmpty()) {
                // I'm yet to make a move
                while (!q1.isEmpty()) {
                    String str = q1.poll();
                    
                    List<String> insertInQ2 = generatePossibleNextMoves(str);
                    
                    for (String st: insertInQ2) {
                        if (getNumPairs(st) == 0)
                            return true;
                        q2.offer(st);
                    }
                }
                
                if (q2.isEmpty()) {
                    // I couldn't make any move
                    return false;
                }
            }
            else if (!q2.isEmpty()) {
                // the opponent is yet to make a move
                String str = q2.poll();
                List<String> insertInQ1 = generatePossibleNextMoves(str);
                
                for (String st: insertInQ1) {
                    if (getNumPairs(st) == 0) {
                        
                        return false;
                    }
                    q1.offer(st);
                }
                
                if (q1.isEmpty())
                    // opponent couldn't make any more
                    return true;
            }
        }
        
        return false;
    }
    
    private int getNumPairs(String s) {
        int cnt = 0;
        
        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                cnt++;
            }
        }
        
        return cnt;
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
        String s = "++-----------++++++-----+-------------------------+-+-++++++";
        Solution sol = new Solution();
        boolean canWin = sol.canWin(s);
        System.out.println(canWin);
    }

}
