
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        
        if (left==null)
            return right==null;
        
        if (right==null)
            return left==null;
        
        if (left.val != right.val)
            return false;
        
        boolean out = isSymmetric(left.left, right.right);
        
        if (!out)
            return false;
        
        return isSymmetric(left.right, right.left);
    }
    
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        
        one.left = b;
        one.right = c;
        
        Solution sol = new Solution();
        boolean ans = sol.isSymmetric(one);
        
        System.out.println(ans);
    }

}
