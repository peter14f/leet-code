import java.util.HashMap;


public class LRUCache {

    class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode prev;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private int capacity;
    private ListNode head;
    private ListNode tail;
    private HashMap<Integer, ListNode> keys;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.keys = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        if (keys.containsKey(key)) {
            ListNode node = keys.get(key);
            
            if (keys.size() == 1 || node == head) {
                return node.val;
            }
            
            // have at least two nodes in the list
            // node is not the current head
            
            if (node == tail) {
                tail = tail.prev;
                tail.next = null;
            }
            else {
                node.next.prev = node.prev;
            }
            
            node.prev.next = node.next;
            
            head.prev = node;
            node.next = head;
            head = node;
            
            return node.val;
        }
        else
            return -1;
    }
    
    public void set(int key, int value) {
        
        if (keys.containsKey(key)) {
            ListNode node = keys.get(key);
            node.val = value;
            
            if (node == head)
                return;
            
            // node is not the current head
            if (node == tail) {
                tail = tail.prev;
                tail.next = null;
            }
            else {
                node.next.prev = node.prev;
            }
            
            node.prev.next = node.next;
            
            head.prev = node;
            node.next = head;
            head = node;
        }
        else {
            ListNode newNode = new ListNode(key, value);
            newNode.next = head;
            
            if (head != null)
                head.prev = newNode;
            else
                tail = newNode;
            
            head = newNode;
            keys.put(key, newNode);
            
            
            if (keys.size() > capacity) {
                // remove node at tail
                keys.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
            }
        }
    }
    
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.set(1, 1);
        lru.set(2, 2);
        lru.set(3, 3);
        lru.set(4, 4);
        lru.set(2, 22);
        System.out.println(lru.get(2));
    }

}
