import java.util.Random;

public class GuessGame {
    static int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int flag = guess(mid);
            if (flag == 0)
                return mid;
            else if (flag < 0)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    static int guess(int n) {
        return 0;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(1, Integer.MAX_VALUE);
        System.out.println("The Guessed number is : " + guessNumber(num));
    }
}
