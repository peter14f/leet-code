import java.util.LinkedList;
import java.util.Queue;


public class SolutionBFS {

    public int numSquares(int n) {
        if (n<1)
            return 0;
            
        Queue<Integer> targets = new LinkedList<Integer>();
        Queue<Integer> cnts = new LinkedList<Integer>();
        
        targets.offer(n);
        cnts.offer(0);
        
        while (!targets.isEmpty()) {
            
            int target = targets.poll();
            int cnt = cnts.poll();
            
            int sqrt = (int)Math.sqrt(target);
            
            while (sqrt > 0) {
                int newTarget = target - sqrt*sqrt;
                
                if (newTarget == 0)
                    return cnt+1;
                
                targets.offer(target - sqrt*sqrt);
                cnts.offer(cnt+1);
                
                sqrt--;
            }
            
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        SolutionBFS sol = new SolutionBFS();
        
        int num = sol.numSquares(6);
        System.out.println(num);
    }

}
