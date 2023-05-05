package cn.xf.improve.netty.test12_http;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description:
 * @ClassName: NettyServer
 * @Author: xiongfeng
 * @Date: 2023/5/5 09:54
 * @Version: 1.0
 */
public class NettyServer {

	public static void main(String[] args) {
		new NettyServer().bing(7397);
	}

	private void bing(int port) {
		//配置服务端NIO线程组
		EventLoopGroup parentGroup = new NioEventLoopGroup(); //NioEventLoopGroup extends MultithreadEventLoopGroup Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
		EventLoopGroup childGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(parentGroup, childGroup)
					.channel(NioServerSocketChannel.class)    //非阻塞模式
					.option(ChannelOption.SO_BACKLOG, 128)
					.childOption(ChannelOption.SO_KEEPALIVE, true)
					.childHandler(new MyChannelInitializer());
			ChannelFuture f = b.bind(port).sync();
			System.out.println("itstack-demo-netty server start done. {关注公众号：bugstack虫洞栈，获取源码}");
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			childGroup.shutdownGracefully();
			parentGroup.shutdownGracefully();
		}

	}
}
