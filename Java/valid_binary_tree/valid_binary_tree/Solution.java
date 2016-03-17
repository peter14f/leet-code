package valid_binary_tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public String graphValidBinaryTree(String input) {
        
        String[] pairs = input.split(" ");
        
        // 0 means no edge
        // 1 means out edge
        // 2 means in edge
        char[][] graph = new char[26][26];
        
        int[] outDegree = new int[26];
        int[] inDegree = new int[26];
        
        for (int i=0; i<pairs.length; i++) {
            // a -> b
            int a = pairs[i].charAt(1) - 'A';
            outDegree[a]++;
            
            if (outDegree[a] > 2)
                return "E1";
        }
        
        // Duplicate Edges
        for (int i=0; i<pairs.length; i++) {
            // a -> b
            int a = pairs[i].charAt(1) - 'A';
            int b = pairs[i].charAt(3) - 'A';
            
            if (graph[a][b] != 0 || graph[b][a] != 0)
                return "E2";
            
            graph[a][b] = 1;
            graph[b][a] = 2;
            
            inDegree[b]++;
        }
        
        int root = -1; // a root in the graph
        int numNodes = 0; // how many nodes in total
        
        for (int i=0; i<26; i++) {
            if (inDegree[i] > 0 || outDegree[i] > 0)
                numNodes++;
            
            if (inDegree[i] == 0 && outDegree[i] > 0) {
                root = i;
            }
        }
        
        // E3: Cycle Present
        
        Queue<Integer> q = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        
        q.offer(root);
        
        while (!q.isEmpty()) {
            int node = q.poll();
            
            if (visited.contains(node)) {
                return "E3";
            }
            
            for (int i=0; i<26; i++) {
                // can get to i from node and i not visited yet
                if (graph[node][i] > 0 && !visited.contains(i)) {
                    q.offer(i);
                }
            }
            
            visited.add(node);
        }
        
        // multiple roots
        if (visited.size() < numNodes) {
            return "E4";
        }
        
        if (numNodes > 0) {
            StringBuffer sb = new StringBuffer();
            treeToSb(graph, root, sb);
            return sb.toString();
        }
        else {
            return "";
        }
    }
    
    private void treeToSb(char[][] graph, int node, StringBuffer sb) {
        sb.append("(");
        sb.append((char)('A' + node));
        
        for (int i=0; i<26; i++) {
            // can get to i from node
            if (graph[node][i] == 1) {
                treeToSb(graph, i, sb);
            }
        }
        
        sb.append(")");
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String ans = sol.graphValidBinaryTree("(A,B) (B,C) (D,E)");
        System.out.println(ans);
    }

}
