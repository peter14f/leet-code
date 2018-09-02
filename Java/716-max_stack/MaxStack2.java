
public class MaxStack2 {
    Node tail;

    public MaxStack2() {
        this.tail = null;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        if (this.tail == null) {
            this.tail = newNode;
            return;
        }

        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
    }

    public int pop() {
        int toReturn = this.tail.val;
        this.tail = this.tail.prev;
        if (this.tail != null) {
            this.tail.next = null;
        }
        return toReturn;
    }

    public int top() {
        return this.tail.val;
    }

    public int peekMax() {
        Node node = this.tail;
        int max = this.tail.val;
        while (node != null) {
            if (node.val > max) {
                max = node.val;
            }
            node = node.prev;
        }
        return max;
    }

    public int popMax() {
        int max = peekMax();
        
        Node node = this.tail;
        while (node.val != max) {
            node = node.prev;
        }
        
        if (node == this.tail) {
            this.tail = this.tail.prev;
            if (this.tail != null) {
                this.tail.next = null;
            }
        } else {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }

        return max;
    }

    static class Node {
        Node prev;
        Node next;
        int val;

        public Node(int x) {
            this.val = x;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
