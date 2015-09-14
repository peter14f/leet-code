import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


public class Solution {

    class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            // TODO Auto-generated method stub
            return o1.val - o2.val;
        }
        
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        int k = lists.length;
        
        if (k==0)
            return null;
        
        ListNodeComparator customComparator = new ListNodeComparator();
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(k, customComparator);
        HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        ListNode head = null;
        ListNode tail = null;
        
        for (int i=0; i<lists.length; i++){
            if (lists[i] != null) {
                pq.offer(lists[i]);
                map.put(lists[i], i);
            }
        }
        
        // the pq size <= k
        // O(2nlogk) = O(n log k)
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            int index = map.get(min);
            
            if (head==null) {
                head = min;
                tail = head;
            }
            else {
                tail.next = min;
                tail = tail.next;
            }
            
            lists[index] = min.next;
            
            if (lists[index] != null) {
                pq.offer(lists[index]);
                map.put(lists[index], index);
            }
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(10);
        ListNode c = new ListNode(15);
        a.next = b;
        b.next = c;
        
        ListNode d = new ListNode(6);
        ListNode e = new ListNode(11);
        ListNode f = new ListNode(16);
        d.next = e;
        e.next = f;
        
        ListNode g = new ListNode(1);
        ListNode h = new ListNode(2);
        ListNode i = new ListNode(3);
        
        ListNode[] arr = {null};
        
        Solution sol = new Solution();
        ListNode head = sol.mergeKLists(arr);
        
        while (head!=null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
