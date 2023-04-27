package cn.xf.improve.thread.txecutors;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 延迟线程池
 * @ClassName: NewScheduledThreadPool
 * @Author: xiongfeng
 * @Date: 2023/4/23 10:44
 * @Version: 1.0
 */

@Slf4j
public class NewScheduledThreadPool {

	public static void main(String[] args) {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		executorService.schedule(() -> {
			log.info("3秒后开始执行");
		}, 3, TimeUnit.SECONDS);
		executorService.scheduleAtFixedRate(() -> {
			log.info("3秒后开始执行，以后每2秒执行一次");
		}, 3, 2, TimeUnit.SECONDS);
		executorService.scheduleWithFixedDelay(() -> {
			log.info("3秒后开始执行，后续延迟2秒");
		}, 3, 2, TimeUnit.SECONDS);
	}
}
