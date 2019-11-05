package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序
 * 
 * 将所有待比较数值(正整数)统一为同样的数位长度，数位较短的数前面补零，
 * 从低位到高位依次桶分配排序以后，数组就有序了
 * 
 * 1) 找出最大值
 * 2) 根据最大值找到最大数位
 * 3) 初始化10个桶
 * 4) 从低位到高位依次进行桶分配-收集
 * 
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/11/05
 */
public class RadixSort extends Sort<Integer> {

	@Override
	public void sort(Integer[] array) {
		if (array == null || array.length <= 1) {
			return ;
		}
		
		// 1) 找出最大值
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		
		// 2) 数组的最大数位一定由最大值产生
		int digitNum = 0;
		while (max > 0) {
			max /= 10;
			digitNum += 1;
		}
		
		
		// 3) 初始化10个桶(由于每位在0~9,故桶大小为10)
		List<List<Integer>> buckets = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			buckets.add(new ArrayList<>());
		}
		
		
		// 4) 从低位到高位依次进行桶分配-收集
		for (int i = 0; i < digitNum; i++) {
			// 4.1) 桶分配
			for (int j = 0; j < array.length; j++) {
				// 求余取整得位数
				int key = array[j] % (int)Math.pow(10, i + 1) / (int)Math.pow(10, i);
				buckets.get(key).add(array[j]);
			}
			
			// 4.2) 桶收集
			int index = 0;
			for (int j = 0; j < 10; j++) {
				List<Integer> bucket = buckets.get(j);
				while (bucket.size() > 0) {
					array[index++] = bucket.remove(0);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Sort<Integer> sort = new RadixSort(); 
	    Integer[] array = new Integer[]{2,1,4,6,3,7,3};
        sort.sort(array);
        System.out.println(Arrays.asList(array));
	}

}
