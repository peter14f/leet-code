
public class Solution {

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        
        if (t != null) {
            sb.append(t.val);
            if (t.left != null) {
                preOrderAppend(sb, t.left);
            } else if (t.right != null) {
                sb.append("()");
            }
            preOrderAppend(sb, t.right);
        }
        return sb.toString();
    }

    private void preOrderAppend(StringBuilder sb, TreeNode node) {
        if (node == null) {
            return;
        }

        sb.append('(');
        sb.append(node.val);

        if (node.left != null) {
            preOrderAppend(sb, node.left);
        } else if (node.right != null) {
            sb.append("()");
        }
        preOrderAppend(sb, node.right);

        sb.append(')');
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);

        a.left = b;
        a.right = c;
        b.right = d;

        Solution sol = new Solution();
        String str = sol.tree2str(a);
        System.out.println(str);
    }

}
