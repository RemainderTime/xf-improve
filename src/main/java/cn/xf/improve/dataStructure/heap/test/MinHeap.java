package cn.xf.improve.dataStructure.heap.test;


/**
 * @Description: 小堆排序比较
 * @ClassName: MinHeap
 * @Author: xiongfeng
 * @Date: 2023/4/27 08:46
 * @Version: 1.0
 */
public class MinHeap extends HeapServiceImpl<Integer> {

	@Override
	public int compareTo(Integer firstElement, Integer secondElement) {
		return firstElement.compareTo(secondElement);
	}
}
