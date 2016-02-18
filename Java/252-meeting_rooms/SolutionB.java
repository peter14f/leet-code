import java.util.Arrays;
import java.util.Comparator;


public class SolutionB {

    class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
    
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new IntervalComparator());
        
        for (int i=0; i<intervals.length - 1; i++) {
            Interval cur = intervals[i];
            Interval next = intervals[i+1];
            
            if (cur.end > next.start) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Interval a = new Interval(5, 10);
        Interval b = new Interval(9, 15);
        Interval c = new Interval(15, 20);
        
        Interval[] intervals = {a, b, c};
        
        SolutionB sol = new SolutionB();
        boolean can = sol.canAttendMeetings(intervals);
        
        System.out.println(can);
    }

}
