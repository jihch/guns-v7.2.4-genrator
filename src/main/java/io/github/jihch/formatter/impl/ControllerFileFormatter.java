package io.github.jihch.formatter.impl;

import io.github.jihch.consts.FileEnum;
import io.github.jihch.entity.FormatterArgs;
import io.github.jihch.formatter.IFormatter;

import java.io.IOException;

public class ControllerFileFormatter extends Formatter implements IFormatter {
    @Override
    public void format(FormatterArgs args) {
        String template = null;
        try {
            template = fileReaderUtil.read(FileEnum.CONTROLLER.templateFilename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
        * 第一个参数：
        * 包名
        * package cn.stylefeng.guns.modular.business.%1$s.controller;
        *
        * 第二个参数类名
        * import cn.stylefeng.guns.modular.business.%1$s.entity.%2$s;
        *
        * 第三个参数变量名
        * */
        String content = String.format(template, args.getPackageName(), args.getPascalName(), args.getCamelName());

        /*
        * */
        String path = String.format(FileEnum.CONTROLLER.outputFilepathFormat, args.getOutputDir(), args.getPackageName(), args.getPascalName());

        fileWriterUtil.write(path, content);
    }
}
