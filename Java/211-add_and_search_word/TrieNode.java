

public class TrieNode {
    boolean isLeaf;
    TrieNode[] children;
    
    public TrieNode() {
        isLeaf = false;
        children = new TrieNode[26];
    }
}
