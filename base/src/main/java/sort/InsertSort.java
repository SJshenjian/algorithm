package sort;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 每次将当前元素插入到左侧已经排序的数组中，插入之后左侧数组依然有序。
 * 对于数组 {3, 5, 2, 4, 1}，它具有以下逆序：(3, 2), (3, 1), (5, 2), (5, 4), (5, 1), (2, 1), (4, 1)，
 * 插入排序每次只能交换相邻元素，令逆序数量减少 1，因此插入排序需要交换的次数为逆序数量
 *
 * 平均情况下插入排序需要N^2/4次比较与N^2/4次交换
 * 最坏的情况下，需要N^2/2次比较与N^2/2次交换，即数组是倒叙的
 * 最好的情况下需要N-1次比较和0次交换，即数组是有序的
 *
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/7/20
 */
public class InsertSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(@NotNull  T[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(array[j], array[j - 1])) {
                    swap(array, j, j -1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Sort sort = new InsertSort();
        Integer[] array = new Integer[]{3, 3, 5, 2, 4, 1, 1};
        sort.sort(array);
        System.out.println(Arrays.asList(array));
    }
}
