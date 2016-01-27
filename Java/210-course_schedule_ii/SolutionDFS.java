import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class SolutionDFS {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
        
        for (int i=0; i<prerequisites.length; i++) {
            int course = prerequisites[i][0]; 
            int dependsOn = prerequisites[i][1];
            
            if (graph.containsKey(course)) {
                graph.get(course).add(dependsOn);
            }
            else {
                HashSet<Integer> courses = new HashSet<Integer>();
                courses.add(dependsOn);
                graph.put(course, courses);
            }
        }
        
        int[] states = new int[numCourses];
        int[] order = new int[numCourses];
        int[] index = {0};
        
        boolean cycleFound = false;
        
        for (int i=0; i<numCourses; i++) {
            if (states[i] == 0) {
                if (dfs(graph, i, index, states, order)) {
                    cycleFound = true;
                    break;
                }
            }
        }
        
        if (cycleFound)
            return new int[0];
        else
            return order;
    }
    
    // returns if a cycle is detected
    private boolean dfs(HashMap<Integer, HashSet<Integer>> graph,
            int node, 
            int[] index,
            int[] states, 
            int[] order
            ) {
        
        states[node] = 1;
        
        if (graph.containsKey(node)) {
            HashSet<Integer> neighbors = graph.get(node);
            
            for (int neighbor: neighbors) {
                if (states[neighbor] == 1)
                    return true;
                else if (states[neighbor] == 0) {
                    if (dfs(graph, neighbor, index, states, order)) {
                        return true;
                    }
                }
            }
        }
        
        states[node] = 2;
        order[index[0]] = node;
        index[0]++;
        
        return false;
    }
    
    public static void main(String[] args) {
        SolutionDFS sol = new SolutionDFS();
        int[][] pre = {
                {2, 0},
                {2, 1}
        };
        int[] order = sol.findOrder(3, pre);
        System.out.println(Arrays.toString(order));
    }

}
