import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class SolutionB {

    class Edge {
        int x;
        int h;
        boolean isLeft;
        
        public Edge(int x, int y, boolean left) {
            this.x = x;
            this.h = y;
            this.isLeft = left;
        }
    }
    
    class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            }
            else {
                if (o1.isLeft && !o2.isLeft)
                    return -1;
                else if (!o1.isLeft && o2.isLeft)
                    return 1;
                else {
                    if (o1.isLeft)
                        return o2.h - o1.h;
                    else
                        return o1.h - o2.h;
                }
            }
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> skyline = new ArrayList<int[]>();
        
        if (buildings.length == 0)
            return skyline;
        
        List<Edge> edges = new ArrayList<Edge>();
        
        for (int i=0; i<buildings.length; i++) {
            Edge eLeft = new Edge(buildings[i][0], buildings[i][2], true);
            Edge eRight = new Edge(buildings[i][1], buildings[i][2], false);
            
            edges.add(eLeft);
            edges.add(eRight);
        }
        
        Collections.sort(edges, new EdgeComparator());
        
        // we need a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (int i=0; i<edges.size(); i++) {
            Edge e = edges.get(i);
            
            if (e.isLeft) {
                
                if (pq.isEmpty() || e.h > pq.peek()) {
                    int[] d = {e.x, e.h};
                    skyline.add(d);
                }
                
                pq.offer(e.h);
            }
            else {
                pq.remove(e.h);
                
                if (pq.isEmpty()) {
                    int[] d = {e.x, 0};
                    skyline.add(d);
                }
                else if (e.h > pq.peek()) {
                    int[] d = {e.x, pq.peek()};
                    skyline.add(d);
                }
            }
        }
        
        return skyline;
    }
    
    public static void main(String[] args) {
        int[][] buildings = {
                {1, 2, 1},
                {1, 2, 2},
                {1, 2, 3}
        };
        
        SolutionB sol = new SolutionB();
        List<int[]> skyline = sol.getSkyline(buildings);
        
        for (int[] s: skyline) {
            System.out.println(Arrays.toString(s));
        }
    }

}
