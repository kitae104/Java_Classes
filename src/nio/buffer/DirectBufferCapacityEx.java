package nio.buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

public class DirectBufferCapacityEx
{

	public static void main(String[] args)
	{
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
		System.out.println("저장 용량 : " + byteBuffer.capacity());
		
		CharBuffer charBuffer = ByteBuffer.allocateDirect(100).asCharBuffer();
		System.out.println("저장 용량 : " + charBuffer.capacity());
		
		IntBuffer intBuffer = ByteBuffer.allocateDirect(100).asIntBuffer();
		System.out.println("저장 용량 : " + intBuffer.capacity());

	}

}
