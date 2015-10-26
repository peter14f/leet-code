
public class Solution {

    public int lengthOfLastWord(String s) {
        char[] s_arr = s.toCharArray();
        int cnt = 0;
        
        int i = s_arr.length - 1;
        
        if (s_arr.length==0)
            return 0;
        
        while (s_arr[i] == ' ') {
            i--;
            if (i < 0)
                break;
        }
        
        while (i>=0) {
            if (s_arr[i]==' ') {
                break;
            }
            else {
                cnt++;
            }
            
            i--;
        }
        
        return cnt;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "Hello World    ";
        int len = sol.lengthOfLastWord(s);
        System.out.println(len);
    }

}
