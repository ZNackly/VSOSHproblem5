import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int inf = 10_000000;
        int[][] times = new int[4][3];
        int[][] route = {
            {},
            {1},
            {1, 2},
            {0}
        };

        int calc_route(int[] v) {
            int tm = 0;
            for (int ind : v) {
                int r = times[ind][0];
                int g = times[ind][1];
                int w = times[ind][2];
                if (w > g) {
                    return inf;
                }
                int tmp = tm % (r + g);
                if (tmp < r) {
                    tm += r - tmp;
                    tmp = r;
                }
                if (w > r + g - tmp) {
                    tm += -tmp + r + g + r + w;
                } else {
                    tm += w;
                }
            }
            return tm;
        }

        Scanner scanner = new Scanner(System.in);
        int ang = scanner.nextInt();
        if (ang == 12) {
            System.out.println("0");
            System.exit(0);
        }
        if (ang == 23) {
            ang = 1;
        }
        if (ang == 34) {
            ang = 2;
        }
        if (ang == 41) {
            ang = 3;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                times[i][j] = scanner.nextInt();
            }
        }
        int ans = inf;
        for (int v : route[ang]) {
            ans = Math.min(ans, calc_route(v));
        }
        System.out.println(ans);
    }
}

