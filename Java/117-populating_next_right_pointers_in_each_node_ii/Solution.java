
public class Solution {

    public void connect(TreeLinkNode root) {
        
        TreeLinkNode listHead = root;
        
        while (listHead != null) {
            TreeLinkNode listCur = listHead;
            TreeLinkNode prev = null;
            TreeLinkNode nextListHead = null;
            
            while (listCur != null) {
                
                
                if (listCur.left != null) {
                    if (prev != null) {
                        prev.next = listCur.left;
                        prev = prev.next;
                    }
                    else {
                        prev = listCur.left;
                        nextListHead = prev;
                    }
                }
                
                if (listCur.right != null) {
                    if (prev != null) {
                        prev.next = listCur.right;
                        prev = prev.next;
                    }
                    else {
                        prev = listCur.right;
                        nextListHead = prev;
                    }
                }
                
                listCur = listCur.next;
            }
            
            listHead = nextListHead;
        }
    }
    
    public static void main(String[] args) {
        TreeLinkNode nine = new TreeLinkNode(-9);
        TreeLinkNode three = new TreeLinkNode(-3);
        TreeLinkNode two = new TreeLinkNode(2);
        TreeLinkNode fourA = new TreeLinkNode(4);
        TreeLinkNode fourB = new TreeLinkNode(4);
        TreeLinkNode zero = new TreeLinkNode(0);
        TreeLinkNode six = new TreeLinkNode(-6);
        TreeLinkNode five = new TreeLinkNode(-5);
        
        nine.left = three;
        nine.right = two;
        three.right = fourA;
        two.left = fourB;
        two.right = zero;
        fourA.left = six;
        fourB.left = five;
        
        Solution sol = new Solution();
        sol.connect(nine);
        
        
        TreeLinkNode cur = six;
        while (cur!=null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
        
    }
}
