import java.util.*;

public class SearchInsertPosition {
    static int searchInsert(int[] nums, int target) {
        // array
        if (nums[0] > target)
            return 0;
        if (nums[nums.length - 1] < target)
            return nums.length;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // From this point we have to search its position, as it is not present in the
        // Array
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[rand.nextInt(1, 10000)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -10000 + rand.nextInt(10000);
        }
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int target = -10000 + rand.nextInt(10000);
        System.out.println("The required position of " + target + " is : " + searchInsert(nums, target));
    }
}
