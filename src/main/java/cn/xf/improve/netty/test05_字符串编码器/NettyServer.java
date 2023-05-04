package cn.xf.improve.netty.test05_字符串编码器;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description: netty服务端
 * @ClassName: NettyServer
 * @Author: xiongfeng
 * @Date: 2023/5/4 09:45
 * @Version: 1.0
 */
public class NettyServer {

	public static void main(String[] args) {
		new NettyServer().bing(7397);
	}

	private void bing(int port){
		EventLoopGroup parentGroup =new NioEventLoopGroup();
		EventLoopGroup childGroup =new NioEventLoopGroup();

		try {
			ServerBootstrap b =new ServerBootstrap();

			b.group(parentGroup, childGroup)
					.channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, 128)
					.childHandler(new MyChannelInitializer());

			ChannelFuture f = b.bind(port).sync();
			f.channel().closeFuture().sync();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			childGroup.shutdownNow();
			parentGroup.shutdownNow();
		}



	}
}
