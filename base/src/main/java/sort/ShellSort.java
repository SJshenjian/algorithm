package sort;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * 对于大规模的数组，插入排序很慢，因为每次只能将逆序数量减1，
 * 希尔排序交换不相邻的元素，每次可以将逆序数量减少大于1
 * 希尔排序使用插入排序对间隔h的序列进行排序，通过不断减小h至1，就可以使得数组是有序的
 *
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/7/21
 */
public class ShellSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(@NotNull T[] array) {
        int length = array.length;
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(array[j], array[j - h])) {
                        swap(array, j, j - h);
                    }
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        Sort sort = new ShellSort();
        Integer[] array = new Integer[]{3, 5, 3, 4, 1, 1};
        sort.sort(array);
        System.out.println(Arrays.asList(array));
    }
}