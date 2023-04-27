package cn.xf.improve.dataStructure.heap.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @ClassName: HeapServiceImpl
 * @Author: xiongfeng
 * @Date: 2023/4/26 10:47
 * @Version: 1.0
 */

@Slf4j
public class HeapServiceImpl<T> implements HeapService<T> {

	private static final int HEAP_ARRAY_LENGTH = 11;

	transient Object[] heap = null;

	private int size = 0;

	public HeapServiceImpl() {
		heap = new Object[HEAP_ARRAY_LENGTH];
	}


	@Override
	public boolean add(T t) {
		return offer(t);
	}

	@Override
	public boolean offer(T t) {

		if (t == null) {
			return false;
		}
		int i = size;
		if (i >= HEAP_ARRAY_LENGTH) {

		} else {
			if (i == 0) {
				heap[0] = t;
			} else {
				pushHeap(t, i);
			}
			size++;
		}
		return true;
	}

	void pushHeap(T t, int k) {
		//获取父节点
		while (k > 0) {
			int parent = (k - 1) >>> 1;
			Object e = heap[parent];
			if (compareTo(t, (T) e) >= 0) {
				break;
			}
			log.error("新元素----{}----替换元素----{}", t, e);
			heap[k] = e;
			k = parent;
		}
		heap[k] = t;
		log.error("最终堆数组-------{}", JSON.toJSON(heap));
	}


	@Override
	public T poll() {

		if (size == 0) {
			return null;
		}
		--size;
		T root = (T) heap[0];
		T t = (T) heap[size];
		heap[size] = null;
		if (t != null) {
			adjustHeap(0, (Integer) t);
		}

		return root;
	}

	public void adjustHeap(int k, Integer t) {

		int self = size >>> 1;
		while (k < self) {
			//获取当前节点
			int index = (k << 1) + 1;
			Object child = heap[index];
			//获取右节点
			int right = index + 1;
			Object rightE = heap[right];
			if (right < size && compareTo((T) child, (T) rightE) > 0) {
				child = heap[index = right];
			}

			if (compareTo((T) child, (T) t) > 0) {
				break;
			}
			heap[k] = child;
			k = index;
		}
		heap[k] = t;
	}

	@Override
	public T peek() {
		return (size == 0) ? null : (T) heap[0];
	}

	public int compareTo(T firstElement, T secondElement) {

		throw new RuntimeException("未实现compareTo方法");

	}
}
