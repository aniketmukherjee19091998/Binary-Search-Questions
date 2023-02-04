import java.util.Arrays;

public class BinarySearchInStrictlySortedMatrix {

    static int[] binarySearchInMatrix(int[][] arr, int target) {
        int row = arr.length;
        int col = arr[0].length;
        if (row == 1) {
            return search(arr, target, row, 0, col);
        }

        int rowStart = 0, rowEnd = row - 1;
        int midCol = col / 2;

        // run a loop till two rows are remaining
        while (rowStart < rowEnd - 1) { // while this is true it will have more than two rows
            int midRow = rowStart + (rowEnd - rowStart) / 2;
            if (arr[midRow][midCol] == target)
                return new int[] { midRow, midCol };
            else if (arr[midRow][midCol] < target)
                rowStart = midRow;
            else
                rowEnd = midRow;
        }

        // Now after the loop we have two rows remaining
        // Check whether the target is the columns of two rows
        if (arr[rowStart][midCol] == target)
            return new int[] { rowStart, midCol };
        if (arr[rowStart + 1][midCol] == target)
            return new int[] { rowStart + 1, midCol };

        // Otherwise
        // Search in the 1st half
        if (arr[rowStart][midCol - 1] >= target) {
            return search(arr, target, rowStart, 0, midCol - 1);
        }
        // Search in the 2nd half
        if (arr[rowStart][midCol + 1] >= target && arr[rowStart][col - 1] >= target) {
            return search(arr, target, rowStart, midCol + 1, col - 1);
        }
        // Search in the 3rd half
        if (arr[rowStart + 1][midCol - 1] >= target) {
            return search(arr, target, rowStart + 1, 0, midCol - 1);
        }
        // Search in the 4th half
        if (arr[rowStart + 1][midCol + 1] >= target) {
            return search(arr, target, rowStart + 1, midCol - 1, 0);
        }
        return new int[] { -1, -1 };
    }

    // search in the row provided between the columns provided!
    static int[] search(int[][] nums, int target, int row, int cStart, int cEnd) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (nums[row][mid] == target)
                return new int[] { row, mid };
            else if (nums[row][mid] < target)
                cStart = mid + 1;
            else
                cEnd = mid - 1;
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        System.out.println("Target element found at : " + Arrays.toString(binarySearchInMatrix(arr, 13)));
    }
}