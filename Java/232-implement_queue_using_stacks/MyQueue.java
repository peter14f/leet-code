import java.util.Stack;


public class MyQueue {
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    
    public MyQueue() {
        stk1 = new Stack<Integer>();
        stk2 = new Stack<Integer>();
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        stk1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (stk1.size() > 1) {
            stk2.push(stk1.pop());
        }
        stk1.pop();
        while (!stk2.isEmpty()) {
            stk1.push(stk2.pop());
        }
    }

    // Get the front element.
    public int peek() {
        int ret;
        
        while (stk1.size() > 1) {
            stk2.push(stk1.pop());
        }
        
        ret = stk1.peek();
        
        while (!stk2.isEmpty()) {
            stk1.push(stk2.pop());
        }
        
        return ret;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (stk1.isEmpty());
    }
    
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.peek());
    }

}
