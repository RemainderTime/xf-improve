package cn.xf.improve.netty.test11_udp.server;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @ClassName: MyServerHandler
 * @Author: xiongfeng
 * @Date: 2023/5/5 09:07
 * @Version: 1.0
 */
public class MyServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {
	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
		String msg = datagramPacket.content().toString(Charset.forName("GBK"));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " UDP服务端接收到消息：" + msg);

		//向客户端发送消息
		String json = "微信公众号：bugstack虫洞栈，通知：我已经收到你的消息\r\n";
		// 由于数据报的数据是以字符数组传的形式存储的，所以传转数据
		byte[] bytes = json.getBytes(Charset.forName("GBK"));
		DatagramPacket data = new DatagramPacket(Unpooled.copiedBuffer(bytes), datagramPacket.sender());
		channelHandlerContext.writeAndFlush(data);//向客户端发送消息
	}
}
