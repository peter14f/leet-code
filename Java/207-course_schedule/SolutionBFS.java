import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionBFS {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
        int[] inDegree = new int[numCourses];
        
        for (int i=0; i<prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereqCourse = prerequisites[i][1];
            
            if (graph.containsKey(course)) {
                graph.get(course).add(prereqCourse);
            }
            else {
                HashSet<Integer> courses = new HashSet<Integer>();
                courses.add(prereqCourse);
                graph.put(course, courses);
            }
        }
        
        for (HashSet<Integer> courses: graph.values()) {
            for (int course: courses) {
                inDegree[course]++;
            }
        }
        
        // courses that do not have prerequisites
        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i=0; i<numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int insertedInQ = 0;
        
        while (!q.isEmpty()) {
            int c = q.poll();
            insertedInQ++;
            
            if (graph.containsKey(c)) {
                HashSet<Integer> dependsOn = graph.get(c);
                
                for (int d: dependsOn) {
                    inDegree[d]--;
                    
                    if (inDegree[d] == 0) {
                        q.offer(d);
                    }
                }
            }
            
        }
        
        return insertedInQ == numCourses;
    }
    
    public static void main(String[] args) {
        SolutionBFS sol = new SolutionBFS();
        int[][] p = {{1, 0},{0, 1}};
        
        boolean canFinish = sol.canFinish(2, p);
        
        System.out.println(canFinish);
    }

}
