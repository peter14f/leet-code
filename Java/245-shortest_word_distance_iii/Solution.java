
public class Solution {

    // may assume word1 and word2 are in the input string array
    // word1 and word2 may be the same and they represent two individual words in the list
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int lastSeen1 = -1;
        int lastSeen2 = -1;
        
        boolean same = word1.equals(word2);
        
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                
                if (same) {
                    if (lastSeen1 != -1) {
                        int dist = i - lastSeen1;
                        if (dist < minDistance)
                            minDistance = dist;
                    }
                }
                else {
                    if (lastSeen2 != -1) {
                        int dist = i - lastSeen2;
                        if (dist < minDistance)
                            minDistance = dist;
                    }
                }
                lastSeen1 = i;
            }
            else if (words[i].equals(word2)) {
                if (lastSeen1 != -1) {
                    int dist = i - lastSeen1;
                    if (dist < minDistance)
                        minDistance = dist;
                }
                lastSeen2 = i;
            }
        }
        
        return minDistance;
    }
    
    public static void main(String[] args) {
        
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        Solution sol = new Solution();
        int d = sol.shortestWordDistance(words, "coding", "makes");
        System.out.println(d);
    }

}
