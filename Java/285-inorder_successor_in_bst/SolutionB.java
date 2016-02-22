
public class SolutionB {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        if (p.right != null) {
            // return the smallest node in the right subtree
            
            TreeNode node = p.right;
            
            while (node.left != null) {
                node = node.left;
            }
            
            return node;
        }
        else {
            // need to find the smallest node that's bigger than p
            
            TreeNode node = root;
            TreeNode successor = null;
            
            while (node != null) {
                
                if (node.val > p.val) {
                    // record it
                    successor = node;
                    
                    // want to see if a smaller node that's bigger than p exists
                    node = node.left;
                }
                else if (node.val <= p.val) {
                    // nodes smaller are not of interest
                    // find bigger nodes
                    node = node.right;
                }
            }
            
            return successor;
        }
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        
        a.left = b;
        a.right = c;
        
        b.right = d;
        c.left = e;
        
        TreeNode k = new TreeNode(3);
        
        SolutionB sol = new SolutionB();
        TreeNode p = sol.inorderSuccessor(a, a);
        
        System.out.println(p.val);
    }

}
