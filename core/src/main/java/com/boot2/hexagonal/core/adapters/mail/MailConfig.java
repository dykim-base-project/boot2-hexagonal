package com.boot2.hexagonal.core.adapters.mail;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

  @Value("${smtp.host}")
  private String host;

  @Value("${smtp.port}")
  private String port;

  @Value("${smtp.username}")
  private String username;

  @Bean
  public MailSender mailSender() {
    var password = System.getenv("SMTP_PASSWORD");

    var javaMailSender = new JavaMailSenderImpl();
    javaMailSender.setHost(host);
    javaMailSender.setPort(Integer.parseInt(port));
    javaMailSender.setUsername(username);
    javaMailSender.setPassword(password);
    javaMailSender.setJavaMailProperties(getMailProperties());
    return javaMailSender;
  }

  private Properties getMailProperties() {
    Properties properties = new Properties();
    properties.setProperty("mail.transport.protocol", "smtp"); // 프로토콜 설정
    properties.setProperty("mail.smtp.auth", "true"); // smtp 인증
    properties.setProperty("mail.smtp.starttls.enable", "true"); // smtp strattles 사용
    properties.setProperty("mail.debug", "true"); // 디버그 사용
    properties.setProperty("mail.smtp.ssl.trust", "smtp.naver.com"); // ssl 인증 서버 (smtp 서버명)
    properties.setProperty("mail.smtp.ssl.enable", "true"); // ssl 사용
    return properties;
  }
}
