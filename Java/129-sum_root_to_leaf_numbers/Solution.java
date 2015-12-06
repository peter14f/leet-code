
public class Solution {

    // values are integers from 0 to 9 only
    public int sumNumbers(TreeNode root) {
        if (root==null)
            return 0;
        
        int curNum = 0;
        int totalSum[] = {0}; 
        
        sumNumbers(root, curNum, totalSum);
        
        return totalSum[0];
    }
    
    private void sumNumbers(TreeNode node, int curSum, int[] totalSum) {
        curSum = curSum*10 + node.val;
        
        if (node.left == null && node.right == null) {
            totalSum[0] += curSum;
            return;
        }
        
        if (node.left != null)
            sumNumbers(node.left, curSum, totalSum);
        
        if (node.right != null)
            sumNumbers(node.right, curSum, totalSum);
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        
        a.left = b;
        b.left = c;
        
        Solution sol = new Solution();
        int sum = sol.sumNumbers(a);
        
        System.out.println(sum);
    }

}
