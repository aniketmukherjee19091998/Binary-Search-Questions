import java.util.*;

public class OrderAgnosticBinarySearch {
    private static void reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
    }

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (l > r)
            return -1;
        boolean isAsc = nums[l] < nums[r];
        System.out.println(isAsc);
        System.out.println("target : " + target);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;
            if (isAsc) {
                if (target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (target < nums[mid])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(0, 10);
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        // if (rand.nextInt(-1, 1) == 1)
        reverse(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(search(nums, rand.nextInt(0, 10)));
    }
}
