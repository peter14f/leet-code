
public class Solution extends Reader4 {

    /* in each test read will only be
     * called once
     */
    public int read(char[] buf, int n) {
        int numLeft = n; // number of chars left to read
        int tot = 0;     // number of chars copied into buf
        char[] temp = new char[4];
        
        while (numLeft > 0) {
            int r = read4(temp);
            
            for (int i=0; i<r; i++) {
                if (tot >= n)
                    break;
                
                buf[tot] = temp[i];
                tot++;
                numLeft--;
            }
            
            if (r < 4) {
                break;
            }
        }
        
        return tot;
    }
    
    public static void main(String[] args) {

    }

}
