import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
    
    class Pair {
        int x; // index of the middle number of the triple
        int y; // index of the large number of the triple
    }
    
    // passed OJ on 09/10/2015
    public List<List<Integer>> threeSum_3(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for (int i=0; i<nums.length - 2; i++) {
            int smallNum = nums[i];
                    
            if (i-1 >= 0 && smallNum == nums[i-1])
                continue;
            
            List<Pair> list = getSum2(-smallNum, nums, i);
            for (Pair p : list) {
                List<Integer> triple = new ArrayList<Integer>();
                triple.add(smallNum);
                triple.add(nums[p.x]);
                triple.add(nums[p.y]);
                ans.add(triple);
            }
        }
        
        return ans;
    }
    
    private List<Pair> getSum2(int target, int[] nums, int toSkip) {
        
        int left = toSkip+1;
        int right = nums.length - 1;
        List<Pair> ans = new ArrayList<Pair>();        
        
        while (left < right) {
            
            int sum = nums[left] + nums[right];
            
            if (sum == target) {
                Pair p = new Pair();
                p.x = left;
                p.y = right;
                ans.add(p);
                
                left++;
                
                while (left < nums.length && nums[left] == nums[p.x])
                    left++;
                
                right--;
                
                while (right >= 0 && nums[right] == nums[p.y])
                    right--;
            }
            else if (sum > target) {
                right--;
            }
            else {
                left++;
            }
        }
        
        return ans;
    }
    
    public List<List<Integer>> threeSum_2(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        // i is the smallest number in the solution tuple
        for (int i=0; i<nums.length-2; i++) {
            
            int left = i+1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum==0) {
                    while (left + 1 < right && nums[left]==nums[left+1]) {
                        left++;
                    }
                    while (right -1 > left && nums[right]==nums[right-1]) {
                        right--;
                    }
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(nums[i]);
                    newList.add(nums[left]);
                    newList.add(nums[right]);
                    ans.add(newList);
                    left++;
                    right--;
                }
                else if (sum > 0) {
                    right--;
                }
                else {
                    left++;
                }
            }
            
        }
        
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for (int i=0; i<nums.length; i++) {
            int left = 0;
            int right = nums.length - 1;
            
            while (left < right) {                
                if (left==i) {
                    left++;
                    continue;
                }
                else if (right==i) {
                    right--;
                    continue;
                }
                
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum==0) {
                    List<Integer> newList = new ArrayList<Integer>();
                    if (i < left) {
                        // i left right
                        newList.add(nums[i]);
                        newList.add(nums[left]);
                        newList.add(nums[right]);
                    }
                    else if (i < right) {
                        // left i right
                        newList.add(nums[left]);
                        newList.add(nums[i]);
                        newList.add(nums[right]);
                    }
                    else {
                        // left right i
                        newList.add(nums[left]);
                        newList.add(nums[right]);
                        newList.add(nums[i]);
                    }
                    ans.add(newList);
                    right--;
                    left++;
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            } // while left < right
        } // for i
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        // -4, -1, -1, 0 , 1, 2
        
        //int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        //-5, -5, -4, -4, -4, -2, -2, -2, 0, 0, 0, 1, 1, 3, 4, 4
        
        Solution sol = new Solution();
        List<List<Integer>> ans = sol.threeSum_3(nums);
        
        System.out.println(ans);
    }

}
