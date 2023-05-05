package cn.xf.improve.netty.test12_http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @Description:
 * @ClassName: MyChannelInitializer
 * @Author: xiongfeng
 * @Date: 2023/5/5 09:42
 * @Version: 1.0
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		socketChannel.pipeline().addLast(new HttpResponseDecoder());
		socketChannel.pipeline().addLast(new HttpResponseEncoder());

		socketChannel.pipeline().addLast(new MyServerHandler());
	}
}
