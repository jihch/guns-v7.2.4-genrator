package io.github.jihch.formatter.impl;

import io.github.jihch.consts.FileEnum;
import io.github.jihch.entity.FormatterArgs;
import io.github.jihch.formatter.IFormatter;

import java.io.IOException;

public class JSFileFormatter extends Formatter implements IFormatter {
    @Override
    public void format(FormatterArgs args) {
        String template = null;
        try {
            template = fileReaderUtil.read(FileEnum.JS.templateFilename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
        * 第一个占位符是 JS文件中的对象 帕斯卡命名 首字母大写
        * 第二个占位符是 HTTP 请求控制层的 Controller 路径名或JS内部变量名 驼峰命名 合成词首字母小写
        * */
        String content = String.format(template, args.getPascalName(), args.getCamelName());

        String path = String.format(FileEnum.JS.outputFilepathFormat, args.getOutputDir(), args.getCamelName());

        fileWriterUtil.write(path, content);
    }

    public static void main(String[] args) {

        FormatterArgs formatterArgs = FormatterArgs.getTestFormatterArgs();

        new JSFileFormatter().format(formatterArgs);

    }
}
