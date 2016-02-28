import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SolutionB {

    public int maxSubArrayLen(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int maxSize = 0;
        
        for (int i=0; i<prefixSum.length; i++) {
            if (i==0)
                prefixSum[i] = nums[i];
            else
                prefixSum[i] = prefixSum[i-1] + nums[i];
            
            if (!map.containsKey(prefixSum[i]))
                map.put(prefixSum[i], new ArrayList<Integer>());
            
            map.get(prefixSum[i]).add(i);
        }
        
        //System.out.println(map);
        
        for (int j=0; j<nums.length; j++) {
            
            int target = prefixSum[j] - k;
            
            if (target==0) {
                if (j + 1 > maxSize)
                    maxSize = j+1;
            }
            
            //System.out.println("j=" + j + " t=" + target);
            
            if (map.containsKey(target)) {
                List<Integer> prevI = map.get(target);
                
                for (int iMinusOne: prevI) {
                    
                    //System.out.println(" iMinus1=" + iMinusOne + " i=" + (iMinusOne+1));
                    
                    int i = iMinusOne + 1;
                    if (i > j)
                        continue;
                    
                    if (j-i+1 > maxSize)
                        maxSize = j-i+1;
                }
            }
        }
        
        return maxSize;
    }
    
    public static void main(String[] args) {
        SolutionB sol = new SolutionB();
        int[] nums = {-2, -1, 2, 1};
        int maxSize = sol.maxSubArrayLen(nums, 1);
        System.out.println("maxSize=" + maxSize);
    }

}
