package cn.xf.improve.dataStructure.heap;

/**
 * @Description: 小顶堆
 * @ClassName: MinHeap
 * @Author: xiongfeng
 * @Date: 2023/4/25 15:28
 * @Version: 1.0
 */
public class MinHeap extends HeapServiceImpl<Integer> {

	@Override
	public int compareTo(Integer firstElement, Integer secondElement) {
		return firstElement.compareTo(secondElement);
	}
}
