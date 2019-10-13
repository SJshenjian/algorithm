package sort;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序
 *
 * 快速排序通过一个切分元素将数组分为左右两个数组，
 * 左数组元素小于等于切分元素，右数组大于等于切分元素，
 * 将左右子数组排序，整个数组也就有序了
 *
 * 平均情况为O(nlog(n)),最差情况O(n~2),存储空间O(log(n))
 * V1.1.0 sort、partition写法参照<<程序员面试金典>>重写
 *
 * @author Jian Shen
 * @version V1.1.0
 * @date 2019/7/23
 */
public class QuitSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(@NotNull T[] arr) {
        shuffle(arr);
        sort(arr, 0 , arr.length - 1);
    }

    private void sort(T[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) { // 排序左半部分
            sort(arr, left, index - 1);
        }
        if (index < right) { // 排序右半部分
            sort(arr, index, right);
        }
    }

    private int partition(T[] arr, int left, int right) {
        T pivot = arr[(left + right) / 2]; // 挑选一个基准点
        while (left <= right) {
            // 找到左边应被放到右边的元素
            while (arr[left].compareTo(pivot) < 0) {
                left++;
            }
            // 找到右边应被放到左边的元素
            while (arr[right].compareTo(pivot) > 0) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right); // 交换元素
                left++;
                right--;
            }
        }
        return left;
    }

    private void shuffle(T[] arr) {
        List<Comparable> list = Arrays.asList(arr);
        Collections.shuffle(list); // 防止最坏的情况，第一次从最小的元素切分，第二次从次小的元素切分。时间复杂度N^2
        list.toArray(arr);
    }

    public static void main(String[] args) {
        Sort sort = new QuitSort();
        Integer[] arr = new Integer[]{2, 1, 4, 6, 3, 7, 3};
        sort.sort(arr);
        System.out.println(Arrays.asList(arr));
    }
}
