import java.util.Stack;


public class Solution {

    // inorder traversal is the sorted list
    
    /* for a leaf node that is a right child
     *   it's the parent
     *   
     * for a leaf node that is a left child
     * 
     * Can we assume that p is indeed in the BST?
     * 
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode[] nextBigger = {null};
        
        findSuccessors(root, p.val, nextBigger);
        
        return nextBigger[0];
    }
    
    private void findSuccessors(
            TreeNode node, 
            int v, 
            TreeNode[] nextBigger) {
        
        if (node == null)
            return;
        
        findSuccessors(node.right, v, nextBigger);
        
        if (node.val <= v)
            return;
        
        if (nextBigger[0] == null)
            nextBigger[0] = node;
        else if (node.val < nextBigger[0].val)
            nextBigger[0] = node;
        
        findSuccessors(node.left, v, nextBigger);
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(2);
        
        a.left = b;
        a.right = c;
        b.right = d;
        
        Solution sol = new Solution();
        TreeNode successor = sol.inorderSuccessor(a, d);
        
        System.out.println(successor.val);
    }

}
