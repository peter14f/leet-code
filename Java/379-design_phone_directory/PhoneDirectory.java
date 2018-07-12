import java.util.HashSet;
import java.util.Set;

public class PhoneDirectory {

    private int size;
    private Set<Integer> released;

    /** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.size = maxNumbers;
        this.released = new HashSet<Integer>();
        for (int i=0; i<maxNumbers; i++) {
            this.released.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (this.released.isEmpty()) {
            return -1;
        }
        int num = this.released.iterator().next();
        this.released.remove(num);
        return num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return this.released.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number >= this.size) {
            throw new IllegalArgumentException();
        }
        this.released.add(number);
    }

    public static void main(String[] args) {
        // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
        PhoneDirectory directory = new PhoneDirectory(3);

        // It can return any available phone number. Here we assume it returns 0.
        directory.get();

        // Assume it returns 1.
        directory.get();

        // It returns 2, the only number that is left.
        directory.get();

        System.out.println(directory.check(0));
        System.out.println(directory.check(1));
        System.out.println(directory.check(2));
    }

}
