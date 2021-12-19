package network.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * 
 * <pre>
 * 파일 전송 클라이언트 
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 12. 20.
 * @Version	:
 */
public class FileClient
{

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		Socket socket = new Socket("localhost", 5001);
		OutputStream os = socket.getOutputStream();
		
		String filePath = "images/dog.jpg";
		File file = new File(filePath);
		
		String fileName = file.getName();
		byte[] fileNameBytes = fileName.getBytes("UTF-8");
		fileNameBytes = Arrays.copyOf(fileNameBytes, 100);	// 새로운 길이 100자리 배열 생성 
		os.write(fileNameBytes);
		
		System.out.println("[파일 보내기 시작]" + fileName);
		FileInputStream fis = new FileInputStream(file);
		byte[] bytes = new byte[1000];
		int readByteCount = -1;
		
		while((readByteCount = fis.read(bytes)) != -1)
		{
			os.write(bytes, 0, readByteCount);
		}
		
		os.flush();
		
		System.out.println("[파일 보내기 완료]");
		
		fis.close();
		os.close();
		socket.close();
	}

}
