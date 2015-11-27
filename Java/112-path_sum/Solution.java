
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        
        if (root == null)
            return false;
        
        sum = sum - root.val;
        
        if (root.left == null && root.right == null) {
            // leaf node
            return sum == 0;
        }
        
        boolean left = false;
        
        if (root.left != null)
            left = hasPathSum(root.left, sum);
        
        if (left)
            return true;
        
        boolean right = false;
        
        if (root.right != null)
            right = hasPathSum(root.right, sum);
        
        return right;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(2);
        TreeNode g = new TreeNode(13);
        TreeNode h = new TreeNode(4);
        TreeNode i = new TreeNode(1);
        
        a.left = b;
        a.right = c;
        b.left = d;
        d.left = e;
        d.right = f;
        
        c.left = g;
        c.right = h;
        h.right = i;
        
        Solution sol = new Solution();
        boolean hasPath = sol.hasPathSum(a, 23);
        System.out.println(hasPath);
    }

}
