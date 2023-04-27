package cn.xf.improve.dataStructure.heap.test02;

/**
 * @Description:
 * @ClassName: IHeap
 * @Author: xiongfeng
 * @Date: 2023/4/27 11:14
 * @Version: 1.0
 */
public interface IHeap<T> {

	public void add(T t);

	public void push(int k, T t);

	public T peek();


	public T poll();
}
