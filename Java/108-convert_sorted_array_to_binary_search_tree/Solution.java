
public class Solution {

    // convert it to a height balanced BST
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if (nums.length == 0)
            return null;
        
        return sortedArrayToBST(nums, 0, nums.length - 1);
        
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        
        int middle = low + (high-low)/2;
        
        TreeNode root = new TreeNode(nums[middle]);
        
        if (middle - 1 >= low) {
            root.left = sortedArrayToBST(nums, low, middle - 1);
        }
        
        if (middle + 1 <= high) {
            root.right = sortedArrayToBST(nums, middle + 1, high);
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        
        Solution sol = new Solution();
        TreeNode root = sol.sortedArrayToBST(nums);
        
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }

}
