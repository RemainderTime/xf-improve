package cn.xf.improve.netty.test10_服务端客户端.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @Description:
 * @ClassName: MyOutMsgHandler
 * @Author: xiongfeng
 * @Date: 2023/5/5 08:26
 * @Version: 1.0
 */
public class MyOutMsgHandler extends ChannelOutboundHandlerAdapter {

	@Override
	public void read(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush("ChannelOutboundHandlerAdapter.read 发来一条消息\r\n");
		super.read(ctx);
	}

	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		ctx.writeAndFlush("ChannelOutboundHandlerAdapter.write 发来一条消息\r\n");
		super.write(ctx, msg, promise);
	}
}
