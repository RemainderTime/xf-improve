package cn.xf.improve.netty.test11_udp.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * @Description:
 * @ClassName: MyChannelInitializer
 * @Author: xiongfeng
 * @Date: 2023/5/5 08:59
 * @Version: 1.0
 */
public class MyChannelInitializer extends ChannelInitializer<NioDatagramChannel> {
	@Override
	protected void initChannel(NioDatagramChannel nioDatagramChannel) throws Exception {
		ChannelPipeline pipeline =nioDatagramChannel.pipeline();

		pipeline.addLast(new MyClientHandler());
	}
}
