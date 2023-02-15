package io.github.jihch.formatter.impl;

import io.github.jihch.consts.FileEnum;
import io.github.jihch.entity.FormatterArgs;
import io.github.jihch.formatter.IFormatter;

import java.io.IOException;

public class DtoFileFormatter extends Formatter implements IFormatter {
    @Override
    public void format(FormatterArgs args) {

        String template = null;
        try {
            template = fileReaderUtil.read(FileEnum.DTO.templateFilename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String content = String.format(template, args.getPackageName(), args.getPascalName());

        String path = String.format(FileEnum.DTO.outputFilepathFormat, args.getOutputDir(), args.getPackageName(), args.getPascalName());

        fileWriterUtil.write(path, content);

    }

    public static void main(String[] args) {

        FormatterArgs formatterArgs = FormatterArgs.getTestFormatterArgs();

        new DtoFileFormatter().format(formatterArgs);


    }
}
