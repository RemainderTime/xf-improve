package cn.xf.improve.netty.test11_udp.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @Description: UDP传输客户端
 * @ClassName: NettyClient
 * @Author: xiongfeng
 * @Date: 2023/5/5 09:01
 * @Version: 1.0
 */
public class NettyClient {

	public static void main(String[] args) {
		EventLoopGroup group =new NioEventLoopGroup();
		try {
			Bootstrap b =new Bootstrap();
			b.group(group)
					.channel(NioDatagramChannel.class)
					.handler(new MyChannelInitializer());
			Channel ch =b.bind(7398).sync().channel();
			//向端口发送消息
			ch.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("你好端口7397哈哈哈哈", Charset.forName("GBK")),
					new InetSocketAddress("127.0.0.1",7397))).sync();
			ch.closeFuture().await();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			group.shutdownNow();
		}
	}
}
