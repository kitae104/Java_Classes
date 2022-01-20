package nio.socket_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerEx
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
