package io.github.jihch;

import io.github.jihch.entity.FormatterArgs;
import io.github.jihch.formatter.impl.ApiFileFormatter;
import io.github.jihch.formatter.impl.EntityFileFormatter;
import io.github.jihch.util.NameUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.io.IOException;


@SpringBootApplication
public class Genrator implements CommandLineRunner {

    private static final EntityFileFormatter ENTITY_FILE_WRITER = new EntityFileFormatter();

    private static final ApiFileFormatter API_FILE_FORMATTER = new ApiFileFormatter();

    private static Logger LOG = LoggerFactory.getLogger(Genrator.class);

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(Genrator.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.printf("args.length:%d\n", args.length);
        for (String s:args) {
            System.out.println(s);
        }

        System.out.println(dataSource.getConnection() != null);

//        //生成文件的输出路径
//        String outputDir = "E:\\record\\2022\\12\\6\\";
//
//        /*
//         * 表名 question 类名 Question 变量名 question
//         * 表名 sys_menu 类名 SysMenu 变量名 sysMenu
//         * */
//        String tableName = "";
//
//        String packageName = NameUtil.getPackageName(tableName);
//
//        String pascalName = NameUtil.getPascalName(tableName);
//
//        String camelName = NameUtil.getCamelName(tableName);
//
//        FormatterArgs formatterArgs = new FormatterArgs(tableName, outputDir, packageName, pascalName, camelName);
//
//        ENTITY_FILE_WRITER.format(formatterArgs);

    }

}
