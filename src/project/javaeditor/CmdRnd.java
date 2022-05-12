package project.javaeditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdRnd
{
	private StringBuffer buffer;
	private Process process;

	private final String FILENAME = "Test.java";
	private File file;
	private BufferedWriter bufferWriter;
	private BufferedReader bufferedReader;
	private StringBuffer readBuffer;

	public String inputSource(String source)
	{
		buffer = new StringBuffer();
		
		buffer.append("cmd.exe /c javac "); 
		buffer.append(FILENAME);
		
		createFileAsSource(source);
		
		return buffer.toString();
	}

	/**
	 *  텍스트 내용을 파일로 생성하기 - 저장 동작으로 수행 가능 
	 * @param source
	 */
	private void createFileAsSource(String source)
	{
		try
		{
			file = new File(FILENAME);
			bufferWriter = new BufferedWriter(new FileWriter(file, false));
			bufferWriter.write(source);
			bufferWriter.flush();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		finally
		{
			try
			{
				bufferWriter.close();
				file = null;
			} 
			catch (IOException e)
			{				
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
	
	public String execCommand(String cmd) {
		try
		{
			process = Runtime.getRuntime().exec(cmd);
			
			
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null; 
			readBuffer  = new StringBuffer();
			
			while((line = bufferedReader.readLine()) != null) {
				readBuffer.append(line);
				readBuffer.append("\n");
			}
			System.out.println("========================================");
			System.out.println(readBuffer.toString());
			System.out.println("========================================");
			
			process = Runtime.getRuntime().exec(runClass());
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			line = null; 
			readBuffer  = new StringBuffer();
			
			while((line = bufferedReader.readLine()) != null) {
				readBuffer.append(line);
				readBuffer.append("\n");
			}
			
			return readBuffer.toString();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 클래스 파일 수행하는 코드 
	 * @return
	 */
	private String runClass() {
		buffer = new StringBuffer();
		buffer.append("cmd.exe /c java ");
		buffer.append(FILENAME);
		return buffer.toString();
	}
}
