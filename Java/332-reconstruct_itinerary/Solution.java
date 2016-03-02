import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution {

    public List<String> findItinerary(String[][] tickets) {
        
        int n = tickets.length;
        List<String> ans = new ArrayList<String>();
        
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        
        for (int i=0; i<n; i++) {
            
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            if (!graph.containsKey(from))
                graph.put(from, new ArrayList<String>());
            
            graph.get(from).add(to);
            
        }
        
        for (List<String> neighbors: graph.values()) {
            Collections.sort(neighbors);
        }
        
        if (graph.containsKey("JFK"))
            findItinerary(graph, ans, "JFK", n);
        
        return ans;
    }
    
    private boolean findItinerary(Map<String, List<String>> graph,
            List<String> ans, String cur, int n) {
        
        ans.add(cur);
        
        if (ans.size() == n+1) {
            return true;
        }
        
        if (graph.containsKey(cur)) {
            int origSize = graph.get(cur).size();
            
            for (int i=0; i<origSize; i++) {
                String next = graph.get(cur).remove(i);
                
                List<String> tmp = null;
                boolean removed = false;
                if (graph.get(cur).isEmpty()) {
                    tmp = graph.remove(cur);
                    removed = true;
                }
                
                // the recursive call will not see the ith choice
                boolean done = findItinerary(graph, ans, next, n);
                
                if (done) {
                    return true;
                }
                
                if (removed)
                    graph.put(cur, tmp);
                
                graph.get(cur).add(i, next);    
            }
        }
        
        // hit a dead end, backtrack
        ans.remove(ans.size()-1);
        return false;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] tickets = {{"CBR","JFK"},{"TIA","EZE"},{"AUA","TIA"},{"JFK","EZE"},{"BNE","CBR"},{"JFK","CBR"},{"CBR","AUA"},{"EZE","HBA"},{"AXA","ANU"},{"BNE","EZE"},{"AXA","EZE"},{"AUA","ADL"},{"OOL","JFK"},{"BNE","AXA"},{"OOL","EZE"},{"EZE","ADL"},{"TIA","BNE"},{"EZE","TIA"},{"JFK","AUA"},{"AUA","EZE"},{"ANU","ADL"},{"TIA","BNE"},{"EZE","OOL"},{"ANU","BNE"},{"EZE","ANU"},{"ANU","AUA"},{"BNE","ANU"},{"CNS","JFK"},{"TIA","ADL"},{"ADL","AXA"},{"JFK","OOL"},{"AUA","ADL"},{"ADL","TIA"},{"ADL","ANU"},{"ADL","JFK"},{"BNE","EZE"},{"ANU","BNE"},{"JFK","BNE"},{"EZE","AUA"},{"EZE","AXA"},{"AUA","TIA"},{"ADL","CNS"},{"AXA","AUA"}};
        
        System.out.println("n=" + tickets.length);
        List<String> ans = sol.findItinerary(tickets);
        System.out.println(ans);
        System.out.println(ans.size());
        
    }

}
    