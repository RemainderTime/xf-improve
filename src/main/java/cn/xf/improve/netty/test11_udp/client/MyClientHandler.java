package cn.xf.improve.netty.test11_udp.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @ClassName: MyClientHandler
 * @Author: xiongfeng
 * @Date: 2023/5/5 08:55
 * @Version: 1.0
 */
public class MyClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
		String msg = datagramPacket.content().toString(Charset.forName("GBK"));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " UDP客户端接收到消息：" + msg);
	}
}
