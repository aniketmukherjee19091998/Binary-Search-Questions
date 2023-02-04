public class SearchInRotatedSortedArray {

    static int findPivot(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid < r && nums[mid] > nums[mid + 1])
                return mid;
            if (mid > l && nums[mid] < nums[mid - 1])
                return mid - 1;
            else if (nums[l] >= nums[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    static int search(int[] nums, int target, int l, int r) {
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
        return -1;
    }

    static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int pivot = findPivot(nums);
        if (pivot < 0)
            return search(nums, target, l, r);
        else if (target == nums[pivot])
            return pivot;
        else if (target < nums[l]) {
            l = pivot + 1;
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
        } else {
            while (l <= pivot) {
                int mid = l + (pivot - l) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    pivot = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 8, 11, 13, 15, 17, 18, 4, 6 };
        int target = 6;
        System.out.println("Pivot element : " + findPivot(nums));
        System.out.println("The target : " + target + ", is at : " + search(nums, target));
    }
}
