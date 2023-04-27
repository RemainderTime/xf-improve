package cn.xf.improve.dataStructure.heap;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description:
 * @ClassName: Main
 * @Author: xiongfeng
 * @Date: 2023/4/25 15:27
 * @Version: 1.0
 */

@Slf4j
public class Main {

	@Test
	public void test_min_heap() {
		MinHeap minHeap = new MinHeap();

		// 存入元素
		minHeap.add(2);
		minHeap.add(3);
		minHeap.add(7);
		minHeap.add(3);
		minHeap.add(4);
		minHeap.add(21);
		minHeap.add(1);

		// 弹出元素
		while (minHeap.peek() != null){
			log.info("测试结果：{}", minHeap.poll());
		}

	}

	@Test
	public void test_max_heap() {
		MaxHeap heap = new MaxHeap();
		// 存入元素
		heap.add(1);
		heap.add(3);
		heap.add(5);
		heap.add(11);
		heap.add(4);
		heap.add(6);
		heap.add(7);
		heap.add(12);
		heap.add(15);
		heap.add(10);
		heap.add(9);
		heap.add(8);

		// 弹出元素
		while (heap.peek() != null){
			log.info("测试结果：{}", heap.poll());
		}

	}
}
