import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class SolutionT {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<Integer>();
        
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode prev = null;
        
        while (cur != null || !stk.isEmpty()) {
            
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            else {
                TreeNode top = stk.peek();
                
                if (top.right != null && prev != top.right) {
                    cur = top.right;
                }
                else
                {
                    stk.pop();
                    nodes.add(top.val);
                    prev = top;
                }
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
        
        SolutionT sol = new SolutionT();
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
