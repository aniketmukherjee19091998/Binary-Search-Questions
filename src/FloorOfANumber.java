import java.util.*;

public class FloorOfANumber {
    static int floorOfANumber(int[] nums, int target) {
        if (target < nums[0])
            return -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return r;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[rand.nextInt(1, 100000)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(1, 100000);
        }
        Arrays.sort(nums);
        int target = rand.nextInt(1, 100000);
        System.out.println("Floor of " + target + " is : " + floorOfANumber(nums, target));
    }
}
