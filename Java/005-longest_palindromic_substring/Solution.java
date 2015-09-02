import java.util.Arrays;


public class Solution {
    private String transform(String s) {
        StringBuffer sb = new StringBuffer();
        
        sb.append("#");
        char[] s_arr = s.toCharArray();
        
        for (int i=0; i<s_arr.length; i++) {
            sb.append(s_arr[i]);
            sb.append("#");
        }
        
        return sb.toString();
    }
    
    public String manacher(String s) {
        String t = transform(s);
        
        char[] t_arr = t.toCharArray();
        
        int center = 0;
        int right = 0;
        
        int[] p = new int[t_arr.length];
        int n = t_arr.length;
        
        for (int i=0; i<n; i++) {
            int i_prime = center - (i-center);
            
            if (right > i) {
                p[i] = Math.min(right-i, p[i_prime]);
            }
            
            while (i + 1 + p[i] < n &&
                    i - 1 - p[i] >=0 &&
                    t_arr[i + 1 + p[i]] == t_arr[i - 1 - p[i]]) {
                p[i]++;
            }
            
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        
        int max = 0;
        int start = 0;
        for (int i=0; i<n; i++) {
            if (p[i] > max) {
                max = p[i];
                start = i;
            }
        }
        
        StringBuffer sb = new StringBuffer();
        
        for (int i=0; i<max; i++) {
            int index = start - max + i;
            if (t_arr[index] != '#')
                sb.append(t_arr[index]);
        }
        
        if (t_arr[start] != '#')
            sb.append(t_arr[start]);
        
        for (int i=0; i<max; i++) {
            int index = start + 1 + i;
            if (t_arr[index] != '#')
                sb.append(t_arr[index]);
        }
        
        return sb.toString();
    }
    
    /* The basic idea of ​​the algorithm: 
     * 
     * at any time we keep the center of the longest palindrome relating 
     * to the right end of the line. When we add character to the end, we 
     * have two options for what happens next:
     *
     *
     * Main palindrome expands. Then we simply increase its radius value and return.
     * Main palindrome does not expand. This means that we will need to go 
     * forward to find new primary palindrome. Thus, each time a new cell 
     * initializing with number in the cell that is symmetrical to the center 
     * of the previous main palindrome. Once it turned out that we can extend 
     * the current palindrome, which means that it is leftmost of the related 
     * to the end of the string and then it will become the new main palindrome.
     */
    public String longestPalindrome_Manacher(String s) {
        if (s.length() == 0)
            return "";
        
        String t = transform(s);
        
        char[] t_arr = t.toCharArray();
        int[] p = new int[t.length()];
        
        int C = 0;
        int R = 0;
        int n = t.length();
        
        System.out.println(Arrays.toString(t_arr));
        
        for (int i=1; i < n-1; i++) {
            int i_mirror = 2*C - i; // equals to i' = C - (i-C)
        
            System.out.println("C: " + C + " R: " + R + " i:" + i);
            
            if (R > i) {
                p[i] = Math.min(R-i, p[i_mirror]);
            }
            else {
                p[i] = 0;
            }
            
            // attempt to expand palindrome centered at i
            while (i+1+p[i] < t_arr.length &&
                    i-1-p[i] >= 0 &&
                    t_arr[i + 1 + p[i]] == t_arr[i - 1 - p[i]]) {
                p[i]++;
            }
            
            System.out.print("p[" + i + "]=" + p[i] + " ");
            System.out.println(Arrays.toString(p));
            
            // if palindrome centered at i expand past R,
            // adjust center based on expanded palindrome.
            if (i + p[i] > R) {
                C = i;
                R = i + p[i];
            }
        }
        
        System.out.println(Arrays.toString(p));
        
        return null;
    }
    
    public String longestPalindrome2(String s) {
        // 0123
        // abba
        
        // 012
        // aba
        char[] s_arr = s.toCharArray();
        int max = 1;
        int center = 0;
        
        for (int c=0; c < s.length(); c++) {
            // center at index c
            int left = c-1;
            int right = c+1;
            
            int length = 1;
            while (left >=0 && right < s.length()) {
                if (s_arr[left] == s_arr[right]) {
                    length += 2;
                }
                else {
                    break;
                }
                
                left--;
                right++;
            }
            
            if (length > max) {
                max = length;
                center = c;
            }
            
            // center between index c and index (c + 1)
            left = c;
            right = c+1;
            length = 0;
            
            while (left >=0 && right < s.length()) {
                if (s_arr[left] == s_arr[right]) {
                    length += 2;
                }
                else {
                    break;
                }
                
                left--;
                right++;
            }
            
            if (length > max) {
                max = length;
                center = c;
            }
        }
        
        //         01
        // max = 2 aa
        //         0123 c=1
        // max = 4 baab
        if (max % 2 == 0) {
            int left_one = center;
            int start = left_one - (max/2 - 1);
            return s.substring(start, start+max);
        }
        else {
            int start = center - (max-1)/2;
            return s.substring(start, start+max);
        }
    }
    
    public String longestPalindrome(String s) {
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        
        char[] s_arr = s.toCharArray();
        int max = 1;
        int start = 0;
        
        for (int offset=0; offset < s_arr.length; offset++) {
            for (int row=0; row < s_arr.length; row++) {
                if (offset == 0) {
                    palindrome[row][row+offset] = true;
                }
                else if (offset == 1) {
                    if (row+offset < s_arr.length &&
                        s_arr[row] == s_arr[row+offset]) {
                        palindrome[row][row+offset] = true;
                        
                        if (offset+1 > max) {
                            max = offset + 1;
                            start = row;
                        }
                    }
                }
                else {
                    if (row+offset < s_arr.length &&
                          palindrome[row+1][row+offset-1] &&
                          s_arr[row] == s_arr[row+offset]) {
                        
                        palindrome[row][row+offset] = true;
                        
                        if (offset+1 > max) {
                            max = offset + 1;
                            start = row;
                        }
                    }
                }
            }
        }
        
        return s.substring(start, start + max);
    }
    
    public String longestPalindrome_slow(String s) {
        if (s.length()==0)
            return s;
        
        /* tab[i][j] represents the length of the palindromic substring starting
         *  at index i and ending at index j
         */
        int[][] tab = new int[s.length()][s.length()];
        char[] s_arr = s.toCharArray();
        
        int max_length = 1;
        int start = 0;
        
        // distance from the diagonal
        for (int distance=0; distance < s_arr.length; distance++) {
            for (int row=0; row < s_arr.length; row++) {
                if (row+distance >= s_arr.length) {
                    break;
                }
                
                int substring_length = 0;
                
                if (distance==0) {
                    //tab[row][row+distance] = 1;
                    substring_length = 1;
                }
                else if (distance==1 && s_arr[row+distance] == s_arr[row]) {
                    //tab[row][row+distance] = 2;
                    substring_length = 2;
                }
                else {
                    if (row+1 < s_arr.length && row+distance-1 >= 0) {
                        if (tab[row+1][row+distance-1] > 0 && s_arr[row] == s_arr[row+distance]) {
                            //tab[row][row+distance] = tab[row+1][row+distance-1] + 2;
                            substring_length = tab[row+1][row+distance-1] + 2;
                        }
                    }
                }
                
                tab[row][row+distance] = substring_length;
                
                if (substring_length > max_length) {
                    start = row;
                    max_length = substring_length;
                }
            }
        }
        
        System.out.println(Arrays.deepToString(tab));
        
        return s.substring(start, start+max_length);
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        //String s = "zabcba";
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        //String s = "babcbabcbaccba";
        String ans = sol.manacher(s);
        System.out.println(ans);
    }

}
