import java.util.*;

public class Hello {
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int minsteps(int from, int to, int target) {
        int f = 0, t = 0, steps = 0;

        while (f != target && t != target) {
            if (f == 0) {
                f = from;
                steps++;
            } else if (t == to) {
                t = 0;
                steps++;
            } else {
                int pour = Math.min(f, to - t);
                t += pour;
                f -= pour;
                steps++;

                if (f == target || t == target) {
                    return steps;
                }
            }

            if (steps > 10000) return Integer.MAX_VALUE; // safeguard
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();

        if (z > Math.max(x, y) || z % gcd(x, y) != 0 || x == 0 || y == 0) {
            System.out.println(-1);
            return;
        }

        int res1 = minsteps(x, y, z);
        int res2 = minsteps(y, x, z);
        int min = Math.min(res1, res2);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
