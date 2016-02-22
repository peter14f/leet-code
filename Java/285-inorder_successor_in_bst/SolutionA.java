import java.util.Stack;


public class SolutionA {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode[] prev = {null};
        TreeNode successor = inorder(root, prev, p);
        return successor;
    }
    
    private TreeNode inorder(TreeNode node, TreeNode[] prev, TreeNode p) {
        
        if (node == null)
            return null;
        
        TreeNode leftResult = inorder(node.left, prev, p);
        
        if (leftResult != null)
            return leftResult;
        
        if (prev[0] == p)
            return node;
        
        prev[0] = node;
        
        TreeNode rightResult = inorder(node.right, prev, p);
        
        return rightResult;
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
        
        SolutionA sol = new SolutionA();
        TreeNode p = sol.inorderSuccessor(a, k);
        
        System.out.println(p.val);
    }

}
