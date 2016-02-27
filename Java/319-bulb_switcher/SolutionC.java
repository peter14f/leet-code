
public class SolutionC {

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
    
    public static void main(String[] args) {
        SolutionC sol = new SolutionC();
        int x = sol.bulbSwitch(9);
        System.out.println(x);
    }

}
