import java.util.Random;

public class BookAllocation {

    private static int func(int[] books, int students) {
        if (books.length < students)
            return -1;
        // Arrays.sort(books);
        int l = Integer.MAX_VALUE;
        int r = 0;
        for (int i : books) {
            l = Math.min(l, i);
            r += i;
        }
        int res = -1;
        while (r >= l) {
            int mid = l + (r - l) / 2;
            if (canBeAllocatedPages(books, students, mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private static boolean canBeAllocatedPages(int[] books, int students, int barrier) {
        int count = 1, pages = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] > barrier)
                return false;
            if (pages + books[i] > barrier) {
                count += 1;
                pages = books[i];
            } else {
                pages += books[i];
            }
        }
        return (count <= students);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] books = new int[random.nextInt(1, 100001)];
        int students = random.nextInt(1, 100001);
        for (int i = 0; i < books.length; i++) {
            books[i] = random.nextInt(1, 1000001);
        }
        System.out.println(
                "The least possible pages allocated from maximum allocated pages are : " + func(books, students));
        System.out.println(
                "The least possible pages allocated from maximum allocated pages are : "
                        + func(new int[] { 12, 34, 67, 90 }, 2));
    }
}
