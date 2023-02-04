import java.util.*;

public class ValidPerfectSquare {
    static boolean isValidPerfectSquare(int num) {
        long l = 1, r = num;
        while (l <= r) {
            long mid = (r + l) / 2;
            if ((mid * mid) == num)
                return true;
            else if ((mid * mid) > num)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(1, Integer.MAX_VALUE);
        System.out.println("Does sqaure root of " + num + " exist? Ans:\t" + isValidPerfectSquare(num));
    }
}
