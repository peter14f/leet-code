import java.util.HashMap;


public class Solution {

    public int maxPoints(Point[] points) {
        
        if(points.length == 0||points == null) 
            return 0;  
        
        int n = points.length;
        
        if(n <= 2) 
            return n;
        
        // the final max value, at least 2
        int ans = 2;
        
        for (int i=0; i<n; i++) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            Point base = points[i];
            int dupCnt = 0;
            
            for (int j=0; j<n; j++) {
                if (i==j)
                    continue;
                
                Point a = points[j];
                
                if (a.x == base.x && a.y == base.y) {
                    dupCnt++;
                    continue;
                }
                
                double slope = 0;
                
                if (a.x == base.x) {
                    slope = Float.MAX_VALUE;
                }
                else {
                    slope = (a.y - base.y);
                    slope = slope / (a.x - base.x);
                }
                
                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope)+1);
                }
                else {
                    map.put(slope, 2);
                }
            }
            
            // base point itself
            // even if all points are duplicates of base, we will get the right ans
            int localMax = 1;
            
            for (double s: map.keySet()) {
                if (map.get(s) > localMax) {
                    localMax = map.get(s);
                }
            }
            
            // duplicated points
            localMax += dupCnt;
            
            if (localMax > ans)
                ans = localMax;
        } // base
        
        return ans;
    }
    
    public static void main(String[] args) {

        
        // [84,250],[0,0],[1,0],[0,-70],[0,-70],[1,-1],[21,10],[42,90],[-42,-230]
        // [[1,1],[1,1],[1,1]]
        Point a = new Point(1, 1);
        Point b = new Point(1, 1);
        Point c = new Point(1, 1);
        
        Solution sol = new Solution();
        
        Point[] arr = {a, b, c};
        int max = sol.maxPoints(arr);
        
        System.out.println(max);
    }

}
