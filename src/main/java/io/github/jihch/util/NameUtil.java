package io.github.jihch.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameUtil {

    private static final String REGEX = "[a-z][a-z0-9]*";

    private static final Pattern PATTERN = Pattern.compile(REGEX);


    /**
     * 获得帕斯卡命名，首字母大写
     * @param tableName
     * @return
     */
    public static String getPascalName(String tableName) {

        Matcher matcher = PATTERN.matcher(tableName);

        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {

            String str = matcher.group(0);

            char firstLetter = str.charAt(0);

            char upperCase = Character.toUpperCase(firstLetter);

            str = str.replaceFirst(firstLetter + "", upperCase + "");

            buffer.append(str);

        }

        return buffer.toString();

    }

    /**
     * 获得驼峰命名
     * @param tableName
     * @return
     */
    public static String getCamelName(String tableName) {

        Matcher matcher = PATTERN.matcher(tableName);

        StringBuffer buffer = new StringBuffer();

        int i = 0;

        while (matcher.find()) {

            String str = matcher.group(0);

            if (i > 0) {

                char firstLetter = str.charAt(0);

                char upperCase = Character.toUpperCase(firstLetter);

                str = str.replaceFirst(firstLetter + "", upperCase + "");

            }

            buffer.append(str);

            i++;

        }

        return buffer.toString();

    }

    /**
     * 获得包名\资源目录名
     * @param tableName
     * @return
     */
    public static String getPackageName(String tableName) {
        String packageName = tableName.replace("_", "");
        return packageName;
    }

    public static void main(String[] args) {

//        String tableName = "stu";

//        String tableName = "stu_info";

        String tableName = "stu_course_info";

        String pascalName = NameUtil.getPascalName(tableName);

        String camelName = NameUtil.getCamelName(tableName);

        System.out.printf("pascalName: %s, camelName:%s\n", pascalName, camelName);

    }

}
