package cn.xf.improve.thread.txecutors;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 缓存线程池
 * @ClassName: NewCachedThreadPool
 * @Author: xiongfeng
 * @Date: 2023/4/23 10:37
 * @Version: 1.0
 */
@Slf4j
public class NewCachedThreadPool {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
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
