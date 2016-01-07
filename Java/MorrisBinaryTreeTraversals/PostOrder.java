import java.util.ArrayList;
import java.util.List;


public class PostOrder {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<Integer>();
        
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        TreeNode cur = dummy;
        
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            }
            else {
                TreeNode largestLeft = cur.left;
                
                while (largestLeft.right != null && largestLeft.right != cur) {
                    largestLeft = largestLeft.right;
                }
                
                if (largestLeft.right == null) {
                    largestLeft.right = cur;
                    cur = cur.left;
                }
                else {
                    // unlink, restore the right child to null
                    largestLeft.right = null;
                    
                    reverse(cur.left, largestLeft);
                    
                    TreeNode t = largestLeft;
                    
                    while (t != cur.left) {
                        nodes.add(t.val);
                        t = t.right;
                    }
                    
                    nodes.add(t.val);
                    
                    reverse(largestLeft, cur.left);
                    
                    cur = cur.right;
                }
            }
        }
        
        return nodes;
    }
    
    // only affects the right node
    private void reverse(TreeNode from, TreeNode to) {
        
        if (from == to)
            return;
        
        TreeNode prev = null;
        TreeNode cur = from;
        
        while (cur != to) {
            TreeNode oldNext = cur.right;
            
            cur.right = prev;
            
            prev = cur;
            cur = oldNext;
        }
        
        cur.right = prev;
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
        
        PostOrder sol = new PostOrder();
        List<Integer> nodes = sol.postorderTraversal(a);
        
        System.out.println(nodes);
        
        sol.inorder(a);
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;
        
        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }
    
}
