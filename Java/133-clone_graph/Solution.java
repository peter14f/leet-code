import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node==null)
            return null;
        
        // toVisit contains nodes in the src graph
        ArrayList<UndirectedGraphNode> toVisit = new ArrayList<UndirectedGraphNode>();
        toVisit.add(node);
        
        // map of allocated nodes
        HashMap<Integer, UndirectedGraphNode> newNodeMap = 
                new HashMap<Integer, UndirectedGraphNode>();
        
        UndirectedGraphNode startNode = null;
        
        while (!toVisit.isEmpty()) {
            node = toVisit.remove(0);
            
            UndirectedGraphNode newNode;
            
            if (newNodeMap.containsKey(node.label)) {
                // this node was already allocated
                newNode = newNodeMap.get(node.label);
            }
            else {
                // node allocation needed
                newNode = new UndirectedGraphNode(node.label);
                
                if (newNodeMap.isEmpty()) {
                    // start start of the graph which will be returned
                    startNode = newNode;
                }
                
                newNodeMap.put(newNode.label, newNode);
            }

            for (UndirectedGraphNode neighbor: node.neighbors) {
                
                if (newNodeMap.containsKey(neighbor.label)) {
                    // neighbor node already deep copied
                    newNode.neighbors.add(newNodeMap.get(neighbor.label));
                }
                else {
                    // neighbor node needs to be deep copied
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    newNodeMap.put(newNeighbor.label, newNeighbor);
                    newNode.neighbors.add(newNodeMap.get(neighbor.label));
                    
                    toVisit.add(neighbor);
                }
            }
        }
        
        return startNode;
    }

    // print all neighbor nodes
    public void printNeighbors(UndirectedGraphNode node) {
        for (UndirectedGraphNode n : node.neighbors) {
            System.out.println(" neighbor " + n.label);
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
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
        
        System.out.println("-----Graph A-----");
        System.out.println("node " + zero.label);
        sol.printNeighbors(zero);
        
        for (UndirectedGraphNode n : zero.neighbors) {
            System.out.println("node " + n.label);
            sol.printNeighbors(n);
        }
        
        UndirectedGraphNode a = sol.cloneGraph(zero);
        
        System.out.println("-----Graph B-----");
        System.out.println("node " + a.label);
        sol.printNeighbors(a);
        
        for (UndirectedGraphNode n : a.neighbors) {
            System.out.println("node " + n.label);
            sol.printNeighbors(n);
        }
        
        
    }

}
