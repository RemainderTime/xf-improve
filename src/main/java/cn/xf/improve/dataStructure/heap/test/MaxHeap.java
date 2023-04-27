package cn.xf.improve.dataStructure.heap.test;

/**
 * @Description:
 * @ClassName: MaxHeap
 * @Author: xiongfeng
 * @Date: 2023/4/26 11:05
 * @Version: 1.0
 */
public class MaxHeap extends HeapServiceImpl<Integer>{

	@Override
	public int compareTo(Integer firstElement, Integer secondElement) {
		return secondElement.compareTo(firstElement);
	}
}
