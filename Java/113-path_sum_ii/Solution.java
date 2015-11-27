import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (root != null) {
            List<Integer> path = new ArrayList<Integer>();
            getPathToSum(root, path, sum, ans);
        }
        
        return ans;
    }
    
    private void getPathToSum(
            TreeNode cur, 
            List<Integer> path, 
            int sum, 
            List<List<Integer>> ans) {
        
        path.add(cur.val);
        sum = sum - cur.val;
        
        if (cur.left == null && cur.right == null) {
            if (sum==0)
                ans.add(new ArrayList<Integer>(path));
        }
        else {
            if (cur.left != null)
                getPathToSum(cur.left, path, sum, ans);
            
            if (cur.right != null)
                getPathToSum(cur.right, path, sum, ans);
        }
        
        path.remove(path.size() - 1);
    }
    
    public static void main(String[] args) {
        
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(2);
        TreeNode g = new TreeNode(13);
        TreeNode h = new TreeNode(4);
        TreeNode i = new TreeNode(1);
        TreeNode j = new TreeNode(5);
        
        a.left = b;
        a.right = c;
        b.left = d;
        d.left = e;
        d.right = f;
        
        c.left = g;
        c.right = h;
        h.right = i;
        h.left = j;
        
        Solution sol = new Solution();
        
        List<List<Integer>> paths = sol.pathSum(a, 22);
        System.out.println(paths);
        
    }

}
