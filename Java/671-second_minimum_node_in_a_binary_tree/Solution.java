import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int findSecondMinimumValue(TreeNode root) {

        LinkedList<Integer> l = new LinkedList<>();
        preorderTraversal(root, l);
        
        if (l.size() < 2) {
            return -1;
        } else {
            return l.getLast();
        }
    }
    
    private void preorderTraversal(TreeNode node, LinkedList<Integer> l) {
        if (node == null) {
            return;
        }

        preorderTraversal(node.left, l);

        if (l.isEmpty()) {
            l.add(node.val);
        } else if (l.size() == 1){
            if (l.getFirst() > node.val) {
                l.addFirst(node.val);
            } else if (l.getFirst() < node.val){
                l.add(node.val);
            }
        } else {
            if (node.val < l.getFirst()) {
                l.addFirst(node.val);
                l.removeLast();
            } else if (node.val < l.getLast()) {
                l.removeLast();
                l.addLast(node.val);
            }
        }

        preorderTraversal(node.right, l);
    }

    public static void main(String[] args) {
        
    }

}
