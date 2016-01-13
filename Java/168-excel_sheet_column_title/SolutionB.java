
public class SolutionB {

    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        
        while (n > 0) {
            n--;
            int num = n%26;
            n = n / 26;
            sb.append((char)('A' + num));
        }
        
        sb.reverse();
        return sb.toString();
    }
    
    public static void main(String[] args) {
        SolutionB sol = new SolutionB();
        String str = sol.convertToTitle(676);
        System.out.println(str);
    }

}
