
public class Solution {

    /* the given nodes p and q are in the binary tree */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null)
            return null;
        
        if (root == p || root == q) {
            // since we're guaranteed that the other node must also be in the binary tree
            return root;
        }
        
        boolean pInLeft = findNode(root.left, p);
        boolean qInLeft = findNode(root.left, q);
        
        if (pInLeft && qInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (pInLeft && !qInLeft) {
            return root;
        }
        else if (!pInLeft && qInLeft) {
            return root;
        }
        else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
    
    private boolean findNode(TreeNode root, TreeNode node) {
        
        if (root == null)
            return false;
        
        if (root == node)
            return true;
        
        if (findNode(root.left, node)) {
            return true;
        }
        else {
            return findNode(root.right, node);
        }
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(4);
        TreeNode h = new TreeNode(0);
        TreeNode i = new TreeNode(8);
        
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right = g;
        c.left = h;
        c.right = i;
        
        Solution sol = new Solution();
        TreeNode n = sol.lowestCommonAncestor(a, a, i);
        System.out.println(n.val);
    }

}
