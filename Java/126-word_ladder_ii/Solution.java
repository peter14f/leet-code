import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {

    // find all shortest transformations
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        
        List<String> q = new ArrayList<String>();
        HashSet<String> dup = new HashSet<String>();
        q.add(beginWord);
        
        int nextLevelSize = 0;
        int curLevelSize = 1;
        int levels = 0;
        int level = 1;
        
        List<List<String>> levelWords = new ArrayList<List<String>>();
        List<String> curLevelWords = new ArrayList<String>();
        
        HashMap<String, HashSet<String>> neighbors = new HashMap<String, HashSet<String>>();
        
        while (!q.isEmpty()) {
            
            String cur = q.remove(0);
            char[] arr = cur.toCharArray();
            curLevelWords.add(cur);
            
            for (int i=0; i<arr.length; i++) {
                char oldC = arr[i]; 
                        
                for (char c='a'; c<='z'; c++) {
                    if (c == oldC)
                        continue;
                    
                    arr[i] = c;
                    
                    
                    String modified = new String(arr);
                    boolean reachedEnd = modified.equals(endWord);
                    
                    if (wordList.contains(modified) || reachedEnd) {
                        if (neighbors.containsKey(cur)) {
                            if (!neighbors.get(cur).contains(modified))
                                neighbors.get(cur).add(modified);
                        }
                        else {
                            HashSet<String> myNeighbors = new HashSet<String>();
                            myNeighbors.add(modified);
                            neighbors.put(cur, myNeighbors);
                        }
                        
                        if (dup.contains(modified))
                            continue;
                        
                        if (levels == 0 && reachedEnd) {
                            levels = level + 1;
                        }
                        
                        q.add(modified);
                        dup.add(modified);
                        
                        nextLevelSize++;
                    }
                    
                }
                
                arr[i] = oldC;
            }
            
            curLevelSize--;
            
            if (curLevelSize==0) {
                levelWords.add(new ArrayList<String>(curLevelWords));
                curLevelWords.clear();
                
                curLevelSize = nextLevelSize;
                nextLevelSize = 0;
                level++;
                if (level == levels)
                    break;
            }
        }
        
        
        System.out.println("levels=" + levels);
        System.out.println(neighbors.size());
        System.out.println(levelWords);
        
        List<List<String>> ans = new ArrayList<List<String>>();
        dfs(levelWords, 0, new ArrayList<String>(), neighbors, ans, levels, endWord);
        return ans;
    }
    
    private void dfs(List<List<String>> levelWords, int index, List<String> curList,
                     HashMap<String, HashSet<String>> neighbors, List<List<String>> ans,
                     int levels, String endWord) {
        
        List<String> words = levelWords.get(index);
        
        int origSize = words.size();
        
        if (origSize == 0)
            return;
        
        String last = null;
        if (!curList.isEmpty()) {
            last = curList.get(curList.size() - 1);
        }
        
        for (int i=0; i<origSize; i++) {
            String s = words.get(i);
            
            if (last == null || neighbors.get(last).contains(s)) {
                curList.add(s);
                
                if (curList.size() < levels - 1) {
                    dfs(levelWords, index+1, curList, neighbors, ans, levels, endWord);
                }
                else {
                    if (neighbors.containsKey(s) && neighbors.get(s).contains(endWord)) {
                        curList.add(endWord);
                        ans.add(new ArrayList<String>(curList));
                        curList.remove(curList.size() - 1);
                    }
                }
                
                curList.remove(curList.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        Set<String> dict = new HashSet<String>();
        String[] words = {"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
        dict.addAll(Arrays.asList(words));
        
        List<List<String>> ans = sol.findLadders("nape", "mild", dict);
        
        System.out.println(ans);
    }

}
