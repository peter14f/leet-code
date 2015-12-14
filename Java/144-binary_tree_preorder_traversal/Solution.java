import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<Integer>();
        
        TreeNode cur = root;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        while (cur != null || !stk.isEmpty()) {
            
            if (cur != null) {
                stk.push(cur);
                nodes.add(cur.val);
                cur = cur.left;
                continue;
            }
            
            cur = stk.pop();
            cur = cur.right;
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
        List<Integer> preorder = sol.preorderTraversal(a);
        
        System.out.println(preorder);
    }

}
