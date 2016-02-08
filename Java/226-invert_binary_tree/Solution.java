
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        
        invertTree(root.left);
        invertTree(root.right);
        
        TreeNode oldLeft = root.left;
        root.left = root.right;
        root.right = oldLeft;
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        
        a.left = b;
        a.right = c;
        
        //System.out.println(a.val);
        //System.out.println(a.left.val);
        //System.out.println(a.right.val);
        
        Solution sol = new Solution();
        
        TreeNode k = sol.invertTree(a);
        
        System.out.println(k.left.val);
        
    }

}
