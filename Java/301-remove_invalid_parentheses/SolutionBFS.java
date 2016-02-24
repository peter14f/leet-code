import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SolutionBFS {

    class Entry {
        StringBuffer str;
        int numRemoved;
        
        public Entry(StringBuffer sb, int num) {
            str = sb;
            numRemoved = num;
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        
        Queue<Entry> q = new LinkedList<Entry>();
        q.offer(new Entry(new StringBuffer(s), 0));
        
        HashSet<String> ansSet = new HashSet<String>();
        List<String> ans = new ArrayList<String>();
        int minRemove = 0;
        
        HashSet<String> visited = new HashSet<String>();
        
        while (!q.isEmpty()) {
            Entry ent = q.poll();
            
            /*
            System.out.println("str=" + ent.str + 
                    " valid=" + isValid(ent.str) + 
                    " num=" + ent.numRemoved);
            */
            
            if (isValid(ent.str)) {
                if (minRemove==0) {
                    if (ent.numRemoved == 0) {
                        ans.add(ent.str.toString());
                        return ans;
                    }
                    else {
                        minRemove = ent.numRemoved;
                        ansSet.add(ent.str.toString());
                    }
                }
                else {
                    if (ent.numRemoved == minRemove) {
                        String str = ent.str.toString();
                        if (!ansSet.contains(str))
                            ansSet.add(str);
                    }
                }
            }
            else {
                
                if (minRemove > 0 && ent.numRemoved >= minRemove) {
                    continue;
                }
                
                for (int i=0; i<ent.str.length(); i++) {
                    
                    char cToDelete = ent.str.charAt(i);
                    
                    if (cToDelete == '(' || cToDelete == ')') {
                        ent.str.deleteCharAt(i);
                        String temp = ent.str.toString();
                        if (!visited.contains(temp)) {
                            //System.out.println("  " + i + " removed -> " + ent.str);
                            Entry newEnt = new Entry(new StringBuffer(ent.str), ent.numRemoved + 1);
                            //System.out.println("  " + i + " recovered -> " + ent.str);
                            q.offer(newEnt);
                            
                            visited.add(temp);
                        }
                            
                        ent.str.insert(i, cToDelete);
                    }
                }
            }
        }
        
        ans.addAll(ansSet);
        return ans;
    }
    
    private boolean isValid(StringBuffer sb) {
        if (sb.length() == 0)
            return true;
        
        int openCnt = 0;
        
        for (int i=0; i<sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(')
                openCnt++;
            else if (c == ')') {
                if (openCnt==0)
                    return false;
                openCnt--;
            }
        }
        
        return openCnt == 0;
    }
    
    public static void main(String[] args) {
        SolutionBFS sol = new SolutionBFS();
        List<String> ans = sol.removeInvalidParentheses(")()))())))");
        System.out.println("size=" + ans.size());
        System.out.println(ans);
    }

}
