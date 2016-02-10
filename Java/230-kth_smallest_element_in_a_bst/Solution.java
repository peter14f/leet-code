
public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        int leftSize = getTreeSize(root.left);
        
        if (leftSize + 1 == k)
            return root.val;
        
        if (k <= leftSize)
            return kthSmallest(root.left, k);
        
        return kthSmallest(root.right, k - 1 - leftSize);
    }
    
    private int getTreeSize(TreeNode node) {
        if (node==null)
            return 0;
        
        int leftSize = getTreeSize(node.left);
        int rightSize = getTreeSize(node.right);
        
        return leftSize + rightSize + 1;
    }
    
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        
        two.left = one;
        two.right = three;
        
        Solution sol = new Solution();
        int ans = sol.kthSmallest(two, 3);
        
        System.out.println(ans);
    }

}
