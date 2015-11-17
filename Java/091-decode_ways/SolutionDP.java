
public class SolutionDP {

    public int numDecodings(String s) {
        
        char[] sArr = s.toCharArray();
        int n = sArr.length;
        
        int i = n - 1;
        
        /* number of ways to decode the substring 
         * starting at index i+1
         */
        int prev = 1;
        
        /* number of ways to decode the substring 
         * starting at index i+2
         */
        int prevPrev = 0;
        
        /* number of ways to decode the substring 
         * starting at index i
         */
        int cnt = 0;
        
        while (i >= 0) {
            int num = 0;
            
            cnt = 0;
            
            if (prev > 0) {
                num = sArr[i] - '0';
                if (num >= 1 && num <=9)
                    cnt += prev;
            }
            
            if (prevPrev > 0) {
                num = sArr[i] - '0';
                if (num == 1 || num ==2) {
                    num = num*10 + (sArr[i+1] - '0');
                    
                    if (num >= 10 && num <= 26) {
                        cnt += prevPrev;
                    }
                }
            }
            
            prevPrev = prev;
            prev = cnt;
            
            i--;
        }
        
        return cnt;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        /* 1, 1, 2, 2
         * 1, 1, 22
         * 1, 12, 2
         * 11, 22
         * 11, 2, 2
         */
        
        SolutionDP sol = new SolutionDP();
        int ans = sol.numDecodings("7541387519572282368613553811323167125532172369624572591562685959575371877973171856836975137559677665");
        System.out.println(ans);
    }

}
