package io.github.jihch.entity;

import io.github.jihch.util.NameUtil;

public class FormatterArgs {

    private String tableName;

    private String outputDir;

    private String packageName;

    private String pascalName;

    private String camelName;

    public FormatterArgs(String tableName, String outputDir, String packageName, String pascalName, String camelName) {
        this.tableName = tableName;
        this.outputDir = outputDir;
        this.packageName = packageName;
        this.pascalName = pascalName;
        this.camelName = camelName;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getPascalName() {
        return pascalName;
    }

    public String getCamelName() {
        return camelName;
    }

    public String getTableName() {
        return tableName;
    }


    public static FormatterArgs getTestFormatterArgs() {

        //生成文件的输出路径
        String outputDir = "E:\\record\\2022\\12\\7\\";

        /*
         * 表名 question 类名 Question 变量名 question
         * 表名 sys_menu 类名 SysMenu 变量名 sysMenu
         * */
        String tableName = "student_info";

        String packageName = NameUtil.getPackageName(tableName);

        String pascalName = NameUtil.getPascalName(tableName);

        String camelName = NameUtil.getCamelName(tableName);

        FormatterArgs formatterArgs = new FormatterArgs(tableName, outputDir, packageName, pascalName, camelName);

        return formatterArgs;

    }
}
