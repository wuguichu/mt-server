package com.ljq.framework.netty;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.MessageDecode;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class JttDecodeHandler extends ByteToMessageDecoder {
    public JttDecodeHandler(MessageDecode decoder) {
        this.decoder = decoder;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        if (log.isDebugEnabled()) {
            String hex;
            if (byteBuf.readableBytes() < 1024)
                hex = ByteBufUtil.hexDump(byteBuf);
            else
                hex = ByteBufUtil.hexDump(byteBuf, 0, 128);
            log.debug(">>>>>收到总报文[ip={}],hex={}", channelHandlerContext.channel().remoteAddress(), hex);
        }
        AbstractInstruction instruction = decoder.decode(byteBuf);
        if (instruction != null) {
            list.add(instruction);
        }
    }

    private final MessageDecode decoder;
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}
