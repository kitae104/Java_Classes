package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class AddLineNumber
{

	public static void main(String[] args) throws Exception
	{
		String filePath = "src/file/FileCopy.java";
		
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		
		int rowNumber = 0;		// 라인 앞에 붙는 번호 
		String rowData;
		
		while((rowData = br.readLine()) != null)
		{
			System.out.println(++rowNumber + ":" + rowData);
		}
		
		br.close();
		fr.close();
	}

}
