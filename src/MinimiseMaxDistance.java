import java.util.Arrays;
import java.util.Random;

public class MinimiseMaxDistance {
    private static double fun(int[] arr, int n, int k) {
        double l = 0, r = arr[n - 1] - arr[0];
        double precision = 1.0 / Math.pow(10.0, 6.0);
        double res = 0.0;
        while (l + precision < r) {
            double mid = l + (r - l) / 2.0;
            int count = countFunc(arr, mid);
            if (count > k) {
                l = mid;
            } else {
                res = mid;
                r = mid;
            }
        }
        double result = round(res, 2);
        return result;
    }

    private static int countFunc(int[] arr, double mid) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            count += (arr[i + 1] - arr[i]) / mid;
        }
        return count;
    }

    private static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(10, 5001)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 1000000001);
        }

        int k = random.nextInt(0, 100001);
        Arrays.sort(arr);
        System.out.println("The minimum distance : ");
        System.out.println(fun(arr, arr.length, k));
        System.out.println(fun(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 10, 9));
    }
}
