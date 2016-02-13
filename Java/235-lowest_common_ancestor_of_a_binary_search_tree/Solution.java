
public class Solution {

    /* the problem statement states that p and q are
     * in the BST. So we do not need to check again  
     * that p and q are in the BST
     */
    public TreeNode lowestCommonAncestor(
            TreeNode root, 
            TreeNode p, 
            TreeNode q) {
        
        if (root == null)
            return null;
        
        if (p.val <= root.val && q.val >= root.val) {
            return root;
        }
        else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        TreeNode a = new TreeNode(6);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(0);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(3);
        TreeNode g = new TreeNode(5);
        TreeNode h = new TreeNode(7);
        TreeNode j = new TreeNode(9);
        
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right = g;
        c.left = h;
        c.right = j;
        
        TreeNode lca = sol.lowestCommonAncestor(a, d, e);
        System.out.println(lca.val);
    }

}
