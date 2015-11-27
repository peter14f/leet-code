
public class Solution {

    public boolean isBalanced(TreeNode root) {
        
        if (root == null)
            return true;
        
        int leftSubtreeHeight = getHeight(root.left);
        int rightSubtreeHeight = getHeight(root.right);
        
        if (Math.abs(leftSubtreeHeight-rightSubtreeHeight) > 1)
            return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        
        if (left >= right)
            return 1 + left;
        else
            return 1 + right;
    }
    
    public static void main(String[] args) {
        
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        
        two.left = one;
        two.right = three;
        
        Solution sol = new Solution();
        boolean b = sol.isBalanced(two);
        
        System.out.println(b);
    }

}
