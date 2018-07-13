import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }

        while (!isLeaf(root)) {
            List<Integer> l = new ArrayList<Integer>();
            trimAllLeafNodes(root, l);
            ans.add(l);
        }

        List<Integer> l = new ArrayList<>();
        l.add(root.val);
        ans.add(l);

        return ans;
    }

    private void trimAllLeafNodes(
            TreeNode node, 
            List<Integer> l) {

        if (isLeaf(node)) {
            l.add(node.val);
            return;
        }

        if (node.left != null) {
            boolean leftIsLeaf = isLeaf(node.left);
            trimAllLeafNodes(node.left, l);
            if (leftIsLeaf) {
                node.left = null;
            }
        }

        if (node.right != null) {
            boolean rightIsLeaf = isLeaf(node.right);
            trimAllLeafNodes(node.right, l);
            if (rightIsLeaf) {
                node.right = null;
            }
        }
    }
    
    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;
        
        return (node.left == null && node.right == null);
    }
    
    private void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);
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
        List<List<Integer>> leaves = sol.findLeaves(a);
        System.out.println(leaves);
    }

}
