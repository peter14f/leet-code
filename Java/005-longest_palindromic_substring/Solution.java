import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Solution {

    public String longestPalindrome(String s) {
        HashMap<Character, ArrayList<Integer>> charIndex = 
                new HashMap<Character, ArrayList<Integer>>();
        
        String ans = "";
        
        char[] sArr = s.toCharArray();
        
        // store indices for each char in s
        for (int i = 0; i < s.length(); i++) {
            if (charIndex.containsKey(sArr[i])) {
                charIndex.get(sArr[i]).add(i);
            }
            else {
                ArrayList<Integer> indexArr = new ArrayList<Integer>();
                indexArr.add(i);
                charIndex.put(sArr[i], indexArr);
            }
        }
        
        // i is the starting index of the potential palindrom
        for (int i = 0; i < s.length(); i++) {
            char c = sArr[i];
            ArrayList<Integer> indexArr = charIndex.get(c);
            
            /* traversing from the tail of the ArrayList because we want to 
             * look for longer palindrome first
             */
            for (int j = indexArr.size() - 1; j >= 0; j--) {
                int tailIndex = indexArr.get(j);
                int palindromLength = tailIndex - i + 1;
                
                if (palindromLength <= ans.length()) {
                    break;
                }
                
                int head = i;
                int tail = tailIndex;
                boolean isPalindrom = true;
                
                while (tail >= i && head <= tailIndex) {
                    if (sArr[head] != sArr[tail]) {
                        isPalindrom = false;
                        break;
                    }
                    tail--;
                    head++;
                }
                
                if (isPalindrom) {
                    ans = s.substring(i, tailIndex+1);
                    /* once a palindrome is found, there is no point looking
                     * for a shorter palindrome starting at index i
                     */
                    break;
                }
            }
        }
        
        return ans;
    }
    
    public String longestPalindromeDP(String s) {
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        char[] sArr = s.toCharArray();
        int palindromeLength = 0;
        int palindromeStart = 0;
        
        // offset is the distance from diagonal
        for (int offset=0; offset<s.length(); offset++) {
            for (int row=0; row<s.length(); row++) {
                if (offset==0) {
                    // a substring of length 1 is always a palindrome
                    palindrome[row][row+offset] = true;
                    if (offset+1 > palindromeLength) {
                        palindromeLength = offset+1;
                        palindromeStart = row;
                    }
                }
                else if (offset==1){
                    /* a substring of length 2 is a palindrome
                     * iff two characters are the same
                     */
                    if (row+offset < s.length() && 
                            sArr[row] == sArr[row+offset]) {
                        palindrome[row][row+offset] = true;
                        if (offset+1 > palindromeLength) {
                            palindromeLength = offset+1;
                            palindromeStart = row;
                        }
                    }
                }
                else {
                    /* the substring is a palindrome
                     * iff s.substring(row+1, row+offset) is a palindrome AND
                     *     sArr[row] == sArr[row+offset]
                     */
                    if (row+offset < s.length() && 
                            palindrome[row+1][row+offset-1] && 
                            sArr[row] == sArr[row+offset]) {
                        palindrome[row][row+offset] = true;
                        if (offset+1 > palindromeLength) {
                            palindromeLength = offset+1;
                            palindromeStart = row;
                        }
                    }
                }
            } // for row
        } // for offset
        
        System.out.println(palindromeStart + " " + palindromeLength);
        
        return s.substring(palindromeStart, palindromeStart+palindromeLength);
    }
    
    public String longestPalindromeNoExtraSpace(String s) {
        int palindromeLength = 0;
        int palindromeStart = 0;
        char[] sArr = s.toCharArray();
        
        for (int center=0; center < s.length(); center++) {
            /* middle = 1 means palindrome's mid point is between center and center+1
             * middle = 0 means palindrome mid point is center
             */
            for (int middle=0; middle<2; middle++) {
                int left, right;
                
                if (middle > 0) {
                    left = center;
                    right = center + 1;
                }
                else {
                    left = center - 1;
                    right = center + 1;
                }
                
                int length;
                
                if (middle > 0) {
                    length = 0;
                    if (palindromeLength==0) {
                        palindromeLength = 1;
                        palindromeStart = center;
                    }
                }
                else
                    length = 1;
                
                while (left >=0 && right < s.length() && sArr[left] == sArr[right]) {
                    length+=2;
                    left --;
                    right++;
                }
                
                if (length > palindromeLength) {
                    palindromeLength = length;
                    palindromeStart = left+1;
                }
            }
        }
        
        return s.substring(palindromeStart, palindromeStart+palindromeLength);
    }
    
    public String longestPalindromeManacher(String s) {
        StringBuffer sb = new StringBuffer();
        
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        
        char[] tArr = sb.toString().toCharArray();
        
        // p[i] is the number of characters on each side centering at i
        int[] p = new int[tArr.length];
        
        /* we need to keep track of the palindrome found so far 
         * whose right edge has the largest absolute index  
         */
        int c = 0; // center's index
        int r = 0; // right edge's index
        
        for (int i=0; i<tArr.length; i++) {
            // build p
            
            int iPrime = c - (i-c); // index of mirrored i

            if (iPrime >= 0) {
                if (i + p[iPrime] > r) {
                    p[i] = r - i; // start with dist(right edge to center)
                }
                else {
                    p[i] = p[iPrime];
                }
            }
            
            // Attempt to expand palindrome centered at i
            while (i - 1 - p[i] >= 0 &&
                    i + 1 + p[i] < tArr.length &&
                    tArr[i - 1 - p[i]] == tArr[i + 1 + p[i]]) {
                
                p[i]++;
                
            }
            
            // if palindrome centered at i expand past R,
            // adjust center based on expanded palindrome.
            if (i + p[i] > r) {
              c = i;
              r = i + p[i];
            }
        }
        
        int palindromeLength = 0;
        int center = 0;
        
        for (int i=0; i<tArr.length; i++) {
            if (p[i] > palindromeLength) {
                palindromeLength = p[i];
                center = i;
            }
        }
        
        return s.substring((center-palindromeLength)/2, (center-palindromeLength)/2 + palindromeLength);
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        //String ans = s.longestPalindrome("aaabaaaa");
        
        //String ans = s.longestPalindromeNoExtraSpace("ccc");
        //ans = s.longestPalindromeNoExtraSpace("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
        String ans = s.longestPalindromeNoExtraSpace("a");
        //ans = s.longestPalindromeManacher("babcbabcbaccba");
        ans = s.longestPalindromeManacher("a");
        System.out.println(ans);
    }
}
