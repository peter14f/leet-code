import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        TreeNode cur = root;
        
        while (true) {
            if (cur==null && stk.isEmpty()) {
                break;
            }
            
            if (cur==null) {
                cur = stk.pop();
                ans.add(cur.val);
                cur = cur.right;
                
            }
            else {
                stk.push(cur);
                cur = cur.left;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        
        a1.right = a2;
        a2.left = a3;
        
        Solution sol = new Solution();
        List<Integer> ans = sol.inorderTraversal(a1);
        System.out.println(ans);
    }

}
