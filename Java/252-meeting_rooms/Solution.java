
public class Solution {

    public boolean canAttendMeetings(Interval[] intervals) {
        
        for (int i=0; i<intervals.length; i++) {
            
            for (int j=0; j<intervals.length; j++) {
                if (i==j)
                    continue;
                
                if (intervals[i].start >= intervals[j].start &&
                        intervals[i].start < intervals[j].end) {
                    return false;
                }
            }
            
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Interval a = new Interval(5, 10);
        Interval b = new Interval(5, 10);
        Interval c = new Interval(15, 20);
        
        Interval[] intervals = {a, b, c};
        
        Solution sol = new Solution();
        boolean possible = sol.canAttendMeetings(intervals);
        System.out.println(possible);
        
        
    }

}
