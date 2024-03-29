package nio.socket_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerEx2
{

	public static void main(String[] args)
	{
		ServerSocketChannel serverSocketChannel = null;
		
		try
		{
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(true);		// 블록킹 방식 사용 
			serverSocketChannel.bind(new InetSocketAddress(5001));
			
			while(true) 
			{
				System.out.println("연결 기다림...");
				SocketChannel socketChannel = serverSocketChannel.accept();
				InetSocketAddress isa = (InetSocketAddress) socketChannel.getRemoteAddress();
				System.out.println("[연결 수락함]" + isa.getHostName());
				
				ByteBuffer byteBuffer = null;
				Charset charset = Charset.forName("UTF-8");
				
				byteBuffer = ByteBuffer.allocate(100);
				int byteCount = socketChannel.read(byteBuffer);
				
				byteBuffer.flip();
				String message = charset.decode(byteBuffer).toString();
				System.out.println("[데이터 받기 성공]" + message);
				
				byteBuffer = charset.encode("Hello, Client");
				socketChannel.write(byteBuffer);
				System.out.println("[데이터 보내기 성공]");
			}
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		// 서버 소캣 채널 닫기 
		if(serverSocketChannel.isOpen())
		{
			try
			{
				serverSocketChannel.close();
			} 
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
