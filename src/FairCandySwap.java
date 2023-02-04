import java.util.*;

public class FairCandySwap {
    static int[] fairSwap(int[] alice, int[] bob) {
        int sumA = 0, sumB = 0;
        for (int i = 0; i < alice.length; i++) {
            sumA += alice[i];
        }
        for (int i = 0; i < bob.length; i++) {
            sumB += bob[i];
        }
        int diff = (sumA - sumB) / 2;
        Arrays.sort(alice);
        for (int b : bob) {
            if (search(alice, b + diff) != -1)
                return new int[] { b, b + diff };
        }
        return null;
    }

    static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] alice = new int[random.nextInt(1, 10000)];
        int[] bob = new int[random.nextInt(1, 10000)];
        for (int i = 0; i < alice.length; i++)
            alice[i] = random.nextInt(1, 100000);
        for (int i = 0; i < bob.length; i++)
            bob[i] = random.nextInt(1, 100000);
        System.out.println("The number of candy to be swapped : " + Arrays.toString(fairSwap(alice, bob)));
    }
}
