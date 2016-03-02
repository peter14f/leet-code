import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionBFS {

public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if (node==null)
            return null;
        
        UndirectedGraphNode src = new UndirectedGraphNode(node.label);
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> clone = new 
                HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        clone.put(node, src);
        
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        
        q.offer(node);
        
        // stored nodes in the original graph whose neighbor links are already cloned
        HashSet<UndirectedGraphNode> cloned = new HashSet<UndirectedGraphNode>();
        
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            
            if (cloned.contains(cur))
                continue;
            
            UndirectedGraphNode curClone = clone.get(cur);
            
            for (UndirectedGraphNode neighbor: cur.neighbors) {
                
                if (!clone.containsKey(neighbor)) {
                    UndirectedGraphNode neighborClone = new UndirectedGraphNode(neighbor.label);
                    clone.put(neighbor, neighborClone);
                    
                }
                UndirectedGraphNode neighborClone = clone.get(neighbor);
                curClone.neighbors.add(neighborClone);
                
                q.offer(neighbor);
            }
            
            cloned.add(cur);
        }
        
        return src;
    }
    
    public static void main(String[] args) {
        
        UndirectedGraphNode a = new UndirectedGraphNode(1);
        UndirectedGraphNode b = new UndirectedGraphNode(0);
        UndirectedGraphNode c = new UndirectedGraphNode(2);
        
        a.neighbors.add(b);
        a.neighbors.add(c);
        
        b.neighbors.add(c);
        
        c.neighbors.add(c);
        
        SolutionBFS sol = new SolutionBFS();
        UndirectedGraphNode cloned = sol.cloneGraph(a);
        
        System.out.println(cloned.label);
        
        System.out.println(" neighbors:");
        
        for (UndirectedGraphNode neighbor: cloned.neighbors) {
            System.out.println(neighbor.label + " " + neighbor.neighbors.size());
        }

    }

}
