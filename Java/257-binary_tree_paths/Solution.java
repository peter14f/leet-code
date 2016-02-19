import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> paths = new ArrayList<String>();
                
        List<Integer> curPath = new ArrayList<Integer>();
        
        if (root != null)
            dfsFindPathToLeaf(root, curPath, paths);
        
        return paths;
    }
    
    private void dfsFindPathToLeaf(TreeNode node, 
                                    List<Integer> curPath, 
                                    List<String> paths) {
        
        curPath.add(node.val);
        
        if (node.left==null && node.right==null) {
            StringBuffer sb = new StringBuffer();
            
            sb.append(curPath.get(0));
            
            for (int i=1; i<curPath.size(); i++) {
                sb.append("->");
                sb.append(curPath.get(i));
            }
            paths.add(sb.toString());
        }
        
        if (node.left != null) {
            dfsFindPathToLeaf(node.left, curPath, paths);
        }
        
        if (node.right != null) {
            dfsFindPathToLeaf(node.right, curPath, paths);
        }
        
        curPath.remove(curPath.size()-1);
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(5);
        
        a.left = b;
        a.right = c;
        b.right = d;
        
        Solution sol = new Solution();
        List<String> paths = sol.binaryTreePaths(a);
        System.out.println(paths);
    }

}
