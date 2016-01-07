package clone_graph;

import java.util.HashMap;

public class Solution {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if (node==null)
            return null;
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        dfsCopy(node, mapping);
        
        return mapping.get(node);
    }
    
    private void dfsCopy(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping) {
        if (mapping.containsKey(node)) {
            return;
        }
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        mapping.put(node, newNode);
                
        for (UndirectedGraphNode neighbor: node.neighbors) {            
            dfsCopy(neighbor, mapping);
            newNode.neighbors.add(mapping.get(neighbor));
        }
        
    }
    
    public static void main(String[] args) {
        
        UndirectedGraphNode zero = new UndirectedGraphNode(0);
        UndirectedGraphNode one = new UndirectedGraphNode(1);
        UndirectedGraphNode two = new UndirectedGraphNode(2);
        
        zero.neighbors.add(one);
        zero.neighbors.add(two);
        
        one.neighbors.add(zero);
        one.neighbors.add(two);
        
        two.neighbors.add(zero);
        two.neighbors.add(one);
        two.neighbors.add(two);
        
        Solution sol = new Solution();
        UndirectedGraphNode h = sol.cloneGraph(zero);
        
        System.out.println(h.label + " " + h.neighbors.size() + " neighbors");
        
        for (UndirectedGraphNode n: h.neighbors) {
            System.out.println(n.label + " " + n.neighbors.size() + " neighbors");
        }
    }

}
