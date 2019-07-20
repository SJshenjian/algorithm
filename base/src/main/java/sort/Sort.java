package sort;

/**
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/7/20
 */
public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] array);

    protected boolean less(T first, T two) {
        return first.compareTo(two) < 0;
    }

    protected void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
