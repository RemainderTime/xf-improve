package cn.xf.improve.netty.test10_服务端客户端.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Description:
 * @ClassName: NettyClient
 * @Author: xiongfeng
 * @Date: 2023/5/4 14:52
 * @Version: 1.0
 */
public class NettyClient {

	public static void main(String[] args) {
		new NettyClient().connect("127.0.0.1", 7397);
	}

	private void connect(String inetHost, int inetPort) {
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			Bootstrap b = new Bootstrap();
			b.group(workerGroup);
			b.channel(NioSocketChannel.class);
			b.option(ChannelOption.AUTO_READ, true);
			b.handler(new MyChannelInitializer());
			ChannelFuture f = b.connect(inetHost, inetPort).sync();

			f.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workerGroup.shutdownNow();
		}
	}
}
