package cn.xf.improve.netty.test02;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @Description:
 * @ClassName: MyServerHandler
 * @Author: xiongfeng
 * @Date: 2023/5/4 10:23
 * @Version: 1.0
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		ByteBuf buf = (ByteBuf) msg;
		byte[] msgByte= new byte[buf.readableBytes()];
		buf.readBytes(msgByte);
		System.out.println(new Date() + "接收消息");
		System.out.println(new String(msgByte, Charset.forName("GBK")));
	}
}
