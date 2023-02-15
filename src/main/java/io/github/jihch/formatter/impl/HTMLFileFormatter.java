package io.github.jihch.formatter.impl;

import io.github.jihch.consts.FileEnum;
import io.github.jihch.entity.FormatterArgs;
import io.github.jihch.formatter.IFormatter;

import java.io.IOException;

public class HTMLFileFormatter extends Formatter implements IFormatter {
    @Override
    public void format(FormatterArgs args) {
        String template = null;
        try {
            template = fileReaderUtil.read(FileEnum.HTML.templateFilename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
        * 第一个参数：
        * JS所在路径的父目录和JS文件名 /assets/modular/business/%1$s/%1$s.js 驼峰命名 合成词 首字母小写 之后每个单词首字母大写
        * html 标签属性值 <table class="layui-table" id="%1$sTable" lay-filter="%1$sTable"></table> 驼峰命名
        * */
        String content = String.format(template, args.getCamelName());

        /*
        * 生成文件输出路径
        *
        * 第一个参数：
        * 生成文件的输出路径
        *
        * 第二个参数：
        * html文件的父目录 和 html文件名
        * "%1$s\\src\\main\\webapp\\pages\\modular\\business\\%2$s\\%2$s.html"
        * 驼峰命名
        * */
        String path = String.format(FileEnum.HTML.outputFilepathFormat, args.getOutputDir(), args.getCamelName());

        fileWriterUtil.write(path, content);
    }

    public static void main(String[] args) {

        FormatterArgs formatterArgs = FormatterArgs.getTestFormatterArgs();

        new HTMLFileFormatter().format(formatterArgs);

    }
}
