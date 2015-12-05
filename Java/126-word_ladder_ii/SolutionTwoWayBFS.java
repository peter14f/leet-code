import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SolutionTwoWayBFS {

    public List<List<String>> findLadders(
            String beginWord, 
            String endWord, 
            Set<String> wordList) {
        
        List<HashSet<String>> levelWords = new ArrayList<HashSet<String>>();
        
        List<String> q = new ArrayList<String>();
        HashSet<String> dup = new HashSet<String>();
        HashMap<String, HashSet<String>> neighbors = 
                new HashMap<String, HashSet<String>>();
        
        q.add(beginWord);
        int curLevelSize = 1;
        int nextLevelSize = 0;
        int levels = 0;
        int level = 1;
        
        while (!q.isEmpty()) {
            String cur = q.remove(0);
            char[] arr = cur.toCharArray();
            
            for (int i=0; i<arr.length; i++) {
                char oldChar = arr[i];
                
                for (char c='a'; c<='z'; c++) {
                    if (c == oldChar)
                        continue;
                    
                    arr[i] = c;
                    String modified = new String(arr);
                    boolean reachedEnd = modified.equals(endWord);
                    
                    if (wordList.contains(modified) || reachedEnd) {
                        if (!neighbors.containsKey(cur))
                            neighbors.put(cur, new HashSet<String>());
                        
                        if (!neighbors.get(cur).contains(modified))
                            neighbors.get(cur).add(modified);
                        
                        if (dup.contains(modified)) {
                            continue;
                        }
                        
                        if (reachedEnd && levels == 0) {
                            levels = level + 1;
                        }
                        
                        q.add(modified);
                        
                        if (!reachedEnd)
                            dup.add(modified);
                        
                        nextLevelSize++;
                    }
                    
                }
                
                arr[i] = oldChar;
            }
            
            curLevelSize--;
            
            if (levelWords.size() < level) {
                HashSet<String> words = new HashSet<String>();
                words.add(cur);
                levelWords.add(words);
            }
            else {
                levelWords.get(level-1).add(cur);
            }
            
            if (curLevelSize == 0) {
                if (levels > 0)
                    break;
                
                level++;
                curLevelSize = nextLevelSize;
                nextLevelSize = 0;
            }
        }
        
        List<List<String>> ans = new ArrayList<List<String>>();
        
        if (levels == 0)
            return ans;
        
        if (levels > 2) {
            q.clear();
            dup.clear();
            
            q.add(endWord);
            curLevelSize = 1;
            nextLevelSize = 0;
            level = 0;
            int index = levels - 2;
            HashSet<String> replacedWords = new HashSet<String>();
            
            while (!q.isEmpty()) {
                String cur = q.remove(0);
                char[] arr = cur.toCharArray();
                
                for (int i=0; i<arr.length; i++) {
                    char oldC = arr[i];
                    
                    for (char c='a'; c<='z'; c++) {
                        if (c==oldC)
                            continue;
                        
                        arr[i] = c;
                        
                        String modified = new String(arr);
                        boolean reachedEnd = false;
                        
                        if (level == levels - 1)
                            reachedEnd = modified.equals(beginWord);
                        
                        if (wordList.contains(modified) || reachedEnd) {
                            if (dup.contains(modified))
                                continue;
                            
                            if (levelWords.get(index).contains(modified)) {
                                replacedWords.add(modified);
                                
                                q.add(modified);
                                dup.add(modified);
                                nextLevelSize++;
                            }
                        }
                    }
                    
                    arr[i] = oldC;
                }
                
                curLevelSize--;
                
                if (curLevelSize == 0) {
                    if (index > 0) {
                        HashSet<String> oldWords = levelWords.get(index);
                        levelWords.set(index, replacedWords);
                        replacedWords = oldWords;
                    }
                    
                    index--;
                    replacedWords.clear();
                    
                    level++;
                    if (index < 0)
                        break;
                    
                    curLevelSize = nextLevelSize;
                    nextLevelSize = 0;
                }
            }
        }
        dfs(levelWords, new ArrayList<String>(), neighbors, levels, 0, ans, endWord);
        
        return ans;
    }
    
    private void dfs(
            List<HashSet<String>> levelWords, 
            List<String> curList, 
            HashMap<String, HashSet<String>> neighbors, 
            int levels, 
            int index, 
            List<List<String>> ans, 
            String endWord) {
        
        HashSet<String> words = levelWords.get(index);
        
        for (String s: words) {
            
            String prevWord = null;
            
            if (!curList.isEmpty())
                prevWord = curList.get(curList.size() - 1);
            
            if (curList.isEmpty() || (neighbors.containsKey(prevWord) && neighbors.get(prevWord).contains(s))) {
                curList.add(s);
                
                if (curList.size() < levels - 1) {
                    dfs(levelWords, curList, neighbors, levels, index+1, ans, endWord);
                }
                else {
                    if (neighbors.get(s).contains(endWord)) {
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
        Set<String> dict = new HashSet<String>();
        //String[] words = {"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
        //String[] words = {"a", "b", "c"};
        String[] words = {"hot","cog","dog","tot","hog","hop","pot","dot"};
        dict.addAll(Arrays.asList(words));

        SolutionTwoWayBFS sol = new SolutionTwoWayBFS();
        //List<List<String>> ans = sol.findLadders("nape", "mild", dict);
        List<List<String>> ans = sol.findLadders("hot", "dog", dict);
        System.out.println(ans);
    }

}
