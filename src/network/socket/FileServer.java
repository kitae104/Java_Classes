package network.socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * <pre>
 * 파일 전송 서버 
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 12. 20.
 * @Version	:
 */
public class FileServer
{

	public static void main(String[] args) throws IOException
	{
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("localhost", 5001));
		
		System.out.println("[서버 시작]");
		
		while(true) {
			try
			{
				Socket socket = serverSocket.accept();
				InputStream is = socket.getInputStream();
				
				byte[] bytes = new byte[1000];
				int readByteCount = -1;
				
				is.read(bytes, 0, 100);
				String fileName = new String(bytes, 0, 100, "UTF-8");
				fileName = fileName.trim();
				
				System.out.println("[파일 받기 시작] " + fileName);
				FileOutputStream fos = new FileOutputStream("C:/Temp/" + fileName);
				
				while((readByteCount = is.read(bytes)) != -1)
				{
					fos.write(bytes, 0, readByteCount);
				}
				
				System.out.println("[파일 받기 완료]");
				
				fos.flush();
				fos.close();
				is.close();
				socket.close();				
				
			} 
			catch (Exception e)
			{
				
			}
		}

	}

}
