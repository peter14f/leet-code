
public class Solution {

    // 6, 9, 8, 1
    public boolean isStrobogrammatic(String num) {
        int l=0, h=num.length() - 1;
        
        while (l<=h) {
            char left = num.charAt(l);
            char right = num.charAt(h);
            
            if (!stroboChar(left) || ! stroboChar(right))
                return false;
            
            if (left == '1') {
                if (right != '1')
                    return false;
            }
            else if (left == '8') {
                if (right != '8')
                    return false;
            }
            else if (left == '6') {
                if (right != '9')
                    return false;
            }
            else if (left == '9') {
                if (right != '6')
                    return false;
            }
            else if (left == '0') {
                if (right != '0')
                    return false;
            }
            
            l++;
            h--;
        }
        
        return true;
    }
    
    private boolean stroboChar(char c) {
        return (c=='0' || c=='1' || c=='8' || c=='6' || c=='9');
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean strobogrammatic = sol.isStrobogrammatic("616");
        System.out.println(strobogrammatic);
    }

}
