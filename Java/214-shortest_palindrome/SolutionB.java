
public class SolutionB {
    
    public String shortestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int i = 0;
        int end = chs.length-1;
        int j = end;
        
        while (i < j) {
            if (chs[i] == chs[j]) {
                i++;
                j--;
            }
            else {
                end--;
                j=end;
                i=0;
            }
        }
        
        StringBuffer sb = new StringBuffer(s.substring(end+1));
        sb.reverse();
        return sb.toString() + s;
    }
    
    public static void main(String[] args) {
        SolutionB sol = new SolutionB();
    
        String palindrome = sol.shortestPalindrome("abc");
        System.out.println(palindrome);
    }
}
