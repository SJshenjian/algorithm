package sort;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

/**
 * 选择排序
 *
 * 从数组中第一个位置开始循环数组选择最小的一个元素放于数组第一个位置，然后
 * 从数组中第二个位置开始循环数组选择最小的一个元素放于数组的第二个位置，
 * 依此类推，直到整个数组排序
 *
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/7/20
 */
public class SelectSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(@NotNull T[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(array[j], array[min])) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    public static void main(String[] args) {
        Sort sort = new SelectSort();
        Integer[] array = new Integer[]{2, 1, 4, 6, 3, 7, 3};
        sort.sort(array);
        System.out.println(Arrays.asList(array));
    }
}
