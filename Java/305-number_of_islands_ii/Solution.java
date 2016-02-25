import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Solution {

    class UnionFind {
        int blobs;
        HashMap<Integer, Integer> map;
        
        public UnionFind() {
            blobs = 0;
            map = new HashMap<Integer, Integer>();
        }
        
        private void add(int x) {
            map.put(x, x);
            blobs++;
        }
        
        public int find(int x) {
            while (map.get(x) != x) {
                x = map.get(x);
            }
            
            return x;
        }
        
        public void union(int x, int y) {
            while (map.get(x) != x) {
                x = map.get(x);
            }
            
            while (map.get(y) != y) {
                y = map.get(y);
            }
            
            map.put(x, Math.min(x, y));
            map.put(y, Math.min(x, y));
            
            if (x != y)
                blobs--;
        }
        
        public int getSize() {
            return blobs;
        }
    }
    
    // count the number of islands after each add land operation
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> numIslands = new ArrayList<Integer>();
        
        int[][] blob = new int[m][n];
        int nextBlobNum = 1;
        // HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();
        UnionFind uf = new UnionFind();
        
        for (int i=0; i<positions.length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
            
            if (blob[row][col] == 0) {
                int upBlob = Integer.MAX_VALUE;
                int downBlob = Integer.MAX_VALUE;
                int leftBlob = Integer.MAX_VALUE;
                int rightBlob = Integer.MAX_VALUE;
                
                if (row-1 >= 0 && blob[row-1][col] > 0)
                    upBlob = uf.find(blob[row-1][col]);
                if (row + 1 < m && blob[row+1][col] > 0)
                    downBlob = uf.find(blob[row+1][col]);
                if (col-1 >= 0 && blob[row][col-1] > 0)
                    leftBlob = uf.find(blob[row][col-1]);
                if (col+1 < n && blob[row][col+1] > 0)
                    rightBlob = uf.find(blob[row][col+1]);
                
                int minLabel = Math.min(upBlob, Math.min(downBlob, Math.min(leftBlob, rightBlob)));
                
                if (minLabel == Integer.MAX_VALUE) {
                    blob[row][col] = nextBlobNum;
                    uf.add(nextBlobNum);
                    //lookup.put(nextBlobNum, nextBlobNum);
                    nextBlobNum++;
                }
                else {
                    blob[row][col] = minLabel;
                    
                    if (upBlob != Integer.MAX_VALUE)
                        uf.union(upBlob, minLabel);
                    if (downBlob != Integer.MAX_VALUE)
                        uf.union(downBlob, minLabel);
                    if (rightBlob != Integer.MAX_VALUE)
                        uf.union(rightBlob, minLabel);
                    if (leftBlob != Integer.MAX_VALUE)
                        uf.union(leftBlob, minLabel);
                }
                numIslands.add(uf.getSize());
            } 
        } // for
        
        return numIslands;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] positions = {
                {8,5},
                {8,0},
                {3,4},
                {0,3},
                {1,0},
                {5,4},
                {0,8},
                {5,7},
                {0,6},
                {6,2},
                {4,7},
                {2,7},
                {8,7},
                {8,6},
                {5,3},
                {2,3},
                {3,5},
                {3,1},
                {0,2},
                {8,8},
                {6,4},
                {0,1},
                {0,4},
                {7,5},
                {3,0}
        };
        
        List<Integer> numIslands = sol.numIslands2(9, 9, positions);
        
        System.out.println(numIslands);
    }

}
