import java.util.LinkedList;
import java.util.Queue;

public class Solution extends Reader4 {
    Queue<Character> q;
    
    public Solution() {
        this.q = new LinkedList<Character>();
    }
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int numWritten = 0; // number of chars written into buf
        boolean done = false;
                
        while (numWritten > n) {
            if (q.isEmpty()) {
                int k = read4(temp);
                
                if (k < 4)
                    done = true;
                
                for (int i=0; i<k; i++) {
                    this.q.offer(temp[0]);
                }
            }
            
            while (numWritten < n && !q.isEmpty()) {
                buf[numWritten] = q.poll();
                numWritten++;
            }
            
            if (done)
                break;
        }
        
        return numWritten;
    }
}