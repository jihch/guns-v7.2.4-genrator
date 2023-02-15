package io.github.jihch.formatter.impl;

import io.github.jihch.consts.FileEnum;
import io.github.jihch.entity.FormatterArgs;
import io.github.jihch.formatter.IFormatter;
import io.github.jihch.util.FileReaderUtil;

import java.io.IOException;

public class EntityFileFormatter extends Formatter implements IFormatter {

    private FileReaderUtil fileReaderUtil = new FileReaderUtil();

    /**
     * 写实体类文件
     */
    public void format(FormatterArgs args) {

        String template = null;
        try {
            template = fileReaderUtil.read(FileEnum.ENTITY.templateFilename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String content = String.format(template, args.getTableName(), args.getPackageName(), args.getPascalName());

        String path = String.format(FileEnum.ENTITY.outputFilepathFormat, args.getOutputDir(), args.getPackageName(), args.getPascalName());

        fileWriterUtil.write(path, content);

    }

    public static void main(String[] args) {

        FormatterArgs formatterArgs = FormatterArgs.getTestFormatterArgs();

        new EntityFileFormatter().format(formatterArgs);


    }

}
