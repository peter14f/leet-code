import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SolutionBFSBest {

    public boolean validTree(int n, int[][] edges) {
        
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        
        for (int i=0; i<n; i++) {
            graph.add(new HashSet<Integer>());
        }
        
        int k=edges.length;
        
        if (k==0) {
            // no edges
            if (n==0 || n==1)
                return true;
            else
                return false;
        }
        
        for (int i=0; i<k; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        boolean cycle = false;
        
        // could start anywhere
        Queue<Integer> q = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        
        q.add(edges[0][0]);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
        
            if (visited.contains(cur)) {
                cycle = true;
                break;
            }
            
            Set<Integer> neighbors = graph.get(cur);
            
            for (int neighbor: neighbors) {
                // neighbor already in visited set
                if (visited.contains(neighbor))
                    continue;
                
                q.offer(neighbor);
            }
            
            visited.add(cur);
        }
        
        if (cycle)
            return false;
        
        // all nodes reachable?
        return visited.size() == n;
    }
    
    public static void main(String[] args) {
        SolutionBFSBest sol = new SolutionBFSBest();
        
        int[][] edges = {
                {0, 1},
                {0, 3},
                {0, 2},
                {1, 4}
        };
        
        boolean validTree = sol.validTree(5, edges);
        
        System.out.println(validTree);
    }

}
