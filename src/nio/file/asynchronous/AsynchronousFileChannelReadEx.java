package nio.file.asynchronous;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsynchronousFileChannelReadEx
{

	public static void main(String[] args) throws IOException
	{
		// 스레프 풀 생성 
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors());

		for (int i = 0; i < 10; i++)
		{
			Path path = Paths.get("C:/Temp/file" + i + ".txt");
			
			// 비동기 파일 채널 생성 
			AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
					path, 
					EnumSet.of(StandardOpenOption.READ), 
					executorService);
			
			ByteBuffer byteBuffer = ByteBuffer.allocate((int)fileChannel.size());
			
			// 첨부 객체 생성 
			class Attachment
			{
				Path path;
				AsynchronousFileChannel fileChannel;
				ByteBuffer byteBuffer;
			}
			
			Attachment attachment = new Attachment();
			attachment.path = path;
			attachment.fileChannel = fileChannel;
			attachment.byteBuffer = byteBuffer;
			
			// CompletionHandler 객체 생성 
			CompletionHandler<Integer, Attachment> completionHandler = 
				new CompletionHandler<Integer, Attachment>()
				{
				
					@Override	// 작업 완료시 호출 
					public void completed(Integer result, Attachment attachment)
					{
						attachment.byteBuffer.flip();
						
						Charset charset = Charset.defaultCharset();
						String data = charset.decode(attachment.byteBuffer).toString();
						
						System.out.println(attachment.path.getFileName() + " : " + data + " : " + Thread.currentThread().getName());
						try
						{
							attachment.fileChannel.close();
						} 
						catch (IOException e)
						{
							e.printStackTrace();
						}
						
					}

					@Override	// 예외 발생시 호출 
					public void failed(Throwable exc, Attachment attachment)
					{
						exc.printStackTrace();
						try
						{
							attachment.fileChannel.close();
						} 
						catch (IOException e)
						{
							e.printStackTrace();
						}
					}
					
				};
								
			fileChannel.read(byteBuffer, 0, attachment, completionHandler);
		}
		
		// 스레프 풀 종료
		executorService.shutdown();	
	}

}
