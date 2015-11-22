import java.util.ArrayList;
import java.util.List;

public class SolutionP {

    public void recoverTree(TreeNode root) {
        
        if (root==null)
            return;
        
        List<TreeNode> toSwap = new ArrayList<TreeNode>();
        
        inOrderTraversal(root, toSwap, new TreeNode[1]);
        
        System.out.println(toSwap.size());
        
        if (toSwap.size() == 2) {
            TreeNode a = toSwap.get(0);
            TreeNode b = toSwap.get(1);
            
            int tmp = a.val;
            a.val = b.val;
            b.val = tmp;
        }
        else if (toSwap.size() == 4) {
            TreeNode a = toSwap.get(0);
            TreeNode b = toSwap.get(3);
            
            int tmp = a.val;
            a.val = b.val;
            b.val = tmp;
        }
    }
    
    private void inOrderTraversal(TreeNode cur, List<TreeNode> toSwap, TreeNode[] prev) {
        if (cur==null)
            return;
        
        inOrderTraversal(cur.left, toSwap, prev);
        
        if (prev[0] != null) {
            if (prev[0].val > cur.val) {
                toSwap.add(prev[0]);
                toSwap.add(cur);
            }
        }
        
        prev[0] = cur;
        
        inOrderTraversal(cur.right, toSwap, prev);
    }
    
    public static void main(String[] args) {
        
        SolutionP sol = new SolutionP();
        TreeNode root = new TreeNode(2);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(3);
        
        root.left = b;
        root.right = a;
        
        sol.recoverTree(root);
        
        System.out.println(a.val);
        System.out.println(b.val);
    }

}
