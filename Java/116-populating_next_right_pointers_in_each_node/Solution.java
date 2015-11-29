import java.util.ArrayList;
import java.util.List;


public class Solution {

    /* you may assume that it is a perfect binary tree (all leaves are the same level, 
     * and every parent has two children)
     */
    public void connect(TreeLinkNode root) {
        
        if (root == null)
            return;
        
        TreeLinkNode listHead = root;
        
        
        while (listHead != null) {
            TreeLinkNode prev = null;
            TreeLinkNode listCur = listHead;
            
            while (listCur != null) {
                
                
                if (listCur.left != null) {
                    
                    if (prev != null)
                        prev.next = listCur.left;
                    
                    listCur.left.next = listCur.right;
                    prev = listCur.right;
                }
                
                listCur = listCur.next;
            }
            
            listHead = listHead.left;
        }
    }
    
    public static void main(String[] args) {
        TreeLinkNode zero = new TreeLinkNode(0);
        TreeLinkNode one = new TreeLinkNode(1);
        TreeLinkNode two = new TreeLinkNode(2);
        TreeLinkNode three = new TreeLinkNode(3);
        TreeLinkNode four = new TreeLinkNode(4);
        TreeLinkNode five = new TreeLinkNode(5);
        TreeLinkNode six = new TreeLinkNode(6);
        
        zero.left = one;
        zero.right = two;
        
        
        one.left = two;
        one.right = three;
        
        Solution sol = new Solution();
        
        sol.connect(one);
        
        System.out.println(one.next);
        System.out.println(one.left.next.val);
    }

}
