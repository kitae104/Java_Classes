package network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * <pre>
 * 기본적인 소켓 서버 
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 12. 18.
 * @Version	:
 */
public class ServerEx
{

	public static void main(String[] args)
	{
		ServerSocket serverSocket = null;
		
		try
		{
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			
			while(true)
			{
				System.out.println("[연결 기다림]");
				Socket socket = serverSocket.accept();	// 연결 요청 수락 
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결 수락함]" + isa.getHostName());  	// 클라이언트의 주소 출력
				
				byte[] bytes = null;
				String message = null;
				
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes);	// 읽어들인 바이트 수 
				message = new String(bytes,0, readByteCount, "UTF-8");				
				System.out.println("[데이터 받기 성공] " + message);
				
				OutputStream os = socket.getOutputStream();
				message = "Hello Client";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[데이터 보내기 성공]");
				
				is.close();
				os.close();
				socket.close();
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		if(!serverSocket.isClosed())
		{
			try
			{
				serverSocket.close();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
