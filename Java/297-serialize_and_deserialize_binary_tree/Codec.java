import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        
        TreeNode cur = root;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(cur);
        
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            
            if (n == null) {
                sb.append("null");
                sb.append(",");
                continue;
            }
            
            sb.append(n.val);
            sb.append(",");
            
            q.offer(n.left);
            q.offer(n.right);
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        int start = 0;
        int end = 0;
        
        while (start < data.length()) {
            if (data.charAt(end) != ',') {
                end++;
                continue;
            }
            
            String s = data.substring(start, end);
            
            if (root==null) {
                if (s.equals("null"))
                    return null;
                else {
                    root = new TreeNode(Integer.parseInt(s));
                    q.offer(root);
                }
            }
            else {
                TreeNode node = q.poll();
                
                if (!s.equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(s));
                    q.offer(node.left);
                }
                
                start = end+1;
                end = start;
                
                while (data.charAt(end) != ',')
                    end++;
                
                String rightStr = data.substring(start, end);
                
                if (!rightStr.equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(rightStr));
                    q.offer(node.right);
                }
            }
            
            start = end+1;
            end = start;
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        Codec codec = new Codec();
        
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        
        a.right = b;
        b.left = c;
        
        String s = codec.serialize(a);
        
        System.out.println(s);
        
        TreeNode root = codec.deserialize(s);
        
        System.out.println(root.val);
        System.out.println(root.right.val);
        System.out.println(root.right.left.val);
    }

}
