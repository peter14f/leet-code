import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordDistance {

    HashMap<String, List<Integer>> indices = new HashMap<String, List<Integer>>();
    
    public WordDistance(String[] words) {
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            
            if (indices.containsKey(word)) {
                indices.get(word).add(i);
            }
            else {
                List<Integer> indexList = new ArrayList<Integer>();
                indexList.add(i);
                indices.put(word, indexList);
            }
        }
    }
    
    // we can still assume that word1 and word2 are different and are in the input array
    public int shortest(String word1, String word2) {
        
        List<Integer> indices1 = indices.get(word1);
        List<Integer> indices2 = indices.get(word2);
        
        int minDistance = Integer.MAX_VALUE;
        
        /* since indices1 and indices2 are both sorted
         * we can find the minimum distance in O(a+b) instead of O(ab)
         */
        int i=0;
        int j=0;
        
        while (i < indices1.size() && j < indices2.size()) {
            int distance = Math.abs(indices1.get(i) - indices2.get(j));
            if (distance < minDistance)
                minDistance = distance;
            
            if (indices1.get(i) < indices2.get(j))
                i++;
            else
                j++;
        }
        
        return minDistance;
    }
    
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance wd = new WordDistance(words);
        
        int d = wd.shortest("coding", "makes");
        System.out.println(d);
    }

}
