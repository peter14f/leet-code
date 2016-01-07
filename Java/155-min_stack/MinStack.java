import java.util.Stack;


public class MinStack {

    Stack<Integer> stk;
    Stack<Integer> min;
    
    public MinStack() {
        stk = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        stk.push(x);
        
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        int top = stk.peek();
        
        if (min.peek() == top)
            min.pop();
        
        stk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return min.peek();
    }
    
    public static void main(String[] args) {
        MinStack m = new MinStack();
        
        m.push(3);
        System.out.println(m.getMin());
        m.push(2);
        System.out.println(m.getMin());
        m.push(1);
        System.out.println(m.getMin());
        m.push(1);
        System.out.println(m.getMin());
        
        m.pop();
        System.out.println(m.getMin());
        
        m.pop();
        System.out.println(m.getMin());
    }

}
