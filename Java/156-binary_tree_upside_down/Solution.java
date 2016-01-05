
public class Solution {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)
            return null;
        
        if (root.left == null && root.right == null)
            return root;
        
        TreeNode origLeft = root.left;
        TreeNode treeRoot = upsideDownBinaryTree(origLeft);
        origLeft.right = root;
        origLeft.left = root.right;
        root.left = null;
        root.right = null;
        
        return treeRoot;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.left = b;
        TreeNode r = sol.upsideDownBinaryTree(a);
        preOrder(r);
    }

    private static void preOrder(TreeNode n) {
        if (n==null)
            return;
        
        System.out.println(n.val);
        preOrder(n.left);
        preOrder(n.right);
    }
}
