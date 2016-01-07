import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

    public List<Integer> preorder(TreeNode root) {
        List<Integer> nodes = new ArrayList<Integer>();

        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        while (cur != null || !stk.isEmpty()) {
            if (cur != null) {
                nodes.add(cur.val);
                stk.push(cur);
                cur = cur.left;
            }
            else {
                TreeNode top = stk.pop();
                
                if (top.right != null) {
                    cur = top.right;
                }
                // else cur remains null
            }
        }
        
        return nodes;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        
        a.left = b;
        a.right = c;
        
        PreOrder sol = new PreOrder();
        List<Integer> nodes = sol.preorder(a);
        System.out.println(nodes);
    }

}
