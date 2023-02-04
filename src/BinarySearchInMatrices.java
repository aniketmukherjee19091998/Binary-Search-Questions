import java.util.*;

public class BinarySearchInMatrices {
    static int[] search(int[][] mat, int target) {
        int r = 0, c = mat[0].length - 1;
        while (r < mat.length && c >= 0) {
            if (mat[r][c] == target) {
                return new int[] { r + 1, c + 1 };
            } else if (mat[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        // int[][] mat = { { 18, 9, 12 }, { 36, -4, 91 }, { 44, 33, 121 } };
        int[][] mat = {
                { 10, 20, 30, 40, 56 },
                { 11, 22, 33, 45, 57 },
                { 15, 26, 37, 49, 58 },
                { 19, 29, 39, 51, 59 }
        };
        int target = 59;
        System.out.println("Target found @ [row, col]: " + Arrays.toString(search(mat, target)));
    }
}