import java.util.HashMap;
import java.util.HashSet;


public class SolutionDFS {

    public boolean canFinish(int numCourses, int[][] prerequisites) {        
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
        
        for (int i=0; i<prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereqCourse = prerequisites[i][1];
            
            if (graph.containsKey(course)) {
                graph.get(course).add(prereqCourse);
            }
            else {
                HashSet<Integer> prereqs = new HashSet<Integer>();
                prereqs.add(prereqCourse);
                graph.put(course, prereqs);
            }
        }
        
        /* 0 - new node that has not been looked at yet
         * 1 - checking, meaning that we're in the process of checking all paths from vertex 
         * 2 - visited, meaning we've checked all paths from this vertex do not result in a cycle
         */
        int[] visited = new int[numCourses];
        
        
        for (int i=0; i<numCourses; i++) {
            
            if (visited[i] == 0) {
                if (hasCycle(graph, visited, i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /* this helper method should be called only when
     * visited[node] is 0
     */
    private boolean hasCycle(HashMap<Integer, HashSet<Integer>> graph,
            int[] visited,
            int node) {
        
        visited[node] = 1;
        
        if (graph.containsKey(node)) {
            HashSet<Integer> neighbors = graph.get(node);
            
            for (int v: neighbors) {
                /*  ignore if state is 2
                 *  call hasCycle if state is 0
                 *  return false if state is 1
                 */
                if (visited[v] == 0) {
                    if (hasCycle(graph, visited, v))
                        return true;
                }
                else if (visited[v] == 1) {
                    return true;
                }
            }
            
        }
        
        visited[node] = 2;
        return false;
    }
    
    public static void main(String[] args) {
        
    }

}
