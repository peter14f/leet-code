
public class Solution {

    // no duplicate exists in array nums
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        
        int foundIndex = -1;
        
        // 7123456
        // 1 2 3 4 5 6 7
        // 2 3 4 5 6 7 1
        // 3 4 5 6 7 1 2
        // 4 5 6 7 1 2 3
        // 5 6 7 1 2 3 4
        // 6 7 1 2 3 4 5
        // 7 1 2 3 4 5 6
        
        // 0 1 3 5
        // 1 3 5 0
        
        while (l <= h) {
            int m = l + (h-l)/2;
            
            if (nums[m] == target) {
                foundIndex = m;
                break;
            }
            
            // no duplicate exists in array, so the only way nums[m] == num[l]
            // is that l==m
            if (nums[m] >= nums[l]) {
                // l to m is sorted
                if (target > nums[m]) {
                    l = m + 1;
                }
                else {
                    // target is smaller than middle
                    
                    if (target == nums[l]) {
                        foundIndex = l;
                        break;
                    }
                    else if (target > nums[l]) {
                        h = m - 1;
                    }
                    else {
                        l = m + 1;
                    }
                }
            }
            else if (nums[m] < nums[l]) {
                // l to m is not sorted
                // then m to h must be sorted
                
                if (target == nums[l]) {
                    foundIndex = l;
                    break;
                }
                else if (target > nums[l]) {
                    h = m - 1;
                }
                else {
                    // smaller than middle
                    if (target < nums[m]) {
                        h = m - 1;
                        l = l + 1;
                    }
                    // bigger than middle
                    else {
                        l = m + 1;
                    }
                }
                
            }
        }
        
        return foundIndex;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3};
        Solution sol = new Solution();
        int index = sol.search(nums, 3);
        System.out.println(index);
    }
}
