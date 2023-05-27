import java.util.*;

public class CountInversions {
    public static long getInversions(long arr[], int n) {
        return mergeSortAndCount(arr, 0, n - 1);
    }

    private static long mergeAndCount(long arr[], int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        long count = 0;

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);

        return count;
    }

    private static long mergeSortAndCount(long arr[], int left, int right) {
        long count = 0;

        if (left < right) {
            int mid = (left + right) / 2;
            count += mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid + 1, right);
            count += mergeAndCount(arr, left, mid, right);
        }

        return count;
    }

    public static void main(String[] args) {
        // Test the code
        long[] arr = { 5, 3, 2, 4, 1 };
        int n = arr.length;

        long inversions = getInversions(arr, n);
        System.out.println("Number of inversions: " + inversions);
    }
}
