
public class Solution {

    // empty tree is not considered a unival tree
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return 0;
        
        int[] cnt = {0};
        
        isUnivalSubtree(root, cnt);
        
        return cnt[0];
    }
    
    private boolean isUnivalSubtree(TreeNode root, int[] cnt) {
        //System.out.println(root.val + " " + root);
        
        if (root.left == null && root.right == null) {
            //System.out.println("leaf");
            cnt[0]++;
            return true;
        }
        else if (root.left == null && root.right != null) {
            if (isUnivalSubtree(root.right, cnt) && root.val == root.right.val) {
                cnt[0]++;
                return true;
            }
        }
        else if (root.left != null && root.right == null) {
            if (isUnivalSubtree(root.left, cnt) && root.val == root.left.val) {
                cnt[0]++;
                return true;
            }
        }
        else {
            boolean l = isUnivalSubtree(root.left, cnt);
            boolean r = isUnivalSubtree(root.right, cnt);
            
            if (l && 
                    r &&                    
                    root.val == root.left.val &&
                    root.val == root.right.val) {
                cnt[0]++;
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(5);
        
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        
        Solution sol = new Solution();
        int cnt = sol.countUnivalSubtrees(a);
        System.out.println(cnt);
    }

}
