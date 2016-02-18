import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;


public class Solution {

    class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            if (o1.time < o2.time)
                return -1;
            else if (o1.time > o2.time)
                return 1;
            else {
                if (o1.isStart && !o2.isStart)
                    return 1;
                else if (!o1.isStart && o2.isStart)
                    return -1;
                else
                    return 0;
            }
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        List<Edge> edges = new ArrayList<Edge>();
        
        for (int i=0; i<intervals.length; i++) {
            Edge e1 = new Edge(intervals[i].start, true);
            Edge e2 = new Edge(intervals[i].end, false);
            edges.add(e1);
            edges.add(e2);
        }
        
        Collections.sort(edges, new EdgeComparator());
        
        int maxRoomNeeded = 0;
        
        Stack<Edge> rooms = new Stack<Edge>();
        
        for (int i=0; i<edges.size(); i++) {
            Edge cur = edges.get(i);
            
            if (cur.isStart) {
                rooms.push(cur);
                if (rooms.size() > maxRoomNeeded)
                    maxRoomNeeded = rooms.size();
            }
            else {
                rooms.pop();
            }
        }
        
        return maxRoomNeeded;
    }
    
    public static void main(String[] args) {
        Interval i1 = new Interval(  1,  8);
        Interval i2 = new Interval(  6, 20);
        Interval i3 = new Interval(  9, 16);
        Interval i4 = new Interval( 13, 17);
        
        Solution sol = new Solution();
        Interval[] intervals = {i1, i2, i3, i4};
        
        int numRoomsNeeded = sol.minMeetingRooms(intervals);
        System.out.println(numRoomsNeeded);
    }

}
