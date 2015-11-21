
public class Solution {

    public boolean isValidBST(TreeNode root) {
        
        if (root == null)
            return true;
        
        return isValidBST(root.left, null, root) && 
                isValidBST(root.right, root, null);
    }
    
    private boolean isValidBST(TreeNode cur, TreeNode min, TreeNode max) {
        
        if (cur==null)
            return true;
        
        if (min != null && cur.val <= min.val)
            return false;
        
        if (max != null && cur.val >= max.val)
            return false;
        
        // left subBST must be greater than min and smaller than cur
        // right subBST must be greater than cur and smaller than max
        return isValidBST(cur.left, min, cur) && 
                isValidBST(cur.right, cur, max);
    }
    
    public static void main(String[] args) {
        
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(20);
        
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        
        Solution sol = new Solution();
        boolean validBST = sol.isValidBST(a);
        
        System.out.println(validBST);
    }

}
