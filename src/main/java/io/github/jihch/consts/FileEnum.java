package io.github.jihch.consts;

public enum FileEnum {

    //实体类
    ENTITY("%1$s\\src\\main\\java\\cn\\stylefeng\\guns\\modular\\business\\%2$s\\entity\\%3$s.java",
            "XxxXxx.java"),

    API("%1$s\\src\\main\\java\\cn\\stylefeng\\guns\\modular\\business\\%2$s\\api\\%3$sApi.java",
            "XxxXxxApi.java"),

    DTO("%1$s\\src\\main\\java\\cn\\stylefeng\\guns\\modular\\business\\%2$s\\api\\pojo\\%3$sDto.java",
            "XxxXxxDto.java"),

    MAPPER("%1$s\\src\\main\\java\\cn\\stylefeng\\guns\\modular\\business\\%2$s\\mapper\\%3$sMapper.java",
            "XxxXxxMapper.java"),

    MAPPER_XML("%1$s\\src\\main\\java\\cn\\stylefeng\\guns\\modular\\business\\%2$s\\mapper\\mapping\\%3$sMapper.xml",
            "XxxXxxMapper.xml"),

    SERVICE("%1$s\\src\\main\\java\\cn\\stylefeng\\guns\\modular\\business\\%2$s\\service\\%3$sService.java",
            "XxxXxxService.java"),

    SERVICE_IMPL("%1$s\\src\\main\\java\\cn\\stylefeng\\guns\\modular\\business\\%2$s\\service\\impl\\%3$sServiceImpl.java",
            "XxxXxxServiceImpl.java"),


    REQUEST("%1$s\\src\\main\\java\\cn\\stylefeng\\guns\\modular\\business\\%2$s\\api\\request\\%3$sRequest.java",
            "XxxXxxRequest.java"),

    /*
    * 第一个占位符是输出路径
    * 第二个占位符是父目录 合成词会是驼峰命名
    * 第三个占位符是文件名 合成词是下划线分隔同表名或驼峰命名首字母小写无分隔符*/
    JS("%1$s\\src\\main\\webapp\\assets\\modular\\business\\%2$s\\%2$s.js",
                    "xxxXxx.js"),

    /*
     * 第一个占位符是输出路径
     * 第二个占位符是父目录 合成词会是驼峰命名
     * 第三个占位符是文件名 合成词是下划线分隔同表名或驼峰命名首字母小写无分隔符*/
    HTML("%1$s\\src\\main\\webapp\\pages\\modular\\business\\%2$s\\%2$s.html",
            "xxxXxx.html"),

    CONTROLLER("%1$s\\src\\main\\java\\cn\\stylefeng\\guns\\modular\\business\\%2$s\\%3$sController",
                 "XxxXxxController.java");


    public final String outputFilepathFormat;

    public final String templateFilename;


    FileEnum(String outputFilepathFormat, String templateFilename) {
        this.outputFilepathFormat = outputFilepathFormat;
        this.templateFilename = templateFilename;
    }

}
