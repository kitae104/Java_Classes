package nio.file.copy;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileCopyEx {
    public static void main(String[] args) throws IOException {
        Path from = Paths.get("src/nio/file/copy/house1.jpg");
        Path to = Paths.get("src/nio/file/copy/house2.jpg");

        FileChannel fileChannel_from = FileChannel.open(from, StandardOpenOption.READ);
        FileChannel fileChannel_target = FileChannel.open(to, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        ByteBuffer buffer = ByteBuffer.allocateDirect(100);
        int byteCount = 0;

        while(true){
            buffer.clear();
            byteCount = fileChannel_from.read(buffer);

            if(byteCount == -1) break;

            buffer.flip();
            fileChannel_target.write(buffer);
        }

        fileChannel_from.close();
        fileChannel_target.close();
        System.out.println("파일 복사 성공");
    }
}
