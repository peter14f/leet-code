import java.util.TreeMap;

public class SolutionB {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // key is the value stored in nums, value is the last seen index
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        for (int i=0; i<nums.length; i++) {
            Integer floorKey = map.floorKey(nums[i]);
            
            while (floorKey != null) {
                
                long diff = (long)nums[i] - floorKey;
                
                if (diff > t) 
                    break;
                
                if (i - map.get(floorKey) <= k) {
                    return true;
                }
                
                int nextSmaller = floorKey - 1;
                
                if (nextSmaller > floorKey)
                    break;
                
                floorKey = map.floorKey(floorKey-1);
            }
            
            int nextBig = nums[i]+1;
            
            if (nextBig < nums[i])
                return false;
            
            Integer ceilingKey = map.ceilingKey(nums[i] + 1);
            
            while (ceilingKey != null) {
                
                long diff = (long)ceilingKey - nums[i];
                
                if (diff > t)
                    break;
                
                if (i - map.get(ceilingKey) <= k) {
                    return true;
                }
                
                nextBig = ceilingKey+1;
                if (nextBig < ceilingKey)
                    break;
                
                ceilingKey = map.ceilingKey(ceilingKey+1);
            }
            
            map.put(nums[i], i);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int nums[] = {-1,2147483647};
        SolutionB sol = new SolutionB();
        boolean ans = sol.containsNearbyAlmostDuplicate(nums, 1, 2147483647);
        System.out.println(ans);
    }

}
