import java.util.ArrayList;
import java.util.List;


public class SolutionM {

    /*           1
     *          / \
     *         2   3
     * 
     */
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode cur = root;
        
        while (cur != null) {
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode t = cur.left;
                
                while (t.right != null && t.right != cur) {
                    t = t.right;
                }
                
                if (t.right == null) {
                    t.right = cur;
                    cur = cur.left;
                }
                else {
                    t.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        SolutionM sol = new SolutionM();
        
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        
        two.left = one;
        two.right = three;
        
        List<Integer> ans = sol.inorderTraversal(two);
        System.out.println(ans);
    }

}
