
public class SolutionB {

    // this is bottom up approach that takes O(n) time
    /* the given nodes p and q are in the binary tree */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        
        if (root == p || root == q) {
            return root;
        }
        
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        
        if (l != null && r != null) {
            // found one in left subtree, found one in right subtree
            return root;
        }
        else if (l != null) {
            // found both in right subtree
            return l;
        }
        else if (r != null) {
            // found both in left subtree
            return r;
        }
        
        return null;
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
        
        SolutionB sol = new SolutionB();
        TreeNode ans = sol.lowestCommonAncestor(a, d, g);
        System.out.println(ans.val);
    }

}
