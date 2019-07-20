package sort;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 从左到右不断交换相邻逆序的元素，在一轮循环后，可以让未排序的最大元素上浮至最右侧
 * 在一轮循环中，如果没有发生交换，则说明此时数组已经有序，可以直接退出
 *
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/7/20
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(@NotNull T[] array) {
        int length = array.length;
        boolean sorted = false;
        for (int i = length - 1; i > 0 && !sorted; i--) {
            sorted = true;
            for (int j = 0; j < i; j++) {
                if (less(array[j + 1], array[j])) {
                    sorted = false;
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Sort sort = new BubbleSort();
        Integer[] array = new Integer[]{1, 3, 2, 4, 4, 9, 10, 3};
        sort.sort(array);
        System.out.println(Arrays.asList(array));
    }
}
