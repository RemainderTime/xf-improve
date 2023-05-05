package cn.xf.improve.netty.test11_udp.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * @Description:
 * @ClassName: MyChannelInitializer
 * @Author: xiongfeng
 * @Date: 2023/5/5 09:12
 * @Version: 1.0
 */
public class MyChannelInitializer extends ChannelInitializer<NioDatagramChannel> {

	private EventLoopGroup group = new NioEventLoopGroup();

	@Override
	protected void initChannel(NioDatagramChannel nioDatagramChannel) throws Exception {
		ChannelPipeline pipeline = nioDatagramChannel.pipeline();
		// 解码转String，注意调整自己的编码格式GBK、UTF-8
		//pipeline.addLast("stringDecoder", new StringDecoder(Charset.forName("GBK")));
		pipeline.addLast(group, new MyServerHandler());
	}
}
