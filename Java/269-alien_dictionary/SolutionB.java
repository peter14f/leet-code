import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class SolutionB {

    public String alienOrder(String[] words) {

        HashMap<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
        
        String prev = null;
        
        for (String word: words) {
            
            if (word.length() == 0)
                continue;
            
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<Character>());
                }
            }
            
            if (prev != null && !prev.equals(word)) {
                addToGraph(prev, word, graph);
            }
            
            prev = word;
        }
        
        //System.out.println(graph);
        
        StringBuffer sb = new StringBuffer();
        
        HashMap<Character, Integer> states = new HashMap<Character, Integer>();
        for (char c: graph.keySet()) {
            states.put(c, 0);
        }
        
        for (char c: states.keySet()) {
            if (states.get(c) == 0) {
                if (dfsTopologicalSort(graph, c, states, sb)) {
                    return "";
                }
            }
        }
        
        return sb.reverse().toString();
    }
    
    private boolean dfsTopologicalSort(
            HashMap<Character, Set<Character>> graph,
            char c,
            HashMap<Character, Integer> states, 
            StringBuffer sb) {
        
        boolean foundCycle = false;
        
        // set state to one
        states.put(c, 1);
        
        for (Character neighbor: graph.get(c)) {
            
            if (states.get(neighbor) == 1) {
                return true;
            }
            else if (states.get(neighbor) == 0) {
                foundCycle = dfsTopologicalSort(graph, neighbor, states, sb);
                if (foundCycle)
                    return true;
            }
            
        }
        
        states.put(c, 2);
        sb.append(c);
        
        return false;
    }
    
    private void addToGraph(String prev, String cur, HashMap<Character, Set<Character>> graph) {
        
        int length = Math.min(prev.length(), cur.length());
        
        for (int i=0; i<length; i++) {
            char p = prev.charAt(i);
            char q = cur.charAt(i);
            
            // relationship can only be seen on the first pair different characters 
            if (p != q) {
                
                // p -> q (p bigger than q)
                
                if (!graph.containsKey(p)) {
                    HashSet<Character> neighbors = new HashSet<Character>();
                    neighbors.add(q);
                    graph.put(p, neighbors);
                }
                else {
                    graph.get(p).add(q);
                }
                
                if (!graph.containsKey(q)) {
                    HashSet<Character> neighbors = new HashSet<Character>();
                    graph.put(q, neighbors);
                }
                
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        String[] words = {
                /*
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
                */
                "z"
              };
        
        SolutionB sol = new SolutionB();
        String order = sol.alienOrder(words);
        
        System.out.println(order);
    }

}
