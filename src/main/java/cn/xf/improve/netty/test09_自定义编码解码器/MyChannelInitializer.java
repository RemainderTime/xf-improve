package cn.xf.improve.netty.test09_自定义编码解码器;

import cn.xf.improve.netty.test05_字符串编码器.MyServerHandler;
import cn.xf.improve.netty.test09_自定义编码解码器.codec.MyDecoder;
import cn.xf.improve.netty.test09_自定义编码解码器.codec.MyEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;

/**
 * @Description:
 * @ClassName: MyChannelInitializer
 * @Author: xiongfeng
 * @Date: 2023/5/4 10:07
 * @Version: 1.0
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel channel) throws Exception {

		//添加解码器
//		channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
		//设置字符转换格式
		channel.pipeline().addLast(new MyDecoder());
		//new 设置字符串编码器
		channel.pipeline().addLast(new MyEncoder());

		//在管道中添加自己的接收数据实现方法
		channel.pipeline().addLast(new MyServerHandler());

	}

}
