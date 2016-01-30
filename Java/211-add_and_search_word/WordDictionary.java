

public class WordDictionary {

    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            
            cur = cur.children[c - 'a'];
        }
        
        cur.isLeaf = true;
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode cur = root;
        
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            
            if (c == '.') {
                return dfsCanFindAMatch(i, cur, word);
            }
            
            cur = cur.children[c - 'a'];
            
            if (cur == null)
                return false;
        }
        
        return cur.isLeaf;
    }
    
    private boolean dfsCanFindAMatch(int i, TrieNode node, String word) {
        char c = word.charAt(i);
        
        if (c=='.') {
            for (char ch='a'; ch<='z'; ch++) {
                if (node.children[ch-'a'] != null) {
                    if (i == word.length()-1) {
                        if (node.children[ch-'a'].isLeaf)
                            return true;
                    }
                    else {
                        if (dfsCanFindAMatch(i+1, node.children[ch-'a'], word))
                            return true;
                    }
                }
            }
            
            return false;
        }
        else {
            node = node.children[c-'a'];
            
            if (node==null)
                return false;
            else {
                if (i == word.length() - 1)
                    return node.isLeaf;
                else
                    return dfsCanFindAMatch(i+1, node, word);
            }
        }
    }
    
    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("ab");
        boolean dotbc = wd.search(".");
        System.out.println(dotbc);
    }

}
