import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Solution {

    class IntervalComp implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            
            if (o1.start < o2.start) {
                return -1;
            }
            else if (o1.start > o2.start) {
                return 1;
            }
            else {
                if (o1.end < o2.end) 
                    return -1;
                else if (o1.end > o2.end)
                    return 1;
                else
                    return 0;
            }
        }
        
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComp());
        
        List<Interval> ans = new ArrayList<Interval>();
        Interval top = null;
        for (int i=0; i<intervals.size(); i++) {
            Interval cur = intervals.get(i);
            
            if (top==null) {
                ans.add(cur);
                top = cur;
            }
            else {
                if (top.end >= cur.start) {
                    top.end = Math.max(top.end, cur.end);
                }
                else {
                    // cannot be merged
                    ans.add(cur);
                    top = cur;
                }
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Interval a1 = new Interval(1, 2);
        Interval a2 = new Interval(3, 6);
        Interval a3 = new Interval(8, 10);
        Interval a4 = new Interval(15, 18);
        
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(a4);
        intervals.add(a2);
        intervals.add(a3);
        intervals.add(a1);
        
        Solution sol = new Solution();
        List<Interval> ans = sol.merge(intervals);
        
        for (Interval i: ans) {
            System.out.println(i.start + ", " + i.end);
        }
    }

}
