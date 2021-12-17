package io.iostream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamEx
{

	public static void main(String[] args) throws Exception
	{
		FileOutputStream fos = new FileOutputStream("C:/Temp/primitive.dat");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("홍길동");
		dos.writeDouble(95.2);
		dos.writeInt(2);
		
		dos.writeUTF("김길동");
		dos.writeDouble(85.2);
		dos.writeInt(3);
		
		dos.flush();
		dos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("C:/Temp/primitive.dat");
		DataInputStream dis = new DataInputStream(fis);
		
		for (int i = 0; i < 2; i++)
		{
			String name = dis.readUTF();
			double score = dis.readDouble();
			int order = dis.readInt();
			
			System.out.println(name + " : " + score + " : " + order);
		}
		
		dis.close();
		fis.close();
	}

}
