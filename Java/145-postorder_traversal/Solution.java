import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution {

    /* This is the solution that I came up with
     * which alters the structure of the input
     * binary tree
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        TreeNode cur = root;
        
        while (cur != null || !stk.isEmpty()) {
            if (cur == null) {
                cur = stk.pop();
                
                if (cur.left == null && cur.right == null) {
                    nodes.add(cur.val);
                    cur = null;
                }
                else if (cur.right != null) {
                    TreeNode origRight = cur.right;
                    stk.push(cur);
                    
                    // unlink to right child
                    cur.right = null;
                    cur = origRight;
                }
            }
            else {
                stk.push(cur);
                TreeNode origLeft = cur.left;
                cur.left = null;
                cur = origLeft;
            }
        }
        
        return nodes;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        
        Solution sol = new Solution();
        List<Integer> nodes = sol.postorderTraversal(a);
        System.out.println(nodes);
        
        sol.inorderTraversal(a);
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null)
            return;
        
        inorderTraversal(node.left);
        System.out.println(node.val);
        inorderTraversal(node.right);
    }
    
}
