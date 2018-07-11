import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public String reorganizeString(String S) {
        int[] count = new int[26];

        for (int i=0; i<S.length(); i++) {
            count[S.charAt(i)-'a']++;
        }

        int[] lastAppearIndex = new int[26];
        Entry[] entries = new Entry[26];
        for (int i=0; i<count.length; i++) {
            entries[i] = new Entry((char)(i+'a'), count[i]);
            lastAppearIndex[i] = -1;
        }

        StringBuilder sb = new StringBuilder();

        while (sb.length() < S.length()) {
            Arrays.sort(entries, Comparator.reverseOrder());
            boolean foundChar = false;

            for (int i=0; i<26; i++) {
                Entry e = entries[i];
                if (e.cnt == 0)
                    break;

                if (lastAppearIndex[e.c-'a'] == -1 || 
                        sb.length() - lastAppearIndex[e.c - 'a'] > 1) {
                    e.cnt--;
                    sb.append(e.c);
                    lastAppearIndex[e.c - 'a'] = sb.length()-1;
                    foundChar = true;
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

        public Entry(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
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
        String s = "aabb";
        Solution sol = new Solution();
        String ans = sol.reorganizeString(s);
        System.out.println(ans);
    }

    
}
