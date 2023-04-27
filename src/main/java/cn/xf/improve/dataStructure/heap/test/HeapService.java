package cn.xf.improve.dataStructure.heap.test;

import org.springframework.stereotype.Service;

/**
 * @Description: 堆定义接口
 * @ClassName: HeapService
 * @Author: xiongfeng
 * @Date: 2023/4/26 09:27
 * @Version: 1.0
 */

@Service
public interface HeapService<T> {

	boolean add(T t);
	 boolean offer(T t);

	 T poll();

	 T peek();


}
