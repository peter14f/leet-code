import java.util.ArrayList;
import java.util.List;


public class Codec {
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        
        int n = strs.size();
        
        if (n == 0) {
            sb.append("0:");
            return sb.toString();
        }
        
        sb.append(n + ":");
        
        for (int i=0; i<strs.size(); i++) {
            sb.append(strs.get(i).length());
            sb.append(",");
        }
        
        for (String s: strs) {
            sb.append(s);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i=0;
        while (s.charAt(i) != ':') {
            i++;
        }
        
        int n = Integer.parseInt(s.substring(0, i));
        
        List<String> strs = new ArrayList<String>();
        
        if (n==0)
            return strs;
        
        List<Integer> lengths = new ArrayList<Integer>();
        i++;
        int j = i+1;
        
        for (int z=0; z<n; z++) {
            while (s.charAt(j) != ',') {
                j++;
            }
            
            int l = Integer.parseInt(s.substring(i, j));
            lengths.add(l);
            j++;
            i = j;
        }
        
        for (int l : lengths) {
            StringBuffer sb = new StringBuffer();
            for (int z=0; z<l; z++) {
                sb.append(s.charAt(i));
                i++;
            }
            strs.add(sb.toString());
        }
        
        return strs;
    }
    
    public static void main(String[] args) {
        Codec code = new Codec();
        
        List<String> strs = new ArrayList<String>();
        strs.add("!PETER:,");
        strs.add("!ClaireHo,:!@");
        
        String c = code.encode(strs);
        System.out.println(c);
        
        List<String> check = code.decode(c);
        System.out.println(check);
        
    }

}
