package nio.file.copy;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class FileCopyEx2 {
    public static void main(String[] args) throws IOException {
        Path from = Paths.get("src/nio/file/copy/house1.jpg");
        Path to = Paths.get("src/nio/file/copy/house3.jpg");

        Files.copy(from, to, StandardCopyOption.COPY_ATTRIBUTES);

        System.out.println("파일 복사 성공1");
    }
}
