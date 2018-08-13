import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>(source.length);

        boolean skip = false;

        StringBuilder sb = new StringBuilder();
        for (String s : source) {
            if (!skip) {
                sb = new StringBuilder();
            }
            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if (skip && c == '*') {
                    if (i+1 < s.length() && s.charAt(i+1) == '/') {
                        skip = false;
                        i++;
                        continue;
                    }
                } else if (!skip && c == '/') {
                    if (i+1 < s.length()) {
                        if (s.charAt(i+1) == '/') {
                            break;
                        } else if (s.charAt(i+1) == '*') {
                            skip = true;
                            i++;
                        }
                    }
                }

                if (!skip) {
                    sb.append(c);
                }
            }

            if (sb.length() > 0 && !skip) {
                ans.add(sb.toString());
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] source = {
                "a/*comment",
                "line",
                "more_comment*/b"
        };
        List<String> ans = sol.removeComments(source);
        System.out.println(ans);
    }

}
