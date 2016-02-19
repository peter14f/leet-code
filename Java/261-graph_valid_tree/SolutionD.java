import java.util.ArrayList;
import java.util.List;


public class SolutionD {

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {2, 3},
                {2, 4}
        };
        
        SolutionD sol = new SolutionD();
        boolean validTree = sol.validTree(5, edges);
        System.out.println(validTree);
    }

    class Node {
        int val;
        List<Integer> neighbors;
        
        public Node(int x) {
            val = x;
            neighbors = new ArrayList<Integer>();
        }
    }
    
    private boolean validTree(int n, int[][] edges) {
        
        Node[] nodes = new Node[n];
        for (int i=0; i<n; i++) {
            nodes[i] = new Node(i);
        }
        
        for (int i=0; i<edges.length; i++) {
            nodes[edges[i][0]].neighbors.add(edges[i][1]);
            nodes[edges[i][1]].neighbors.add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        
        if (dfsFoundCycle(0, -1, visited, nodes)) {
            return false;
        }
        
        for (int i=0; i<n; i++) {
            if (!visited[i])
                return false;
        }
        
        return true;
    }

    private boolean dfsFoundCycle(int nodeId, int sourceId, boolean[] visited, Node[] nodes) {
        
        Node cur = nodes[nodeId];
        
        if (visited[nodeId])
            return true;
        
        visited[nodeId] = true;
        
        for (int neighbor : cur.neighbors) {
            if (neighbor == sourceId)
                continue;
            
            if (dfsFoundCycle(neighbor, nodeId, visited, nodes)) {
                return true;
            }
        }
        
        return false;
    }
    
}
