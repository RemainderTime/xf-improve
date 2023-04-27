package cn.xf.improve.dataStructure.heap.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Objects;

/**
 * @Description: 测试
 * @ClassName: MainTest
 * @Author: xiongfeng
 * @Date: 2023/4/27 09:07
 * @Version: 1.0
 */
@Slf4j
public class MainTest {


	@Test
	public void minHeap(){
		MinHeap minHeap =new MinHeap();
		minHeap.add(2);
		minHeap.add(3);
		minHeap.add(7);
		minHeap.add(3);
		minHeap.add(4);
		minHeap.add(21);
		minHeap.add(1);

		while (Objects.nonNull(minHeap.peek())){
			log.error("出栈----{}", minHeap.poll());
		}

	}

	@Test
	public void MaxHeap(){
		MaxHeap maxHeap =new MaxHeap();
		maxHeap.add(2);
		maxHeap.add(3);
		maxHeap.add(7);
		maxHeap.add(3);
		maxHeap.add(4);
		maxHeap.add(21);
		maxHeap.add(1);

		while (Objects.nonNull(maxHeap.peek())){
			log.error("出栈----{}", maxHeap.poll());
		}

	}


}
