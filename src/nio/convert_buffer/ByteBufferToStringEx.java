package nio.convert_buffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class ByteBufferToStringEx
{

	public static void main(String[] args)
	{
		Charset charset = Charset.forName("UTF-8");
		
		String data = "안녕하세요";
		ByteBuffer byteBuffer = charset.encode(data);
		System.out.println(byteBuffer);
		
		data = charset.decode(byteBuffer).toString();
		System.out.println(data);
	}

}
