
public class Trie {

    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            
            if (!cur.hasChild(c)) {
                cur.insertChild(c);
            }
            
            cur = cur.getChild(c);
        }
        
        cur.insertChild('\0');
    }
    
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            
            if (!cur.hasChild(c))
                return false;
            
            cur = cur.getChild(c);
        }
        
        return cur.hasChild('\0');
    }
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            
            if (!cur.hasChild(c))
                return false;
            
            cur = cur.getChild(c);
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("Peter");
        boolean hasWord = t.search("Pet");
        System.out.println(hasWord);
        boolean hasPrefix = t.startsWith("Pet");
        System.out.println(hasPrefix);
    }

}
