
public class Solution {

    enum Direction {
        LEFT, 
        RIGHT,
    };

    public int sumOfLeftLeaves(TreeNode root) {
        // apparently single-node tree is not considered a left leaf
        return sumOfLeftLeaves(root, Direction.RIGHT);
    }

    private int sumOfLeftLeaves(TreeNode node, Direction d) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            if (d == Direction.LEFT) {
                return node.val;
            } else {
                return 0;
            }
        }

        return sumOfLeftLeaves(node.left, Direction.LEFT) + 
                sumOfLeftLeaves(node.right, Direction.RIGHT);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode (9);
        
        //TreeNode c = new TreeNode(20);
        //TreeNode d = new TreeNode(15);
        //TreeNode e = new TreeNode(7);

        a.left = b;
        //a.right = c;
        //c.left = d;
        //c.right = e;

        Solution sol = new Solution();
        int ans = sol.sumOfLeftLeaves(null);
        System.out.println(ans);
    }

}
