public class Solution {

    class UnionFind {
        int[] parent; // parent[i] is the parent of i
        int size;
        
        public UnionFind(int n) {
            parent = new int[n];
            
            for (int i=0; i<n; i++)
                parent[i] = i;
            
            size = n;
        }
        
        public void union(int a, int b) {
            while (a != parent[a]) {
                a = parent[a];
            }
            
            while (b != parent[b]) {
                b = parent[b];
            }
            
            int minBlob = Math.max(a, b);
            parent[a] = minBlob;
            parent[b] = minBlob;
            
            if (a != b) {
                size--;
            }
        }
        
        public int getSize() {
            return size;
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        
        UnionFind uf = new UnionFind(n);
        
        for (int i=0; i<edges.length; i++) {
            // a -- b
            int a = edges[i][0];
            int b = edges[i][1];
            
            uf.union(a, b);
        }
        
        return uf.getSize();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] edges = {
                {0, 1}
        };
        
        int num = sol.countComponents(3, edges);
        
        System.out.println(num);
    }

}
