package sort.merge;

import com.sun.istack.internal.NotNull;
import sort.Sort;

/**
 * 归并排序
 *
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/7/21
 */
public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] assist; // 辅助数组

    /**
     * 将数组中已经排好序的两个部分[左侧部分、右侧部分]合并
     *
     * @param array
     * @param left
     * @param middle
     * @param right
     */
    protected void merge(@NotNull T[] array, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;

        for (int k = left; k <= right; k++) {
            assist[k] = array[k];
        }

        for (int k = left; k <= right; k++) {
            if (i > middle) { // 说明左侧部分已经完成合并，仅需合并右侧部分
                array[k] = assist[j++];
            } else if (j > right) { // 说明右侧部分已经完成合并，仅需合并左侧部分
                array[k] = assist[i++];
            } else if (assist[i].compareTo(assist[j]) <= 0) {
                array[k] = assist[i++];
            } else {
                array[k] = assist[j++];
            }
        }
    }
}
