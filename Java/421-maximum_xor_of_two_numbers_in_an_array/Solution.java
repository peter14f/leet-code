import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int findMaximumXOR(int[] nums) {
        int maxXor = 0;

        int maskUpToNow = 0;
        for (int i=31; i>=0; i--) {
            int mask = 1<<i;
            int curGuessedMax = maxXor | mask;

            Set<Integer> set = new HashSet<>();
            maskUpToNow = maskUpToNow | mask; // include one more bit in mask
            for (int num : nums) {
                int numMasked = maskUpToNow & num;
                if (!set.contains(numMasked)) {
                    set.add(numMasked);
                }
            }

            boolean guessedWrong = true;
            for (int numMasked : set) {
                if (set.contains(numMasked ^ curGuessedMax)) {
                    if (guessedWrong)
                        guessedWrong = false;
                }
            }
            if (!guessedWrong) {
                maxXor = curGuessedMax;
            }
        }

        return maxXor;
    }

    public int findMaximumXOR2(int[] nums) {
        Trie trie = new Trie();

        for (int num : nums) {
            trie.insert(num);
        }

        int max = 0;
        for (int num: nums) {
            int XOR = trie.maxXORWith(num);
            max = Math.max(XOR, max);
        }
        return max;
    }

    static class Trie {
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }
        public void insert(int x) {
            TrieNode cur = root;
            for (int i=31; i>=0; i--) {
                if ((x & (1 << i)) > 0) {
                    // bit is 1
                    if (cur.one == null) {
                        cur.one = new TrieNode();
                    }
                    cur = cur.one;
                } else {
                    // bit is 0
                    if (cur.zero == null) {
                        cur.zero = new TrieNode();
                    }
                    cur = cur.zero;
                }
            }
        }

        public int maxXORWith(int x) {
            TrieNode cur = root;
            int xor = 0;
            for (int i=31; i>=0; i--) {
                if ((x & (1 << i)) > 0) {
                    // bit is 1, want to go to zero if possible
                    if (cur.zero != null) {
                        cur = cur.zero;
                        xor = xor | (1<<i);
                    } else {
                        cur = cur.one;
                    }
                } else {
                    // bit is 0, want to go to one if possible
                    if (cur.one != null) {
                        cur = cur.one;
                        xor = xor | (1<<i);
                    } else {
                        cur = cur.zero;
                    }
                }
            }
            return xor;
        }
    }

    static class TrieNode {
        TrieNode zero;
        TrieNode one;
        public TrieNode() {
            
        }
    }

    public static void main(String[] args) {
        int[] nums = {14, 11, 7, 2};
        Solution sol = new Solution();
        int maxXOR = sol.findMaximumXOR2(nums);
        System.out.println(maxXOR);
    }

}
