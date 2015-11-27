
public class Solution {

    // The minimum depth is the number of nodes along the shortest 
    //path from the root node down to the nearest leaf node.
    public int minDepth(TreeNode root) {
        if (root==null)
            return 0;
        
        if (root.left == null && root.right == null) {
            // I'm a leaf node
            return 1;
        }
        
        int leftChildDepth = Integer.MAX_VALUE;
        int rightChildDepth = Integer.MAX_VALUE;
        
        if (root.left != null) {
            leftChildDepth = minDepth(root.left);
        }
        
        if (root.right != null) {
            rightChildDepth = minDepth(root.right);
        }
        
        if (leftChildDepth <= rightChildDepth)
            return leftChildDepth + 1;
        else
            return rightChildDepth + 1;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        
        Solution sol = new Solution();
        int depth = sol.minDepth(a);
        
        System.out.println(depth);
    }

}
