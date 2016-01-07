
public class Solution extends Reader4 {

    /* in each test read will only be
     * called once
     */
    public int read(char[] buf, int n) {
        int numWritten = 0; // number of chars written into buffer
        char[] temp = new char[4];
        
        while (numWritten < n) {
            int r = read4(temp);
            
            for (int i=0; i<r; i++) {
                if (numWritten >= n)
                    break;
                
                buf[numWritten] = temp[i];
                numWritten++;
            }
            
            if (r < 4) {
                break;
            }
        }
        
        return numWritten;
    }
    
    public static void main(String[] args) {

    }

}
