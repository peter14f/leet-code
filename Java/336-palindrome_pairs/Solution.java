import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> ans = new ArrayList<>();

        if (words.length == 0) {
            return ans;
        }

        Map<String, Integer> reverseWordToIndex = new HashMap<>();

        for (int i=0; i<words.length; i++) {
            String word = words[i];
            String reverse = reverse(word);
            reverseWordToIndex.put(reverse, i);
        }

        for (int i=0; i<words.length; i++) {
            String word = words[i];
            if (word.length() == 0) continue;

            // suffix
            for (int l=1; l<word.length(); l++) {
                String suffix = word.substring(0, l);
                
                if (isPalindrome(suffix)) {
                    String postfix = word.substring(l);
                    if (reverseWordToIndex.containsKey(postfix)) {
                        // (postfix reversed) + (suffix + postfix) is a palindrome
                        List<Integer> p = new ArrayList<>();

                        p.add(reverseWordToIndex.get(postfix));
                        p.add(i);
                        ans.add(p);
                    }
                }
            }

            // entire word
            if (reverseWordToIndex.containsKey(word) && 
                    reverseWordToIndex.get(word) != i) {
                // word + reverseWorld is a palindrome
                List<Integer> p = new ArrayList<>();
                p.add(i);
                p.add(reverseWordToIndex.get(word));
                ans.add(p);
            }

            // does empty string exist?
            if (isPalindrome(word) && reverseWordToIndex.containsKey("")) {
                // i + empty
                List<Integer> p1 = new ArrayList<>();
                p1.add(i);
                p1.add(reverseWordToIndex.get(""));
                ans.add(p1);
                
                // empty + i
                List<Integer> p2 = new ArrayList<>();
                p2.add(reverseWordToIndex.get(""));
                p2.add(i);
                ans.add(p2);
            }

            // postfix
            for (int l=1; l<word.length(); l++) {
                String postfix = word.substring(word.length()-l);
                
                if (isPalindrome(postfix)) {
                    String suffix = word.substring(0, word.length()-l);
                    if (reverseWordToIndex.containsKey(suffix)) {
                        // (suffix + postfix) + (suffix reversed) is a palindrome
                        List<Integer> p = new ArrayList<>();
                        p.add(i);
                        p.add(reverseWordToIndex.get(suffix));
                        ans.add(p);
                    }
                }
            }
            
        }
        return ans;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {
          "bat", "tab", "cat"
        };
        String[] words2 = {
                "abcd", "dcba", "lls", "s", "sssll"
              };
        String[] words3 = {
                "a", ""
        };
        String[] words4 = {
                "a", "abc", "aba", ""
        };
        Solution sol = new Solution();
        List<List<Integer>> ans = sol.palindromePairs(words4);
        System.out.println(ans);
    }

}
