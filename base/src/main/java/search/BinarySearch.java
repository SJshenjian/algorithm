package search;

import com.sun.istack.internal.NotNull;

/**
 * 二分查找
 *
 * 要在有序的数组里查找元素x,先取中间元素与x比较，
 * 若小于中间元素，则在左边查找，反之，在右边查找，直到找到x或子数组为0
 *
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/10/13
 */
public class BinarySearch<T extends Comparable<T>> {

    public int search(@NotNull  T[] arr, T x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (arr[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1; // 未查找到
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 4, 5, 6};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(arr, 3));
    }
}
