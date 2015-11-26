import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        List<Integer> curLevel = new ArrayList<Integer>();
        
        int cnt = 0;
        if (root != null) {
            nodes.add(root);
            cnt = 1;
        }
        
        while (!nodes.isEmpty()) {
            for (int i=0; i<cnt; i++) {
                TreeNode node = nodes.remove(0);
                curLevel.add(node.val);
                
                if (node.left != null)
                    nodes.add(node.left);
                
                if (node.right != null)
                    nodes.add(node.right);
            }
            
            if (!curLevel.isEmpty()) {
                levels.add(0, new ArrayList<Integer>(curLevel));
                curLevel.clear();
            }
            
            cnt = nodes.size();
        }
        
        return levels;
    }
    
    public static void main(String[] args) {
        
    }

}
