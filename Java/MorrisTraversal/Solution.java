
public class Solution {

    public void morrisInOrderTraversal(TreeNode root) {
        TreeNode cur = root;
        
        while (cur != null) {
            
        }
    }
    
    public static void main(String[] args) {
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        TreeNode eight = new TreeNode(8);
        
        six.left = two;
        two.left = one;
        two.right = four;
        four.left = three;
        four.right = five;
        six.right = seven;
        seven.right = nine;
        nine.left = eight;
        
        Solution sol = new Solution();
        sol.morrisInOrderTraversal(six);
    }

}
