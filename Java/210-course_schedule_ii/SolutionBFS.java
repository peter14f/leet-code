import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class SolutionBFS {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
        int[] order = new int[numCourses]; 
        int[] inDegree = new int[numCourses];
        
        // build the graph first
        for (int i=0; i<prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int dependOn = prerequisites[i][1];
            
            if (graph.containsKey(course)) {
                graph.get(course).add(dependOn);
            }
            else {
                HashSet<Integer> dependsOn = new HashSet<Integer>();
                dependsOn.add(dependOn);
                graph.put(course, dependsOn);
            }
        }
        
        for (HashSet<Integer> courses: graph.values()) {
            for (int course: courses) {
                inDegree[course]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i=0; i<numCourses; i++) {
            if (inDegree[i] == 0) {
                // source node
                q.offer(i);
            }
        }
        
        int index = numCourses-1;
        int nodeInserted = 0;
        
        while (!q.isEmpty()) {
            int curSourceNode = q.poll();
            nodeInserted++;
            
            order[index] = curSourceNode;
            index--;
            
            if (graph.containsKey(curSourceNode)) {
                HashSet<Integer> neighbors = graph.get(curSourceNode);
                
                for (int course: neighbors) {
                    inDegree[course]--;
                    if (inDegree[course] == 0) {
                        q.add(course);
                    }
                }
            }
        }
        
        if (nodeInserted < numCourses)
            return new int[0];
        
        return order;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
