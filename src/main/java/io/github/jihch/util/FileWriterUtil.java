package io.github.jihch.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileWriterUtil {

    public void write(String path, String content) {

        File dstFile = new File(path);

        File parentFile = dstFile.getParentFile();

        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }

        try {
            PrintStream ps = new PrintStream(new FileOutputStream(dstFile));
            ps.print(content);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
