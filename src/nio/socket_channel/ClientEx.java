package nio.socket_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ClientEx
{

	public static void main(String[] args)
	{
		SocketChannel socketChannel = null;

		try
		{
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(true);
			System.out.println("[연결 요청]");
			socketChannel.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("[연결 성공]");
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}

		// 서버 소캣 채널 닫기
		if (socketChannel.isOpen())
		{
			try
			{
				socketChannel.close();
			} 
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
