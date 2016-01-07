import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PostOrder {

    public List<Integer> postorder(TreeNode root) {
        List<Integer> nodes = new ArrayList<Integer>();
        
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode prev = null;
        
        while (cur != null || !stk.isEmpty()) {
            
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            else {
                TreeNode top = stk.peek();
                
                if (top.right != null && top.right != prev) {
                    cur = top.right;
                }
                else {
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
        /*
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);*/
        
        a.left = b;
        
        PostOrder sol = new PostOrder();
        List<Integer> nodes = sol.postorder(a);
        System.out.println(nodes);
    }

}
