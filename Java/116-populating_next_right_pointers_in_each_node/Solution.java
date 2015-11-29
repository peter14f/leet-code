import java.util.ArrayList;
import java.util.List;


public class Solution {

    /* you may assume that it is a perfect binary tree (all leaves are the same level, 
     * and every parent has two children)
     */
    public void connect(TreeLinkNode root) {
        
        List<TreeLinkNode> nodes = new ArrayList<TreeLinkNode>();
        
        int cnt = 0;
        if (root != null) {
            nodes.add(root);
            cnt = 1;
        }
        
        while (!nodes.isEmpty()) {
            TreeLinkNode prev = null;
            for (int i=0; i<cnt; i++) {
                TreeLinkNode node = nodes.remove(0);
                
                if (node.left != null)
                    nodes.add(node.left);
                
                if (node.right != null)
                    nodes.add(node.right);
                
                if (prev != null) {
                    prev.next = node; 
                }
                
                prev = node;
            }
            
            cnt = nodes.size();
        }
        
        
    }
    
    public static void main(String[] args) {
        TreeLinkNode one = new TreeLinkNode(1);
        TreeLinkNode two = new TreeLinkNode(2);
        TreeLinkNode three = new TreeLinkNode(3);
        
        one.left = two;
        one.right = three;
        
        Solution sol = new Solution();
        sol.connect(one);
        
        System.out.println(one.next);
        System.out.println(one.left.next.val);
    }

}
