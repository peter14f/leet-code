import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class SolutionBFS {

    public String alienOrder(String[] words) {
        HashMap<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
        HashMap<Character, Integer> indegrees = new HashMap<Character, Integer>();
        String prev = null;
        
        for (String word: words) {
            if (word.length() == 0) 
                continue;
            
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                
                if (!graph.containsKey(c)) {
                    HashSet<Character> neighbors = new HashSet<Character>();
                    graph.put(c, neighbors);
                }
                
                if (!indegrees.containsKey(c)) {
                    indegrees.put(c, 0);
                }
            }
            
            if (prev != null && !word.equals(prev)) {
                addToGraph(graph, indegrees, prev, word);
            }
            
            prev = word;
        }
        
        //System.out.println(graph);
        
        Queue<Character> q = new LinkedList<Character>();
        
        for (Character c: indegrees.keySet()) {
            if (indegrees.get(c) == 0) {
                q.offer(c);
            }
        }
        
        StringBuffer sb = new StringBuffer();
        
        while (!q.isEmpty()) {
            char c = q.poll();
            
            sb.append(c);
            
            for (char neighbor: graph.get(c)) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if ((indegrees.get(neighbor) == 0)) {
                    q.offer(neighbor);
                }
            }
            
            graph.remove(c);
        }
        
        // this means there exists a cycle: 
        // there should a source node until the graph is empty 
        //
        if (!graph.isEmpty()) {
            return "";
        }
        
        // indegree being zero is actually the source node
        // so no need to reverse
        return sb.toString();
    }
    
    private void addToGraph(HashMap<Character, Set<Character>> graph,
                            HashMap<Character, Integer> indegrees,
                            String prev,
                            String cur) {
        
        int min = Math.min(prev.length(), cur.length());
        
        for (int i=0; i<min; i++) {
            char p = prev.charAt(i);
            char q = cur.charAt(i);
            
            // p -> q
            if (p != q) {
                if (!graph.get(p).contains(q)) {
                    graph.get(p).add(q);
                    indegrees.put(q, indegrees.get(q)+1);
                }
                break;
            }
        }
    }
                            
    
    public static void main(String[] args) {
        String[] words = {
                
                "z"
                
              };
        
        SolutionBFS sol = new SolutionBFS();
        String dictorder = sol.alienOrder(words);
        System.out.println(dictorder);        
    }

}
