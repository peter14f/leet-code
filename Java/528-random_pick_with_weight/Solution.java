import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution {
    int sum;
    Random rand;
    List<Range> l;
    
    public Solution(int[] w) {
        this.l = new ArrayList<>();
        int prev = 0;

        for (int i=0; i<w.length; i++) {
            this.sum += w[i];
            this.l.add(new Range(prev, prev + w[i] - 1));
            prev = this.sum;
        }

        System.out.println(this.l);
        this.rand = new Random();
    }

    public int pickIndex() {
        int x = this.rand.nextInt(this.sum);
        int left = 0;
        int right = this.l.size();

        while (left <= right) {
            int m = left + (right - left) / 2;
            Range r = this.l.get(m);
            
            if (x >= r.min && x <= r.max) {
                return m;
            } else if (x > r.max) {
                left = m + 1;
            } else if (x < r.min){
                right = m - 1;
            }
        }
        
        return -1;
    }

    static class Range {
        int min;
        int max;
        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }
        
        @Override
        public String toString() {
            return "(" + this.min + ", " + this.max + ")";
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution(new int[] {1,1,1});
        
    }

}
