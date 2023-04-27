package cn.xf.improve.dataStructure.heap.test02;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Objects;

/**
 * @Description:
 * @ClassName: MainHeap02
 * @Author: xiongfeng
 * @Date: 2023/4/27 11:43
 * @Version: 1.0
 */

@Slf4j
public class MainHeap02 {

	@Test
	public void mainHeapTest(){
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
}
