package nio.path;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileSystemEx
{

	public static void main(String[] args)
	{
		FileSystem fileSystem = FileSystems.getDefault();
		
		for (FileStore store : fileSystem.getFileStores())
		{
			System.out.println("드라이버명 : " + store.name());
			System.out.println("파일시스템 : " + store.type());
		}
		
		System.out.println("파일 구분자 : " + fileSystem.getSeparator());
		
		for(Path path : fileSystem.getRootDirectories())
		{
			System.out.println(path.toString());
		}
	}

}
