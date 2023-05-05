package cn.xf.improve.netty.test11_udp.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * @Description:
 * @ClassName: NettyServer
 * @Author: xiongfeng
 * @Date: 2023/5/5 09:13
 * @Version: 1.0
 */
public class NettyServer {

	public static void main(String[] args) {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();

			b.group(group)
					.channel(NioDatagramChannel.class)
					.option(ChannelOption.SO_BROADCAST, true) //广播
					.option(ChannelOption.SO_RCVBUF, 2048 * 1024) //设置UDP读缓冲区 2M
					.option(ChannelOption.SO_SNDBUF, 1024 * 1024) //设置UDP写缓存区 1M
					.handler(new MyChannelInitializer());

			ChannelFuture f = b.bind(7397).sync();
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			group.shutdownNow();
		}

	}
}
