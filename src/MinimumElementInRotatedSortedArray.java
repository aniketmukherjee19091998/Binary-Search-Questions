import java.util.Arrays;
import java.util.Random;

public class MinimumElementInRotatedSortedArray {
    private static int search(int[] arr) {
        int l = 0, r = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[l] <= arr[r]) {
                ans = Math.min(arr[l], ans);
                break;
            }
            if (arr[mid] >= arr[l]) {
                ans = Math.min(ans, arr[l]);
                l = mid + 1;
            } else {
                ans = Math.min(arr[mid], ans);
                r = mid - 1;
            }
        }
        return ans;
    }

    static void Rotate(int arr[], int d, int n) {
        // Storing rotated version of array
        int temp[] = new int[n];

        // Keeping track of the current index
        // of temp[]
        int k = 0;

        // Storing the n - d elements of
        // array arr[] to the front of temp[]
        for (int i = d; i < n; i++) {
            temp[k] = arr[i];
            k++;
        }

        // Storing the first d elements of array arr[]
        // into temp
        for (int i = 0; i < d; i++) {
            temp[k] = arr[i];
            k++;
        }

        // Copying the elements of temp[] in arr[]
        // to get the final rotated array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(11, 100)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(-10000, 10000);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        // now to rotate it
        Rotate(arr, random.nextInt(1, arr.length - 1), arr.length);
        System.out.println("\n__________________________\n");
        System.out.println(Arrays.toString(arr));
        System.out.println("\n___________________________\n");
        System.out.println("The minimum element is : " + search(arr));
    }
}
