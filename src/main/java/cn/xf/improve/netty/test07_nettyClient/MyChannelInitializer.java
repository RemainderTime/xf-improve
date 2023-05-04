package cn.xf.improve.netty.test07_nettyClient;

import cn.xf.improve.netty.test06_群发消息.MyServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;

/**
 * @Description:
 * @ClassName: MyChannelInitializer
 * @Author: xiongfeng
 * @Date: 2023/5/4 10:07
 * @Version: 1.0
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel channel) throws Exception {

		System.out.println("链接报告开始");
		System.out.println("链接报告信息：本客户端链接到服务端。channelId：" + channel.id());
		System.out.println("链接报告完毕");

	}

}
