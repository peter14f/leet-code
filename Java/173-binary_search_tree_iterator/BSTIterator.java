import java.util.Stack;


public class BSTIterator {
    Stack<TreeNode> stk;
    
    public BSTIterator(TreeNode root) {
        stk = new Stack<TreeNode>();
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stk.pop();
        TreeNode t = node.right;
        
        while (t != null) {
            stk.push(t);
            t = t.left;
        }
        
        return node.val;
    }
    
    /*   a
     *  /
     * b
     *  \
     *   c
     *  /
     * d
     * 
     */
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        
        a.left = b;
        b.right = c;
        c.left = d;
        
        BSTIterator sol = new BSTIterator(a);
        while (sol.hasNext())
            System.out.println(sol.next());
    }

}
