import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SolutionBFS {

    public List<List<Integer>> verticalOrder2(TreeNode root) {
        List<List<Integer>>  ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<MyNode> q = new LinkedList<MyNode>();
        int minCol = 0;
        int maxCol = 0;
        q.offer(new MyNode(root, 0));

        // bfs
        while (!q.isEmpty()) {
            MyNode n = q.poll();

            if (n.col < minCol) {
                minCol = n.col;
            }
            if (n.col > maxCol) {
                maxCol = n.col;
            }

            if (!map.containsKey(n.col)) {
                map.put(n.col, new ArrayList<>());
            }
            map.get(n.col).add(n.node.val);
            if (n.node.left != null) {
                q.offer(new MyNode(n.node.left, n.col-1));
            }
            if (n.node.right != null) {
                q.offer(new MyNode(n.node.right, n.col+1));
            }
        }

        for (int i=minCol; i<= maxCol; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
    
    static class MyNode {
        TreeNode node;
        int col;
        public MyNode(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> allLists = new ArrayList<List<Integer>>();
        
        if (root==null)
            return allLists;
        
        HashMap<TreeNode, Integer> posLookup = new HashMap<TreeNode, Integer>();
        HashMap<Integer, List<Integer>> listLookup = new HashMap<Integer, List<Integer>>();
        
        posLookup.put(root, 0);
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        // with a binary tree we don't need to worry about coming back 
        // to current node because the child does not have a parent pointer
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            
            int position = posLookup.get(node);
            
            if (!listLookup.containsKey(position)) {
                List<Integer> newList = new ArrayList<Integer>();
                listLookup.put(position, newList);
            }
            
            listLookup.get(position).add(node.val);
            
            if (node.left != null) {
                posLookup.put(node.left, position-1);
                q.offer(node.left);
            }
            
            if (node.right != null) {
                posLookup.put(node.right, position+1);
                q.offer(node.right);
            }
        }
        
        List<Integer> positions = new ArrayList<Integer>(listLookup.keySet());
        Collections.sort(positions);
        
        for (int pos: positions) {
            allLists.add(listLookup.get(pos));
        }
        
        return allLists;
    }
    
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(6);
        
        TreeNode d = new TreeNode(3);
        
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(4);
        
        
        a.left = b;
        a.right = c;
        
        b.right = d;
        
        d.left = e;
        d.right = f;
        
        SolutionBFS sol = new SolutionBFS();
        List<List<Integer>> ans = sol.verticalOrder2(a);
        System.out.println(ans);
    }

}
