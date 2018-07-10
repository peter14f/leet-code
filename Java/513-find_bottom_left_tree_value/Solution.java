import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

    public int findBottomLeftValue(TreeNode root) {
        
        ArrayList<TreeNode> q = new ArrayList<TreeNode>();
        q.add(root);
        ArrayList<TreeNode> q2 = new ArrayList<TreeNode>();
        
        while (!q.isEmpty()) {
            for (int i=0; i<q.size(); i++) {
                TreeNode n = q.get(i);
                if (n.left != null) {
                    q2.add(n.left);
                }
                if (n.right != null) {
                    q2.add(n.right);
                }
            } // traverse q

            if (q2.isEmpty()) {
                // q contains nodes in the last level
                break;
            } else {
                q = q2;
                q2 = new ArrayList<TreeNode>();
            }
        }

        return q.get(0).val;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        
        TreeNode aa = new TreeNode(1);
        TreeNode bb = new TreeNode(2);
        TreeNode cc = new TreeNode (3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        aa.left = bb;
        aa.right = cc;
        bb.left = d;
        cc.left = e;
        cc.right = f;
        e.left = g;
        
        Solution sol = new Solution();
        int ans = sol.findBottomLeftValue(aa);
        System.out.println(ans);
    }

}
