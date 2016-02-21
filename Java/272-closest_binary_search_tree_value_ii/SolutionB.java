import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class SolutionB {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        
        Stack<Integer> preStk = new Stack<Integer>();
        Stack<Integer> sucStk = new Stack<Integer>();
        
        List<Integer> ans = new ArrayList<Integer>();
        
        getPredeccesors(root, target, preStk);
        getSuccessors(root, target, sucStk);
        
        while (ans.size() < k) {
            
            if (!preStk.isEmpty() && !sucStk.isEmpty()) {
                int smaller = preStk.peek();
                int bigger = sucStk.peek();
                
                double diff1 = Math.abs(target - smaller);
                double diff2 = Math.abs(target - bigger);
                
                if (diff1 <= diff2)
                    ans.add(preStk.pop());
                else
                    ans.add(sucStk.pop());
            }
            else if (!preStk.isEmpty()) {
                ans.add(preStk.pop());
            }
            else if (!sucStk.isEmpty()) {
                ans.add(sucStk.pop());
            }
            else {
                // this means k is larger than n
                break;
            }
        }
        
        return ans;
    }
    
    // predeccesor are node values <= taget
    private void getPredeccesors(TreeNode node, double target, Stack<Integer> preStk) {
        if (node == null)
            return;
        
        getPredeccesors(node.left, target, preStk);
        
        if (node.val > target)
            return;
        
        preStk.push(node.val);
        
        getPredeccesors(node.right, target, preStk);
    }
    
    private void getSuccessors(TreeNode node, double target, Stack<Integer> sucStk) {
        if (node == null)
            return;
        
        getSuccessors(node.right, target, sucStk);
        
        if (node.val <= target)
            return;
        
        sucStk.push(node.val);
        
        getSuccessors(node.left, target, sucStk);
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
        
        SolutionB sol = new SolutionB();
        
        List<Integer> ans = sol.closestKValues(a, 7.01, 4);
        
        System.out.println(ans);
    }

}
