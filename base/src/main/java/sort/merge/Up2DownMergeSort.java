package sort.merge;

import sort.Sort;

import java.util.Arrays;

/**
 * 自顶向下归并排序
 *
 * 将数组分成两个部分，分别进行排序，然后归并起来
 * 这种对半分的复杂度为O(NlogN)
 *
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/7/21
 */
public class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] array) {
        assist = (T[]) new Comparable[array.length];
        sort(array, 0, array.length - 1);
    }

    private void sort(T[] array, int left, int right) {
        if (left >= right) {
            return ;
        }
        int middle = left + (right - left) / 2;
        sort(array, left, middle);
        sort(array, middle + 1, right);
        merge(array, left, middle, right);
    }

    public static void main(String[] args) {
        Sort sort = new Up2DownMergeSort();
        Integer[] array = new Integer[]{1, 3, 2, 4, 4, 9, 10, 3, 3};
        sort.sort(array);
        System.out.println(Arrays.asList(array));
    }
}
