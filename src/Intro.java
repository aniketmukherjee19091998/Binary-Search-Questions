import static java.lang.System.*;
import java.util.*;

public class Intro {
    private static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (l > r)
            return -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int size = r.nextInt(1000, 1000000);
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = r.nextInt(0, 1000);
        }
        Arrays.sort(nums);
        // out.println(Arrays.toString(nums));
        int ans = search(nums, r.nextInt(0, 1000));
        if (ans == -1)
            out.println("Element does not exists!");
        else
            out.println("Element at : " + ans);
    }
}