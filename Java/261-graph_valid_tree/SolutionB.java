import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class SolutionB {
    class Node {
        int val;
        List<Integer> neighbors;
        public Node(int x) {
            val = x;
            neighbors = new ArrayList<Integer>();
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        int k = edges.length;
        
        if (n==0 && k==0)
            return true;
        
        Node[] nodes = new Node[n];
        
        for (int i=0; i<n; i++) {
            nodes[i] = new Node(i);
        }
        
        for (int i=0; i<k; i++) {
            nodes[edges[i][0]].neighbors.add(edges[i][1]);
            nodes[edges[i][1]].neighbors.add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        
        while (!q.isEmpty()) {
            int nodeId = q.poll();
            
            if (visited[nodeId])
                return false;
            
            for (int neighbor: nodes[nodeId].neighbors) {
                if (!visited[neighbor]) {
                    q.offer(neighbor);
                }
            }
            
            visited[nodeId] = true;
        }
        
        for (int i=0; i<n; i++) {
            if (!visited[i])
                return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 3}
        };
        
        SolutionB sol = new SolutionB();
        boolean validTree = sol.validTree(4, edges);
        System.out.println(validTree);
    }

}
