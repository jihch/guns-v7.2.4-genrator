package io.github.jihch.util;

import java.io.*;

public class FileReaderUtil {

    public String read(String filename) throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("template" + File.separator + filename);
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {

        FileReaderUtil testCase = new FileReaderUtil();

        String content = testCase.read("Xxx.java");

        System.out.println(content);

    }

}
