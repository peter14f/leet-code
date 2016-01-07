import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    public List<Integer> inorder(TreeNode root) {
        List<Integer> nodes = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        TreeNode cur = root;
        
        while (cur != null || !stk.isEmpty()) {
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            else {
                TreeNode top = stk.pop();
                nodes.add(top.val);
                
                if (top.right != null) {
                    cur = top.right;
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
        
        a.left = b;
        a.right = c;
        c.right = d;
        
        InOrder sol = new InOrder();
        List<Integer> nodes = sol.inorder(a);
        System.out.println(nodes);
    }

}
