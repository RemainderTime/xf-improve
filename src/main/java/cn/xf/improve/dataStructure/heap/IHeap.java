package cn.xf.improve.dataStructure.heap;

/**
 * @Description: 堆接口
 * @ClassName: IHeap
 * @Author: xiongfeng
 * @Date: 2023/4/25 15:13
 * @Version: 1.0
 */
public interface IHeap<E>{


	boolean add(E e);

	boolean offer(E e);

	E poll();

	E peek();

}
