package cn.xf.improve.netty.test08_nettyClient特殊处理;

import cn.xf.improve.netty.test06_群发消息.MyServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
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
		// 基于换行符号
		channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
		// 解码转String，注意调整自己的编码格式GBK、UTF-8
		channel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
		// 解码转String，注意调整自己的编码格式GBK、UTF-8
		channel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
		// 在管道中添加我们自己的接收数据实现方法
		channel.pipeline().addLast(new MyClientHandler());
	}

}
