package nio.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class CompactEx
{

	public static void main(String[] args)
	{
		System.out.println("[7바이트 크기로 버퍼 생성]");
		ByteBuffer buffer = ByteBuffer.allocateDirect(7);
		buffer.put((byte) 10);
		buffer.put((byte) 11);
		buffer.put((byte) 12);
		buffer.put((byte) 13);
		buffer.put((byte) 14);
		printState(buffer);		
		buffer.flip();
		printState(buffer);		
		
		buffer.get(new byte[3]);
		System.out.println("[3바이트 읽음]");
		printState(buffer);
		
		buffer.compact();
		System.out.println("[compact() 실행후]");
		printState(buffer);
		
	}

	public static void printState(Buffer buffer) 
	{
		System.out.print("\tposition:" + buffer.position() + ", ");
		System.out.print("\tlimit:" + buffer.limit() + ", ");
		System.out.println("\tcapacity:" + buffer.capacity());
	}
}
