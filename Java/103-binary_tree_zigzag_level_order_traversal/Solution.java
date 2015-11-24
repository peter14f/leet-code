import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        List<Integer> curLevel = new ArrayList<Integer>();
        
        int cnt = 0;
        boolean back = false;
        
        if (root != null) {
            nodes.add(root);
            cnt = 1;
        }
        
        while (!nodes.isEmpty()) {
            
            for (int i=0; i<cnt; i++) {
                TreeNode node = nodes.get(i);
                
                if (!back) {
                    curLevel.add(node.val);
                } 
                else {
                    TreeNode tail = nodes.get(cnt-1-i);
                    curLevel.add(tail.val);
                }
                
                if (node.left != null)
                    nodes.add(node.left);
                if (node.right != null)
                    nodes.add(node.right);
            }
            
            for (int i=0; i<cnt; i++)
                nodes.remove(0);
            
            if (!curLevel.isEmpty()) {
                levels.add(new ArrayList<Integer>(curLevel));
                curLevel.clear();
            }
            
            cnt = nodes.size();
            back = !back;
            
        }
        
        return levels;
    }
    
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        
        three.left = nine;
        three.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;
        
        Solution sol = new Solution();
        List<List<Integer>> levels = sol.zigzagLevelOrder(three);
        System.out.println(levels);
    }

}
