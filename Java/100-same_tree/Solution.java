
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if (p==null)
            return q==null;
        
        if (q==null)
            return p==null;
        
        // at this point, we're sure that p and q are not null
        if (p.val != q.val)
            return false;
        
        boolean leftSame = isSameTree(p.left, q.left);
        
        if (!leftSame)
            return false;
        
        return isSameTree(p.right, q.right);
    }
    
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        
        a1.left = a2;
        a1.right = a3;
        
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(4);
        
        b1.left = b2;
        b1.right = b3;
        
        Solution sol = new Solution();
        boolean same = sol.isSameTree(a1, b1);
        System.out.println(same);
    }

}
