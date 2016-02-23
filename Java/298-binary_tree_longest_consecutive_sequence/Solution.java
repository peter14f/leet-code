
public class Solution {

    public int longestConsecutive(TreeNode root) {
        return findLongestConsecutive(root, 0, 0);
    }
    
    private int findLongestConsecutive(TreeNode node, int curLength, int prevNum) {
        
        if (node==null) {
            return curLength;
        }
        
        int left = 0;
        int right = 0;
        
        if (curLength==0) {
            left = findLongestConsecutive(node.left, 1, node.val);
            right = findLongestConsecutive(node.right, 1, node.val);
        }
        else {
            if (node.val == prevNum + 1) {
                left = findLongestConsecutive(node.left, curLength+1, node.val);
                right = findLongestConsecutive(node.right, curLength+1, node.val);
            }
            else {
                // in this case curLength might be longer than digger further
                left = findLongestConsecutive(node.left, 1, node.val);
                right = findLongestConsecutive(node.right, 1, node.val);
                return Math.max(curLength, Math.max(left, right));
            }
        }
        
        return Math.max(left,  right);
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(2);
        
        a.left = b;
        a.right = c;
        
        Solution sol = new Solution();
        int len = sol.longestConsecutive(a);
        System.out.println(len);
    }

}
