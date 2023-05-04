package cn.xf.improve.netty.test04_收发数据;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;

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
		//通知客户端连接成功
		String str = "通知客户端链接建立成功" + " " + new Date() + " " + channel.localAddress().getHostString() + "\r\n";
		ByteBuf buffer = Unpooled.buffer(str.getBytes().length);
		buffer.writeBytes(str.getBytes("GBK"));
		ctx.writeAndFlush(buffer);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		//直接获取消息，不用手动转码
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + msg);
		//通知客户端链消息发送成功
		String str = "服务端收到：" + new Date() + " " + msg + "\r\n";
		ByteBuf buf = Unpooled.buffer(str.getBytes().length);
		buf.writeBytes(str.getBytes("GBK"));
		ctx.writeAndFlush(buf);
	}

	/**
	 * new 抓住异常，当发生异常的时候，可以做一些相应的处理，比如打印日志、关闭链接
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
		System.out.println("异常信息：\r\n" + cause.getMessage());
	}
}
