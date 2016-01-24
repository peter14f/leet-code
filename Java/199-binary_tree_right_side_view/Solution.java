import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        
        List<TreeNode> q = new ArrayList<TreeNode>();
        
        if (root != null)
            q.add(root);
        
        while (!q.isEmpty()) {
            int curLevelSize = q.size();
            
            for (int i=0; i<curLevelSize; i++) {
                TreeNode node = q.get(i);
                
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            
            ans.add(q.get(curLevelSize-1).val);
            
            for (int i=0; i<curLevelSize; i++) {
                q.remove(0);
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(4);
        
        a.left = b;
        b.right = d;
        a.right = c;
        c.right = e;
        
        Solution sol = new Solution();
        List<Integer> rightSide = sol.rightSideView(a);
        System.out.println(rightSide);
    }

}
