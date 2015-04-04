/** 
 *  Copyright (c) 2015 The original author or authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0

 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.reveno.atp.core.channel;

import static org.reveno.atp.utils.MeasureUtils.kb;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;

import org.reveno.atp.core.api.channel.Buffer;

public class NettyBasedBuffer implements Buffer {

	public NettyBasedBuffer() {
		this(kb(64), true);
	}

	public NettyBasedBuffer(boolean direct) {
		this(kb(64), direct);
	}
	
	public NettyBasedBuffer(int length, boolean direct) {
		this.buffer = direct ? Unpooled.directBuffer(length) : Unpooled.buffer(length);
	}
	
	@Override
	public byte[] getBytes() {
		byte[] bytes = new byte[buffer.writerIndex()];
		buffer.readBytes(bytes, 0, buffer.writerIndex());
		buffer.resetReaderIndex();
		
		return bytes;
	}

	@Override
	public int length() {
		return buffer.writerIndex();
	}

	@Override
	public void clear() {
		buffer.clear();
	}

	@Override
	public void writeBytes(byte[] bytes) {
		buffer.writeBytes(bytes);
	}

	@Override
	public void writeLong(long value) {
		buffer.writeLong(value);
	}

	@Override
	public void writeInt(int value) {
		buffer.writeInt(value);
	}
	
	@Override 
	public void writeFromBuffer(ByteBuffer bb) {
		buffer.writeBytes(bb);
	}

	@Override
	public byte[] readBytes() {
		return readBytes(buffer.readableBytes());
	}

	@Override
	public byte[] readBytes(int length) {
		throw new UnsupportedOperationException("Current implementation is using Direct Unpooled buffers, use getBytes() instead.");
	}

	@Override
	public long readLong() {
		return buffer.readLong();
	}

	@Override
	public int readInt() {
		return buffer.readInt();
	}
	
	@Override
	public int hashCode() {
		return buffer.hashCode();
	}
	
	
	private final ByteBuf buffer;
	
}