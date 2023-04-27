package cn.xf.improve.dataStructure.heap.test02;

/**
 * @Description:
 * @ClassName: MinHeap
 * @Author: xiongfeng
 * @Date: 2023/4/27 11:32
 * @Version: 1.0
 */
public class MinHeap extends HeapImpl<Integer>{
	@Override
	public int compareTo(Integer firstElement, Integer rightElement) {
		return firstElement.compareTo(rightElement);
	}
}
