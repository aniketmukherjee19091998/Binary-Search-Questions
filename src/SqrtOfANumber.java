import java.util.Random;

public class SqrtOfANumber {
    private static int sqrtOfANumber(int num) {
        int l = 1, r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == num / mid)
                return mid;
            else if (mid < num / mid)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return r;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(0, Integer.MAX_VALUE);
        System.out.println("Sqrt(" + num + ") = " + sqrtOfANumber(num));
        System.out.println(Math.sqrt(num));
    }
}
