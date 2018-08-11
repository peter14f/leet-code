import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    /**
     * equations = [ ["a", "b"], ["b", "c"] ],
     * values = [2.0, 3.0],
     * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
     */
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        int n = values.length;
        for (int i=0; i<n; i++) {
            String[] pair = equations[i];
            double k = values[i];

            String nodeA = pair[0];
            String nodeB = pair[1];

            if (!graph.containsKey(nodeA)) {
                graph.put(nodeA, new HashMap<>());
            }
            graph.get(nodeA).put(nodeB, k);

            if (!graph.containsKey(nodeB)) {
                graph.put(nodeB, new HashMap<>());
            }
            graph.get(nodeB).put(nodeA, 1/k);
        }
        //System.out.println(graph);

        int m = queries.length;
        double[] ans = new double[m];

        for (int i=0; i<m; i++) {
            String[] query = queries[i];
            String a = query[0];
            String b = query[1];

            if (!graph.containsKey(a) || !graph.containsKey(b)) {
                ans[i] = -1.0;
                continue;
            }
            
            if (a.equals(b)) {
                ans[i] = 1.0;
                continue;
            }

            List<String> path = new ArrayList<>();
            path.add(a);
            dfs(graph, a, path, new HashSet<>(), b);

            if (path.get(path.size() - 1).equals(b)) {
                //System.out.println(path);
                double q = 1.0;
                String cur = a;
                for (int j=1; j<path.size(); j++) {
                    String neighbor = path.get(j);
                    //System.out.println("cur=" + cur + " n=" + neighbor);
                    q = q * graph.get(cur).get(neighbor);
                    cur = neighbor;
                }
                ans[i] = q;
            } else {
                ans[i] = -1.0;
            }
        }

        return ans;
    }
    
    private void dfs(Map<String, Map<String, Double>> graph, String cur, 
            List<String> path, Set<String> visited, String target) {
        
        Map<String, Double> neighbors = graph.get(cur);

        if (neighbors.containsKey(target)) {
            path.add(target);
            return;
        }

        for (String neighbor : neighbors.keySet()) {
            if (visited.contains(neighbor)) {
                continue;
            }
            path.add(neighbor);
            visited.add(neighbor);
            dfs(graph, neighbor, path, visited, target);
            if (path.get(path.size()-1).equals(target)) {
                return;
            }
            path.remove(path.size() - 1);
            visited.remove(neighbor);
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] equations = {
                {"x1", "x2"},
                {"x2", "x3"},
                {"x3", "x4"},
                {"x4", "x5"}
        };
        double[] values = {
                3.0,
                4.0,
                5.0,
                6.0
        };
        String[][] queries = {
                {"x1", "x5"},
                {"x5", "x2"},
                {"x2", "x4"},
                {"x2", "x2"},
                {"x2", "x9"},
                {"x9", "x9"}
        };
        double[] ans = sol.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(ans));
    }

}
