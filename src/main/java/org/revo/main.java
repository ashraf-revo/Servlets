package org.revo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ashraf on 5/16/15.
 */
public class main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
        MailMail mm = (MailMail) context.getBean("mailMail");
        mm
                .sendMail("asha","ashraf1abdelrasool@gmail.com","hjkhk","hjgjgjh");
    }
}
