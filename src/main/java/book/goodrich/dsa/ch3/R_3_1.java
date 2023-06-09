package book.goodrich.dsa.ch3;

/**
 *  Give the next five pseudorandom numbers generated by the process
 *  described on page 113, with a = 12, b = 5, and n = 100, and 92 as
 *  the seed for cur.
 * <p>
 *  <b>hint</b> : next = (a * cur + b) % n
 */

public class R_3_1 {
    private static int a = 12;
    private static int b = 5;
    private static int n = 100;

    public static void main(String[] args) {
        int cur = 92;
        for (int i = 0; i < 5; i++) {
            cur = nextRandom(cur);
            System.out.print(cur + ", ");
        }
    }

    public static int nextRandom(int c) {
        return (a * c + b) % n;
    }
}
