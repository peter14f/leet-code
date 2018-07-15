import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AutocompleteSystem {

    private Trie trie;
    private StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.trie = new Trie();
        this.sb = new StringBuilder();
        for (int i=0; i<sentences.length; i++) {
            this.trie.addWord(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {

        List<String> ans = new ArrayList<String>();
        if (c == '#') {
            if (sb.length() == 0) {
                return ans;
            } else {
                this.trie.addWord(this.sb.toString(), 1);
                this.sb = new StringBuilder();
                return ans;
            }
            
        } else {
            this.sb.append(c);
        }
        List<Entry> allWords = this.trie.getAllWordsWithPrefix(this.sb.toString());

        Collections.sort(allWords, Comparator.reverseOrder());
        for (int i=0; i<allWords.size(); i++) {
            ans.add(allWords.get(i).s);
            if (ans.size() >= 3) {
                break;
            }
        }
        return ans;
    }

    static class Trie {
        TrieNode root;
        public Trie() {
            this.root = new TrieNode('-');
            
        }
        public void addWord(String word, int cnt) {
            TrieNode cur = root;
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                int index;
                if (c == ' ') {
                    index = 0;
                } else if (c >= 'a' && c <= 'z') {
                    index = c - 'a' + 1;
                } else {
                    throw new IllegalArgumentException();
                }
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode(c);
                }
                cur = cur.children[index];
                if (i==word.length() - 1) {
                    cur.cnt+=cnt;
                }
            }
        }
        public List<Entry> getAllWordsWithPrefix(String prefix) {
            TrieNode cur = root;
            List<Entry> ans = new ArrayList<>();
            for (int i=0; i<prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index;
                if (c == ' ') {
                    index = 0;
                } else if (c >= 'a' && c <= 'z') {
                    index = c - 'a' + 1;
                } else {
                    throw new IllegalArgumentException();
                }
                if (cur.children[index] == null) {
                    return ans;
                }
                cur = cur.children[index];
            }
            if (cur != null) {
                dfsGetAllWordsFrom(cur, ans, prefix, "");
            }
            return ans;
        }
        private void dfsGetAllWordsFrom(TrieNode cur, List<Entry> ans, String prefix, String s) {
            if (cur.cnt > 0) {
                ans.add(new Entry(prefix + s, cur.cnt));
            }
            for (int i=0; i<cur.children.length; i++) {
                if (cur.children[i] != null) {
                    dfsGetAllWordsFrom(cur.children[i], ans, prefix, s + cur.children[i].c);
                }
            }
        }
    }

    static class Entry implements Comparable<Entry> {
        String s;
        int cnt;
        public Entry(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Entry o) {
            return this.cnt - o.cnt;
        }
        
    }

    static class TrieNode {
        char c;
        TrieNode[] children;
        int cnt;
        public TrieNode(char c) {
            this.c = c;
            this.children = new TrieNode[27];
        }
    }

    public static void main(String[] args) {
        
        AutocompleteSystem sol = new AutocompleteSystem(
                new String[] {"i love you", "island","ironman", "i love leetcode"},
                new int[] {5,3,2,2});
        List<String> a = sol.input('i');
        System.out.println(a);
        a = sol.input(' ');
        System.out.println(a);
        a = sol.input('a');
        System.out.println(a);
        a = sol.input('#');
        System.out.println(a);
        a = sol.input('i');
        System.out.println(a);
        a = sol.input(' ');
        System.out.println(a);
        a = sol.input('a');
        System.out.println(a);
    }

}
