import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    
    // N students -> N nodes
    // BFS?
    public int findCircleNum(int[][] M) {
        int N = M.length;
        if (N == 0)
            return 0;
        boolean[] visited = new boolean[N];
        
        int numCircles = 0;
        for (int i=0; i<N; i++) {
            if (visited[i]) {
                continue;
            }
            
            numCircles++;
            bfsVisitAllFriendsInCircle(M, N, visited, i);
        }
        
        return numCircles;
    }
    
    private void bfsVisitAllFriendsInCircle(int[][] graph, int N, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int student = q.poll();
            int[] directFriends = graph[student];
            
            for (int i=0; i<N; i++) {
                if (directFriends[i]!= 1 || visited[i]) {
                    continue;
                }
                q.offer(i);
                visited[i] = true;
            }
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] M = {
                {1}
        };
        int ans = sol.findCircleNum(M);
        System.out.println(ans);
    }

}
