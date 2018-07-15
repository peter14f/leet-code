

public class Solution {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair pair = subtreeWithAllDeepestNodes(root);
        return pair.smallestSubtreeWDeepestNodes;
    }

    private Pair subtreeWithAllDeepestNodes(TreeNode node) {
        if (node == null) {
            return new Pair(0, null);
        }
        Pair leftResult = 
                subtreeWithAllDeepestNodes(node.left);
        Pair rightResult = 
                subtreeWithAllDeepestNodes(node.right);

        if (leftResult.height == rightResult.height) {
            return new Pair(leftResult.height + 1, node);
        } else if (leftResult.height > rightResult.height) {
            return new Pair(leftResult.height + 1, leftResult.smallestSubtreeWDeepestNodes);
        } else {
            return new Pair(rightResult.height + 1, rightResult.smallestSubtreeWDeepestNodes);
        }
    }
    
    static class Pair {
        int height;
        TreeNode smallestSubtreeWDeepestNodes;
        public Pair(int height, TreeNode smallestSubtreeWDeepestNodes) {
            this.height = height;
            this.smallestSubtreeWDeepestNodes = smallestSubtreeWDeepestNodes;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public static void main(String[] args) {
        
    }

}
