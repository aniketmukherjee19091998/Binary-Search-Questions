import java.util.Arrays;
import java.util.Random;

public class AggressiveCows {

    private static int func(int[] stalls, int n, int cows) {
        int res = 0;
        Arrays.sort(stalls);
        int l = 1, r = stalls[n - 1] - stalls[0];
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (canPlaceCows(stalls, n, cows, mid)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    private static boolean canPlaceCows(int[] stalls, int n, int cows, int dist) {
        int co_ord = stalls[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (stalls[i] - co_ord >= dist) {
                count++;
                co_ord = stalls[i];
            }
            if (count == cows)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] stalls = new int[random.nextInt(2, 100001)];
        int cows = random.nextInt(2, stalls.length + 1);
        for (int i = 0; i < stalls.length; i++) {
            stalls[i] = random.nextInt(0, 1000000001);
        }
        System.out.println(
                "The largest possible minimum distance between cows is : " + func(stalls, stalls.length, cows));
    }
}
