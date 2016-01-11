
public class Solution {

    class Bucket {
        int min;
        int max;
        
        public Bucket() {
            this.min = -1;
            this.max = -1;
        }
    }
    
    public int maximumGap(int[] nums) {
        int n = nums.length;
        
        if (n < 2)
            return 0;
        
        int max = nums[0];
        int min = nums[0];
        
        for (int i=0; i<n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        double delta = max-min;
        delta = delta/(n-1);
        
        Bucket[] buckets = new Bucket[n-1];
        for (int k=0; k<buckets.length; k++)
            buckets[k] = new Bucket();
        
        for (int i=0; i<n; i++) {
            if (nums[i] == min || nums[i] == max)
                continue;
            
            int k = (int) ((nums[i] - min)/delta);
            
            if (buckets[k].min == -1 || nums[i] < buckets[k].min)
                buckets[k].min = nums[i];
            
            if (buckets[k].max == -1 || nums[i] > buckets[k].max)
                buckets[k].max = nums[i];
        }
        
        int maxGap = 0;
        int a = min;
        boolean inGap = false;
        
        for (int k=0; k<buckets.length; k++) {
            if (buckets[k].min ==-1 && buckets[k].max == -1) {
                if (!inGap)
                    inGap = true;
            }
            else {
                if (inGap) {
                    int gap = buckets[k].min - a;
                    if (gap > maxGap)
                        maxGap = gap;
                
                    inGap = false;
                }
                a = buckets[k].max;
            }
        }
        
        if (inGap) {
            int gap = max - a;
            if (gap > maxGap)
                maxGap = gap;
        }
        
        return maxGap;
    }
    
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9999999};
        Solution sol = new Solution();
        int g = sol.maximumGap(nums);
        System.out.println(g);
    }

}
