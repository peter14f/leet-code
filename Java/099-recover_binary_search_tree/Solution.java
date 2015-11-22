import java.util.ArrayList;
import java.util.Arrays;


public class Solution {

    // the hint says that the O(n) space solution is straightforward
    public void recoverTree(TreeNode root) {
        
        ArrayList<TreeNode> inOrder = new ArrayList<TreeNode>();
        inOrderInsert(root, inOrder);
        
        int[] nums = new int[inOrder.size()];
        
        for (int i=0; i<inOrder.size(); i++)
            nums[i] = inOrder.get(i).val;
        
        Arrays.sort(nums);
        
        for (int i=0; i<inOrder.size(); i++) {
            if (inOrder.get(i).val != nums[i]) {
                inOrder.get(i).val = nums[i];
            }
        }
    }
    
    private void inOrderInsert(TreeNode cur, ArrayList<TreeNode> inOrder) {
        if (cur==null)
            return;
        
        inOrderInsert(cur.left, inOrder);
        inOrder.add(cur);
        inOrderInsert(cur.right, inOrder);
    }
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        
        root.left = a;
        a.left = b;
        b.left = c;
        
        Solution sol = new Solution();
        sol.recoverTree(root);
        
        System.out.println(c.val);
    }

}
