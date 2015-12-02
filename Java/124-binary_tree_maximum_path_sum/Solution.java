import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Solution {

    public int maxPathSum(TreeNode root) {
        if (root==null)
            return 0;
        
        if (root.left == null && root.right == null) {
            return root.val;
        }
        
        HashMap<TreeNode, TreeNode> parents = new HashMap<TreeNode, TreeNode>();
        buildParentMap(root, null, parents);
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        
        for (TreeNode n: parents.keySet()) {
            nodes.add(n);
        }
        
        int[] maxSum = {0};
        
        for (TreeNode n: nodes) {
            HashSet<TreeNode> visited = new HashSet<TreeNode>();
            dfs(n, visited, 0, maxSum, parents);
        }
        
        return maxSum[0];
    }
    
    private void dfs(
            TreeNode cur,
            HashSet<TreeNode> visited,
            int sum,
            int[] maxSum, 
            HashMap<TreeNode, TreeNode> parents) {
        
        boolean deadEnd = true;
        visited.add(cur);
        sum += cur.val;
        
        if (cur.left != null && !visited.contains(cur.left)) {
            dfs(cur.left, visited, sum, maxSum, parents);

            if (deadEnd)
                deadEnd = false;
        }
        
        if (cur.right != null && !visited.contains(cur.right)) {
            dfs(cur.right, visited, sum, maxSum, parents);
            
            if (deadEnd)
                deadEnd = false;
        }
        
        if (parents.containsKey(cur) && !visited.contains(parents.get(cur))) {
            dfs(parents.get(cur), visited, sum, maxSum, parents);
            
            if (deadEnd)
                deadEnd = false;
        }
        
        if (deadEnd) {
            if (sum > maxSum[0])
                maxSum[0] = sum;
        }
        
        visited.remove(cur);
    }
    
    private void buildParentMap(
            TreeNode node, 
            TreeNode parent, 
            HashMap<TreeNode, TreeNode> parents) {
        
        if (parent!=null) {
            parents.put(node, parent);
        }
        
        if (node.left != null)
            buildParentMap(node.left, node, parents);
        
        if (node.right != null)
            buildParentMap(node.right, node, parents);
    }
    
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        
        
        one.left = two;
        one.right = three;
        
        two.left = new TreeNode(5);
        
        three.left = new TreeNode(-5);
        
        three.right = new TreeNode(-2);
        
        Solution sol = new Solution();
        int m = sol.maxPathSum(one);
        System.out.println(m);
    }

}
