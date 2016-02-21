import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution {

    // assume k is valid
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> sorted = new ArrayList<Integer>();
        List<Integer> kValues = new ArrayList<Integer>();
        
        inorderTraversal(root, sorted);
        
        double minDiff = Double.MAX_VALUE;
        int minIndex = -1;
        
        for (int i=0; i<sorted.size(); i++) {
            double diff = Math.abs(sorted.get(i) - target);
            if (diff < minDiff) {
                minDiff = diff;
                minIndex = i;
            }
        }
        
        int i = minIndex;
        int j = minIndex+1;
        
        while (kValues.size() < k) {
            if (i >= 0 && j < sorted.size()) {
                double diffI = Math.abs(target - sorted.get(i));
                double diffJ = Math.abs(target - sorted.get(j));
                
                if (diffI <= diffJ) {
                    kValues.add(sorted.get(i));
                    i--;
                }
                else {
                    kValues.add(sorted.get(j));
                    j++;
                }
            }
            else if (i >= 0) {
                kValues.add(sorted.get(i));
                i--;
            }
            else {
                kValues.add(sorted.get(j));
                j++;
            }
        }
        
        return kValues;
    }
    
    private void inorderTraversal(TreeNode node, List<Integer> sorted) {
        if (node == null)
            return;
        
        inorderTraversal(node.left, sorted);
        sorted.add(node.val);
        inorderTraversal(node.right, sorted);
    }
    
    public static void main(String[] args) {
        
        TreeNode a = new TreeNode(7);
        TreeNode b = new TreeNode(8);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(23);
        TreeNode e = new TreeNode(25);
        
        a.right = b;
        b.right = c;
        c.right = d;
        d.right = e;
        
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(5);
        TreeNode h = new TreeNode(3);
        TreeNode i = new TreeNode(2);
        TreeNode j = new TreeNode(1);
        
        a.left = f;
        f.left = g;
        g.left = h;
        h.left = i;
        i.left = j;
        
        Solution sol = new Solution();
        List<Integer> kValues = sol.closestKValues(a, 7.01, 2);
        System.out.println(kValues);
    }

}
