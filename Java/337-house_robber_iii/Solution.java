
public class Solution {

    public int rob(TreeNode root) {
        int[] profit = profit(root);
        
        return Math.max(profit[0], profit[1]);
    }
    
    // return profit[] which is an int array of size 2
    // profit[0] is the max profit robbing houses in the subtree 
    // with node being the root and node is robbed
    // 
    // profit[1] is the max profit robbing houses in the subtree
    // with node being the root and node is NOT robbed
    private int[] profit(TreeNode node) {
        if (node==null) {
            int[] profit = {0, 0};
            return profit;
        }
      
        int[] profit = new int[2];
      
        int[] left = profit(node.left);
        int[] right = profit(node.right);
      
        // rob node, but not node.left and not node.right
        profit[0] = node.val + left[1] + right[1];
      
        // not robbing node, so no restriction on whether 
        // node.left is robbed and whether node.right is robbed
        // We pick the way that gives the most amount of profit
        profit[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
      
        return profit;
    }
    
    /*
             4
            /
           1
          /
         2
        /
       3                    max profit should be 7 (4+3)

           2
          / \
         1  3
          \
          4         max profit should be 7 (4+3)


    */
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        
        a.left = b;
        b.left = c;
        c.left = d;
        
        Solution sol = new Solution();
        System.out.println(sol.rob(a));
        
        
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        TreeNode r = new TreeNode(3);
        TreeNode s = new TreeNode(4);
        
        p.left = q;
        p.right = r;
        q.right = s;
        
        System.out.println(sol.rob(p));
    }

}
