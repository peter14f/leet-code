import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {

    public int[][] reconstructQueue2(int[][] people) {
        int n = people.length;
        int[][] ans = new int[n][];

        PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator());

        for (int[] entry : people) {
            pq.offer(entry);
        }

        LinkedList<int[]> ll = new LinkedList<>();
        while (!pq.isEmpty()) {
            int[] person = pq.poll();
            ll.add(person[1], person);
        }

        Iterator<int[]> itr = ll.iterator();
        int i=0;
        while (itr.hasNext()) {
            ans[i] = itr.next();
            i++;
        }

        return ans;
    }

    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] ans = new int[n][];

        PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator());

        for (int[] entry : people) {
            pq.offer(entry);
        }

        MyDLL dll = new MyDLL();
        while (!pq.isEmpty()) {
            int[] person = pq.poll();
            dll.insertAfterKNodes(person[1], person);
        }

        Node cur = dll.head;
        int i=0;
        while (cur != null) {
            ans[i] = cur.data;
            cur = cur.next;
            i++;
        }

        return ans;
    }

    static class MyComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {

            if (o1[0] > o2[0]) {
                return -1;
            } else if (o1[0] < o2[0]) {
                return 1;
            } else {
                return o1[1] - o2[1];
            }

        }
    }

    static class MyDLL {
        Node head;

        public MyDLL() {
            this.head = null;
        }
        
        public void insertAfterKNodes(int k, int[] data) {
            if (k==0) {
                Node newHead = new Node(data);
                if (this.head!=null) {
                    this.head.prev = newHead;
                }
                newHead.next = this.head;
                this.head = newHead;
            } else {
                Node cur = head;
                int i = 1;
                while (i < k) {
                    cur = cur.next;
                    i++;
                }
                Node newNode = new Node(data);
                Node oldNext = cur.next;

                newNode.prev = cur;
                newNode.next = oldNext;

                cur.next = newNode;
                if (oldNext != null) {
                    oldNext.prev = newNode;
                }
            }
        }
    }

    static class Node {
        int[] data;
        Node next;
        Node prev;
        public Node(int[] data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int[][] people = {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };
        Solution sol = new Solution();
        int[][] q = sol.reconstructQueue2(people);
        System.out.println(Arrays.deepToString(q));
    }

}
