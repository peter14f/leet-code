import java.util.ArrayList;
import java.util.List;


public class SolutionMorris {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<Integer>();
        
        TreeNode cur = root;
        
        while (cur != null) {
            
            if (cur.left != null) {
                
                TreeNode lastNodeInLeft = cur.left;
                
                while (lastNodeInLeft.right != null && lastNodeInLeft.right != cur) {
                    lastNodeInLeft = lastNodeInLeft.right;
                }
                
                if (lastNodeInLeft.right == null) {
                    lastNodeInLeft.right = cur;
                    
                    nodes.add(cur.val);
                    cur = cur.left;
                }
                else {
                    // note that cur is skipped since we've been here before
                    lastNodeInLeft.right = null;
                    cur = cur.right;
                }
            }
            else {
                nodes.add(cur.val);
                cur = cur.right;
            }
            
        }
        
        return nodes;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        
        a.left = b;
        a.right = c;
        
        b.left = d;
        b.right = e;
        
        Solution sol = new Solution();
        List<Integer> nodes = sol.preorderTraversal(a);
        
        System.out.println(nodes);
    }

}
