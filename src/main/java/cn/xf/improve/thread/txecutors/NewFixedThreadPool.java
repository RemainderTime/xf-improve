package cn.xf.improve.thread.txecutors;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 固定线程池数量
 * @ClassName: NewFixedThreadPool
 * @Author: xiongfeng
 * @Date: 2023/4/23 10:06
 * @Version: 1.0
 */


@Slf4j
public class NewFixedThreadPool {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for (int i = 1; i < 5; i++) {
			int groupId = i;
			executorService.execute(() -> {
				for (int j = 1; j < 5; j++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ignored) {
					}
					log.info("第 {} 组任务，第 {} 次执行完成", groupId, j);
				}
			});
		}
		executorService.shutdown();
	}
}
