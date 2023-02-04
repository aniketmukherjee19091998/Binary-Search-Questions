import java.util.*;

public class SpecialArray {

    static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int count = 0;
            for (int num : nums) {
                if (num >= mid)
                    count++;
            }
            if (count == mid)
                return mid;
            else if (count < mid)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[rand.nextInt(1, 100)];
        for (int i = 0; i < nums.length; i++)
            nums[i] = rand.nextInt(0, 1000);
        System.out.println("Special Array ?\n(-1:-> No <<<<<>>>>> Otherwise:-> Yes)\n" + specialArray(nums));
    }
}
