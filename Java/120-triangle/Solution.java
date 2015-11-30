import java.util.ArrayList;
import java.util.List;


public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        
        if (triangle.isEmpty())
            return 0;
        
        int row = 1;
        int n = triangle.size();
        int ans = Integer.MAX_VALUE;
        
        if (n==1) {
            return triangle.get(0).get(0);
        }
        
        while (row < n) {
            List<Integer> nums = triangle.get(row);
            
            for (int i=0; i<nums.size(); i++) {
                if (i==0) {
                    nums.set(i, nums.get(i) + triangle.get(row-1).get(i));
                }
                else if (i==nums.size()-1) {
                    nums.set(i, nums.get(i) + triangle.get(row-1).get(i-1));
                }
                else {
                    if (triangle.get(row-1).get(i-1) <= triangle.get(row-1).get(i))
                        nums.set(i, nums.get(i) + triangle.get(row-1).get(i-1));
                    else
                        nums.set(i, nums.get(i) + triangle.get(row-1).get(i));
                }
                
                if (row==n-1) {
                    if (nums.get(i) < ans) {
                        ans = nums.get(i);
                    }
                }
            }
            
            row++;
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        
        triangle.add(new ArrayList<Integer>());
        triangle.add(new ArrayList<Integer>());
        
        triangle.get(0).add(1);
        triangle.get(1).add(2);
        triangle.get(1).add(3);
        
        int minSum = sol.minimumTotal(triangle);
        System.out.println(minSum);
    }

}
