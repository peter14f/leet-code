import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;


public class SolutionSlow {

    class TreeNode {
        TreeNode leftChild;
        TreeNode rightChild;
        char val;
        
        public TreeNode(char v) {
            this.val = v;
        }
    }
    
    // is s2 a scramble of s1?
    public boolean isScramble(String s1, String s2) {
        
        if (s1.length() != s2.length())
            return false;
        
        char[] arr1 = s1.toCharArray();
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        LinkedList<TreeNode> parentList = new LinkedList<TreeNode>();
        
        for (int i=0; i<arr1.length; i++) {
            TreeNode leafNode = new TreeNode(arr1[i]);
            list.add(leafNode);
        }
        
        while (list.size() > 1) {
            TreeNode left = list.removeFirst();
            TreeNode right = list.removeFirst();
            
            TreeNode parent = new TreeNode(' ');
            parent.leftChild = left;
            parent.rightChild = right;
            list.add(parent);
            parentList.add(parent);
        }
        
        TreeNode root = list.getFirst();
        
        HashSet<String> scrambles = new HashSet<String>();        
        getAllScrambles(scrambles, root, parentList);
        
        return scrambles.contains(s2);
    }
    
    private void getAllScrambles(HashSet<String> scrambles, 
                                 TreeNode root, 
                                 LinkedList<TreeNode> list) {
        
        int n = list.size();
        ArrayList<TreeNode> choices = new ArrayList<TreeNode>(list);
        List<List<TreeNode>> ans = new ArrayList<List<TreeNode>>();
        LinkedList<TreeNode> curList = new LinkedList<TreeNode>();
        
        for (int k=1; k<=n; k++) {
            getCombination(n, k, 0, choices, curList, ans);
        }
        
        for (List<TreeNode> toSwapList: ans) {
            
            // swap
            for (TreeNode node: toSwapList) {
                TreeNode temp = node.rightChild;
                node.rightChild = node.leftChild;
                node.leftChild = temp;
            }
            
            String str = getString(root);
            //System.out.println(toSwapList + " " + str);
            scrambles.add(str);
            
            // undo swap
            for (TreeNode node: toSwapList) {
                TreeNode temp = node.rightChild;
                node.rightChild = node.leftChild;
                node.leftChild = temp;
            }
        }
        
    }
    
    private String getString(TreeNode root) {
        
        TreeNode cur = root;
        StringBuffer sb = new StringBuffer();
        
        inOrderTraversal(cur, sb);
        
        return sb.toString();
    }
    
    private void inOrderTraversal(TreeNode cur, StringBuffer sb) {
        // leaf node
        if (cur.leftChild == null && cur.rightChild == null) {
            sb.append(cur.val);
            return;
        }
            
        if (cur.leftChild != null)
            inOrderTraversal(cur.leftChild, sb);
        
        if (cur.rightChild != null)
            inOrderTraversal(cur.rightChild, sb);
    }
    
    private void getCombination(
            int n, 
            int k,
            int index,
            ArrayList<TreeNode> choices, 
            LinkedList<TreeNode> curList, 
            List<List<TreeNode>> ans) {
        
        TreeNode l = choices.get(index);
        curList.add(l);
        
        if (curList.size()==k) {
            ans.add(new ArrayList<TreeNode>(curList));
        }
        else {
            if (index+1 < n) {
                // proceed with choice at index being picked up
                getCombination(n, k, index+1, choices, curList, ans);
            }
        }
        curList.removeLast();
        
        if (index+1 < n) {
            // proceed with choice at index not being picked up
            getCombination(n, k, index+1, choices, curList, ans);
        }
    }
    
    /* TC LONG "pknsvxobynprj"
     *         "kobvyxnjrppsn"
     *         
     * TC LONG2 "abcdefghijklmnopq"
     *          "efghijklmnopqcadb"
     * 
     */
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bdca";
        
        SolutionSlow sol = new SolutionSlow();
        boolean isScramble = sol.isScramble(s1, s2);
        System.out.println(isScramble);
        
        /*      abcd
         *     /    \
         *   ab      cd
         *  / \      / \
         * a   b    c   d
         * 
         * cd: abdc V
         * ab: bacd V
         * abcd: cdab V
         * ab, cd: badc V
         * ab, abcd: cdba V
         * cd, abcd: dcab V
         * ab, cd, abcd: dcba V
         * 
         */
        
        
    }

}
