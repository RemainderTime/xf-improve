package cn.xf.improve.netty.test03_解码器;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
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
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		SocketChannel channel = (SocketChannel) ctx.channel();
		System.out.println("链接报告开始----解码器");
		System.out.println("链接报告信息：有一客户端链接到本服务端");
		System.out.println("链接报告IP:" + channel.localAddress().getHostString());
		System.out.println("链接报告Port:" + channel.localAddress().getPort());
		System.out.println("链接报告完毕");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		//直接获取消息，不用手动转码
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + msg);


	}
}
