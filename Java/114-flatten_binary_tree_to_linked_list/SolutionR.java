
public class SolutionR {

    public void flatten(TreeNode root) {
        
        TreeNode[] prev = new TreeNode[1];
        prev[0] = null;
        
        flatten(root, prev);
    }
    
    private void flatten(TreeNode node, TreeNode[] prev) {
        if (prev[0] != null) {
            prev[0].right = node;
            prev[0].left = null;
        }
        
        prev[0] = node;
        
        TreeNode rightChild = node.right;
        
        if (node.left != null)
            flatten(node.left, prev);
        
        if (rightChild != null)
            flatten(rightChild, prev);
    }
    
    public static void main(String[] args) {
        
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        
        one.left = two;
        one.right = five;
        two.left = three;
        two.right = four;
        five.right = six;
        
        Solution sol = new Solution();
        sol.flatten(null);
        
        TreeNode cur = one;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.right;
        }
        
    }

}
