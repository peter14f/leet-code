
public class Solution {

    public int shortestDistance(String[] words, String word1, String word2) {
        int latest1 = Integer.MIN_VALUE;
        int latest2 = Integer.MIN_VALUE;
        int minDistance = Integer.MAX_VALUE;
        
        for (int i=0; i<words.length; i++) {
            if (word1.equals(words[i])) {
                if (latest2 >= 0) {
                    int distance = i - latest2;
                    if (distance < minDistance)
                        minDistance = distance;
                }
                
                latest1 = i;
            }
            else if (word2.equals(words[i])) {
                if (latest1 >= 0) {
                    int distance = i - latest1;
                    if (distance < minDistance)
                        minDistance = distance;
                }
                
                latest2 = i;
            }
        }
        
        return minDistance;
    }
    
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        
        Solution sol = new Solution();
        int distance = sol.shortestDistance(words, "coding", "practice");
        
        System.out.println(distance);
    }

}
