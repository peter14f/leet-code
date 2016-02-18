import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SolutionA {

    public int minMeetingRooms(Interval[] intervals) {
        
        List<Integer> startTimes = new ArrayList<Integer>();
        List<Integer> endTimes = new ArrayList<Integer>();
        
        for (int i=0; i<intervals.length; i++) {
            startTimes.add(intervals[i].start);
            endTimes.add(intervals[i].end);
        }
        
        Collections.sort(startTimes);
        Collections.sort(endTimes);
        
        int i=0;
        int j=0;
        
        int maxRoomsNeeded = 0;
        int curRoomsNeeded = 0;
        
        while (i<startTimes.size() && j < endTimes.size()) {
            if (startTimes.get(i) < endTimes.get(j)) {
                curRoomsNeeded++;
                
                if (curRoomsNeeded > maxRoomsNeeded)
                    maxRoomsNeeded = curRoomsNeeded;
                
                i++;
            }
            else {
                curRoomsNeeded--;
                j++;
            }
        }
        
        return maxRoomsNeeded;
    }
    
    public static void main(String[] args) {
        Interval i1 = new Interval( 1,  8);
        Interval i2 = new Interval( 6, 20);
        Interval i3 = new Interval( 9, 16);
        Interval i4 = new Interval(13, 17);
        
        SolutionA sol = new SolutionA();
        Interval[] intervals = {i1, i2, i3, i4};
        
        int rooms = sol.minMeetingRooms(intervals);
        System.out.println(rooms);
    }

}
