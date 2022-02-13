package leetcode.binarysearch;

// https://leetcode.com/problems/first-bad-version/
public class BadVersion {
    public int firstBadVersion(int n) {
        long left = 1, right = n;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (!isBadVersion((int) mid))
                left = mid + 1;
            else
                right = mid - 1;
        }
        return (int) left;
    }

    private boolean isBadVersion(int n) {
        return n >= 1702766719;
    }

    // 1 2 3 4 5
    public static void main(String[] args) {
        int n = 2126753390;
        System.out.println(new BadVersion().firstBadVersion(n));
    }
}
