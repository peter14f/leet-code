import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    // All input strings are given in lowercase letters
    public String rearrangeString(String s, int k) {
        char[] ch = s.toCharArray();

        int totalCnt = 0;
        int[] count = new int[26];

        for (char c : ch) {
            count[c - 'a']++;
            totalCnt++;
        }

        Entry[] entries = new Entry[26];
        int[] lastIndex = new int[26];
        for (int i=0; i<26; i++) {
            entries[i] = new Entry((char)('a'+ i), count[i]);
            lastIndex[i] = -1;
        }

        StringBuilder sb = new StringBuilder();

        int j=0;
        while (totalCnt > 0) {
            Arrays.sort(entries, Comparator.reverseOrder());
            boolean foundChar = false;

            for (int i=0; i<26; i++) {
                Entry e = entries[i];

                if (e.cnt == 0)
                    break;

                if (lastIndex[e.c-'a'] == -1 || j-lastIndex[e.c-'a'] >= k) {
                    foundChar = true;
                    e.cnt--;
                    lastIndex[e.c-'a'] = j;
                    totalCnt--;
                    sb.append(e.c);
                    j++;
                    break;
                }
            }

            if (!foundChar) {
                return "";
            }
        }

        return sb.toString();
    }

    static class Entry implements Comparable<Entry> {
        char c;
        int cnt;
        public Entry(char c, int count) {
            this.c = c;
            this.cnt = count;
        }
        @Override
        public int compareTo(Entry o) {
            return this.cnt - o.cnt;
        }
        @Override
        public String toString() {
            return this.c + "=" + this.cnt;
        }
    }

    public static void main(String[] args) {
        String s = "aaaabbc";
        String s1 = "aabbcc";
        Solution sol = new Solution();
        String ans = sol.rearrangeString(s1, 3);
        System.out.println(ans);
    }

}
