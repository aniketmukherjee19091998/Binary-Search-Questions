import java.util.Random;

public class ReachANumber {
    static int toReach(int target) {
        long l = 0, r = target;
        int step = 0;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (m < target) {
                step = Math.abs((int) (m - step));
                l = m + 1;
            } else if (m > target) {
                step = Math.abs((int) (m - step));
                r = m - 1;
            } else {
                return step;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int target = random.nextInt(-1000000000, 1000000000);
        System.out.println("Target : " + target);
        System.out.println("The number of steps it takes to reach the target is : " + toReach(target));
    }
}
