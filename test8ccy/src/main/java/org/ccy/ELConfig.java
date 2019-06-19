package org.ccy;

import com.sun.javafx.runtime.SystemProperties;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import sun.nio.ch.IOUtil;

import java.io.IOException;
import java.util.ArrayList;

@Configuration
@ComponentScan("org.ccy")
@PropertySource(value = "t.properties", encoding = "UTF-8")
public class ELConfig {
    @Value("I love you!")
    private String normal;
    @Value("#{systemProperties['os.name']}")
    private String osName;
    @Value("#{systemProperties['os.arch']}")
    private String osArch;
    @Value("#{T(java.lang.Math).random() * 100}")
    private double randomNumber;
    @Value("#{demoService1.getAuthor()}")
    private String author;
    @Value("t.txt")
    private Resource testFile;
    @Value("http://www.baidu.com")
    private Resource testUrl;
    @Value("${ccy.username}")
    private String su;
    @Value("${sang.password}")
    private String sp;
    @Value("${sang.nickname}")
    private String sn;
    @Autowired
    private Environment environment;

    public void output() {
        System.out.println(normal);
        System.out.println(osName);
        System.out.println(osArch);
        System.out.println(randomNumber);
        System.out.println(author);
        SystemProperties systemProperties = new SystemProperties();
        System.out.println("system properties：");
        System.out.println(systemProperties);

        //获取网址
        System.out.println(su);
        System.out.println(sp);
        System.out.println(sn);
        String[] properties = environment.getActiveProfiles();
        for (int i = 0; i < properties.length; i++) {
            System.out.println("property" + i + "：" + properties[i]);
        }
        System.out.println();
        try {
            System.out.println(IOUtils.toString(testFile.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
