import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class BinarySearch {
    private static void quickSort(int[] nums, int lo, int hi) {
        if (lo <= hi)
            return;
        int l = lo, r = hi;
        int mid = l + (r - l) / 2;
        int pivot = nums[mid];
        while (l <= r) {
            while (pivot > nums[l])
                l++;
            while (pivot < nums[r])
                r--;
            if (l <= r)
                swap(nums, l, r);
        }
        quickSort(nums, lo, r);
        quickSort(nums, l, hi);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (l > r)
            return -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Random rand = new Random();
        int size = 1000000;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = rand.nextInt(1000);
        }
        quickSort(nums, 0, size - 1);
        int ans = search(nums, rand.nextInt(1000));
        if (ans == -1)
            System.out.println("Not found!");
        else
            System.out.println("Found at : " + ans + "th index.");
        long endTime = System.currentTimeMillis();
        // System.out.println("Time taken : " + (endTime - startTime) / 1000 + "
        // nanoSeconds");
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds");
    }
}
