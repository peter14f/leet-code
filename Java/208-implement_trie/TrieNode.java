import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children;
    
    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
    }
    
    public boolean hasChild(char c) {
        return this.children.containsKey(c);
    }
    
    public void insertChild(char c) {
        if (this.hasChild(c))
            return;
        
        TrieNode newChild = new TrieNode();
        this.children.put(c, newChild);
    }
    
    public TrieNode getChild(char c) {
        return this.children.get(c);
    }
    
}
