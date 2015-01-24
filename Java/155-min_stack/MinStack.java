import java.util.Stack;


public class MinStack {
    Stack<Integer> stk;
    Stack<Integer> indexStk;
    
    public MinStack() {
        stk = new Stack<Integer>();
        indexStk = new Stack<Integer>();
    }
    
    public void push(int x) {
        stk.push(x);
        
        if (indexStk.isEmpty())
            indexStk.push(0);
        else if (x < stk.get(indexStk.peek()))
            indexStk.push(stk.size()-1);
    }

    public void pop() {
        if (indexStk.peek() == stk.size() - 1) {
            indexStk.pop();
        }
        stk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return stk.get(indexStk.peek());
    }
    
    public static void main(String[] args) {
        MinStack stk = new MinStack();
        
        stk.push(3);
        stk.push(2);
        stk.push(1);
        
        System.out.println(stk.getMin());
        stk.pop();
        System.out.println(stk.getMin());
        stk.pop();
        System.out.println(stk.getMin());
    }
}
