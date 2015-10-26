import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Interval start = null;
        Interval end = null;
        for (int i=0; i<intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (overlaps(newInterval, cur)) {
                if (start == null) {
                    start = cur;
                }
                end = cur;
            }
        }
        
        List<Interval> ans = new ArrayList<Interval>();
        
        if (start == null) {
            boolean inserted = false;
            for (int i=0; i<intervals.size(); i++) {
                Interval cur = intervals.get(i);
                if (!inserted && cur.start >= newInterval.start) {
                    ans.add(newInterval);
                    inserted = true;
                }
                ans.add(cur);
            }
            if (!inserted) {
                ans.add(newInterval);
            }
        }
        else {
            Interval newStart = null;
            for (int i=0; i<intervals.size(); i++) {
                Interval cur = intervals.get(i);
                if (cur==start) {
                    newStart = new Interval(Math.min(cur.start, newInterval.start), 
                                            Math.max(cur.end, newInterval.end));
                    ans.add(newStart);
                }
                
                if (cur==end) {
                    newStart.end = Math.max(newStart.end, cur.end);
                    newStart = null;
                }
                else if (newStart!=null) {
                    newStart.end = Math.max(newStart.end, cur.end);
                }
                else {
                    ans.add(cur);
                }
            }
        }
        
        return ans;
    }

    private boolean overlaps(Interval i1, Interval i2) {
        if (i1.start < i2.start) {
            if (i1.end < i2.start)
                return false;
            else
                return true;
        }
        else if (i2.start < i1.start) {
            if (i2.end < i1.start)
                return false;
            else
                return true;
        }
        else {
            return true;
        }
    }
    
    public static void main(String[] args) {
        Interval a1 = new Interval(1, 2);
        Interval a2 = new Interval(3, 5);
        Interval a3 = new Interval(6, 7);
        Interval a4 = new Interval(8, 10);
        Interval a5 = new Interval(12, 16);
        
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(a1);
        intervals.add(a2);
        intervals.add(a3);
        intervals.add(a4);
        intervals.add(a5);
        
        Interval newInterval = new Interval(4, 9);
        
        Solution sol = new Solution();
        List<Interval> ans = sol.insert(intervals, newInterval);
        
        for (Interval i: ans) {
            System.out.println(i.start + ", " + i.end);
        }
    }

}
