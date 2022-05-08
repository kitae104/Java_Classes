package project.javaeditor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CmdRnd
{
	private StringBuffer buffer;
	private Process process;

	private final String FILENAME = "Test.java";
	private File file;
	private BufferedWriter bufferWriter;

	public String inputSource(String source)
	{
		buffer = new StringBuffer();
		
		buffer.append("cmd.exe ");
		buffer.append("/c ");
		buffer.append("javac Test.java");
		
		createFileAsSource(source);
		
		return buffer.toString();
	}

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
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
