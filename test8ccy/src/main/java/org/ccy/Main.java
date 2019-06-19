package org.ccy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        ELConfig bean = ctx.getBean(ELConfig.class);
        bean.output();
        ctx.close();
    }
}
