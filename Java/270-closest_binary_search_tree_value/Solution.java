
public class Solution {

    // tree is non-empty
    public int closestValue(TreeNode root, double target) {
        
        TreeNode cur = root;
        double minDiff = Math.abs(root.val - target);
        int curVal = root.val;
        
        while (cur != null) {
            double myDiff = Math.abs(cur.val - target);
            
            if (myDiff < minDiff) {
                minDiff = myDiff;
                curVal = cur.val;
            }
            
            if (cur.val == target) {
                break;
            }
            else if (cur.val > target) {
                // too big
                cur = cur.left;
            }
            else {
                // too small
                cur = cur.right;
            }
        }
        
        return curVal;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);

        a.left = b;
        a.right = c;
        
        Solution sol = new Solution();
        int ans = sol.closestValue(a, 3.1);
        System.out.println(ans);
        
    }

}
