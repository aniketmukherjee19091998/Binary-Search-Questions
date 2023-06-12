import java.util.HashMap;
import java.util.Map.Entry;

public class SingleElementInSortedArray {
    private static int func(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];
        int l = 1, r = n - 2;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1])
                return arr[mid];
            if ((mid % 2 != 0 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1]))
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    private static int func_better(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            if (!map.containsKey(ele)) {
                map.put(ele, 1);
            } else {
                map.put(ele, map.get(ele) + 1);
            }
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val == 1)
                return entry.getKey();
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 4, 4, 5, 5 };
        int n = arr.length;
        System.out.println("The single element is : " + func(arr, n));
        System.out.println("The single element is : " + func_better(arr, n));
    }
}
