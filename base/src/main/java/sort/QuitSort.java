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
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/7/23
 */
public class QuitSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(@NotNull T[] array) {
        shuffle(array);
        sort(array, 0 , array.length - 1);
    }

    private void sort(T[] array, int left, int right) {
        if (right <= left) {
            return ;
        }
        int middle = partition(array, left, right);
        sort(array, left, middle - 1);
        sort(array, middle + 1, right);
    }

    private int partition(T[] array, int left, int right) {
        int i = left;
        int j = right + 1;
        T k = array[left];
        while (true) {
            while (less(array[++i], k) && i != right); // 循环1，直到找到大于等于k的元素或i增加为right
            while (less(k, array[--j]) && j != left); // 循环2，直到找到比小于等于k的元素或j减小为left
            if (i >= j) {
                break;
            }
            swap(array, i, j); // 交换当前轮次找到的元素
        }
        // array[left]必定小于等于array[j], happens-before原则，前置条件为break执行，
        // break前置条件为循环2执行完毕，故需交换从而保证当前切分元素必定大于等于左侧数组值，小于等于右侧数组值
        swap(array, left, j);
        return j;
    }

    private void shuffle(T[] array) {
        List<Comparable> list = Arrays.asList(array);
        Collections.shuffle(list); // 防止最坏的情况，第一次从最小的元素切分，第二次从次小的元素切分。时间复杂度N^2/2
        list.toArray(array);
    }

    public static void main(String[] args) {
        Sort sort = new QuitSort();
        Integer[] array = new Integer[]{2, 1, 4, 6, 3, 7, 3};
        sort.sort(array);
        System.out.println(Arrays.asList(array));
    }
}
