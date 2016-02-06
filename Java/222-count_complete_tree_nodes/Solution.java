
public class Solution {

    public int countNodes(TreeNode root) {
        if (root==null)
            return 0;
        
        int leftSubtreeH = treeHeight(root.left, true) + 1;
        int rightSubtreeH = treeHeight(root.right, false) + 1;
        
        if (leftSubtreeH == rightSubtreeH) {
            return (1 << leftSubtreeH) -1;
        }
        else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    private int treeHeight(TreeNode node, boolean left) {
        if (node == null)
            return 0;
        
        int h = 0;
        while (node != null) {
            h++;
            if (left)
                node = node.left;
            else
                node = node.right;
        }
        
        return h;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        
        a.left = b;
        a.right = c;
        b.left = d;
        
        Solution sol = new Solution();
        int cnt = sol.countNodes(a);
        System.out.println(cnt);
    }

}
