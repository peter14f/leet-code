import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<Integer>();
        
        if (root==null)
            return ans;
        
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        stk.push(root);
        TreeNode cur = root.left;
        
        while (cur != null || !stk.isEmpty()) {
            
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            else {
                TreeNode top = stk.pop();
                ans.add(top.val);
                cur = top.right;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(3);
        
        a.left = b;
        b.left = c;
        b.right = d;
        
        TreeNode e = new TreeNode(5);
        
        a.right = e;
        
        Solution sol = new Solution();
        List<Integer> ans = sol.inorderTraversal(a);
        System.out.println(ans);
    }

}
