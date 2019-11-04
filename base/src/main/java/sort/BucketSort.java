package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 * 
 * 把数组array划分为n个大小相同子空间(桶)，每个子空间各自排序，最后合并
 * 计数排序是桶排序的一种特殊情况，可以把其当成每个桶中只有一个元素的情况
 * 
 * 1) 找出待排序数组的最大值、最小值
 * 2) 创建桶(max-min)/array.length+1
 * 3) 将每个元素放入桶
 * 4) 每个桶各自排序
 * 
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/11/04
 */
public class BucketSort extends Sort<Integer> {

	@Override
	public void sort(Integer[] array) {
		if (array == null || array.length <= 1) {
			return ;
		}
		
		// 1) 找出待排序数组的最大值、最小值
		int min = array[0];
		int max = array[1];
		for (int i : array) {
			if (less(i, min)) {
				min = i;
			}
			if (less(max, i)) {
				max = i;
			}
		}
		
		// 2) 创建桶
		int bucketNum = (max - min) / array.length + 1;
		List<List<Integer>> bucketList = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++) {
			bucketList.add(new ArrayList<>());
		}
		
		// 3) 将每个元素放入桶
		for (int i : array) {
			int num = (i - min) / array.length;
			bucketList.get(num).add(i);
		}
		
		// 4) 每个桶各自排序
		for (List<Integer> bucket : bucketList) {
			Collections.sort(bucket);
		}
		
		// 5) 赋值原数组
		int i = 0;
		for (List<Integer> bucket : bucketList) {
			for (Integer item : bucket) {
				array[i++] = item;
			}
		}
	}
	
	public static void main(String[] args) {
		Sort<Integer> sort = new BucketSort(); 
	    Integer[] array = new Integer[]{2,1,4,6,3,7,3};
        sort.sort(array);
        System.out.println(Arrays.asList(array));
	}
}
