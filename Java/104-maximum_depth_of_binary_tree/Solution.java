
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        int leftChildHeight = maxDepth(root.left);
        int rightChildHeight = maxDepth(root.right);
        
        if (leftChildHeight >= rightChildHeight)
            return 1 + leftChildHeight;
        else
            return 1 + rightChildHeight;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        
        a.left = b;
        b.left = c;
        
        Solution sol = new Solution();
        int height = sol.maxDepth(a);
        System.out.println(height);
    }

}
