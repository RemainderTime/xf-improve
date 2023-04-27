package cn.xf.improve.dataStructure.heap.test02;

import cn.xf.improve.dataStructure.heap.test.HeapServiceImpl;
import com.alibaba.fastjson.JSON;
import com.sun.scenario.effect.impl.HeapImage;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @ClassName: HeapImpl
 * @Author: xiongfeng
 * @Date: 2023/4/27 11:16
 * @Version: 1.0
 */

@Slf4j
public class HeapImpl<T> implements IHeap<T> {

	private static final int HEAP_SIZE = 11;

	transient Object[] heap = null;

	private int size = 0;

	public HeapImpl() {
		heap = new Object[HEAP_SIZE];
	}


	@Override
	public void add(T t) {
		if (t == null) {
			throw new NullPointerException();
		}

		if (size >= HEAP_SIZE) {
			//数组扩容
		} else {
			if (size == 0) {
				heap[0] = t;
			} else {
				push(size, t);
			}
		}
		size++;

	}

	@Override
	public void push(int k, T t) {

		while (k > 0) {
			int root = (k-1) >>> 1;
			Object e = heap[root];
			if (compareTo(t, (T) e) > 0) {
				break;
			}
			heap[k] = e;
			k = root;
		}
		heap[k] = t;

		log.error("最终堆---{}", JSON.toJSON(heap));
	}

	@Override
	public T peek() {
		return size == 0?null: (T) heap[0];
	}

	@Override
	public T poll() {
		if(size == 0){
			throw new RuntimeException();
		}
		--size;
		Object result = heap[0];
		Object t = heap[size];
		heap[size] = null;
		if(t != null){
			rearrangementHeap(0, (T) t);
		}
		return (T) result;
	}
	private  void rearrangementHeap(int k, T t){
		int self = size >>> 1;
		while (k < self){
			int child = (k << 1) + 1;
			Object o = heap[child];
			int i = child + 1;
			if(i< size&& compareTo((T) o, (T) heap[i]) > 0){
				o = heap[child = i];
			}
			if(compareTo((T) o, t) > 0){
				break;
			}
			heap[k] = o;
			k = child;
		}
		heap[k] = t;
	}


	public int compareTo(T firstEment, T regitEment) {
		throw new RuntimeException("没有可用的compareTo方法");
	}
}
