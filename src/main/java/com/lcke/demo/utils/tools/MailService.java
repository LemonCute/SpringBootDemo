package com.lcke.demo.utils.tools;

/**
 * ClassName: ascfafsfsd <br/>
 * Description: <br/>
 * date: 2020/1/12 10:28<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * <p>
 * 邮件服务
 *
 * @Author niujinpeng
 * @Date 2019/3/10 21:45
 */
@Service
@Slf4j
public class MailService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送简单文本邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleTextMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(from);
        mailSender.send(message);
        log.info("【文本邮件】成功发送！to={}", to);
    }

    /**
     * 发送 HTML 邮件
     *
     * @param to
     * @param subject
     * @param content
     * @throws MessagingException
     */
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        // true 为 HTML 邮件
        messageHelper.setText(content, true);
        mailSender.send(message);
        log.info("【HTML 邮件】成功发送！to={}", to);
    }

    /**
     * 发送带附件的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param fileArr
     */
    public void sendAttachmentMail(String to, String subject, String content, String... fileArr)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);

        // 添加附件
        for (String filePath : fileArr) {
            FileSystemResource fileResource = new FileSystemResource(new File(filePath));
            if (fileResource.exists()) {
                String filename = fileResource.getFilename();
                messageHelper.addAttachment(filename, fileResource);
            }
        }
        mailSender.send(mimeMessage);
        log.info("【附件邮件】成功发送！to={}", to);
    }

    /**
     * 发送带图片的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param imgMap
     */
    public void sendImgMail(String to, String subject, String content, Map<String, String> imgMap)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);
        // 添加图片
        for (Map.Entry<String, String> entry : imgMap.entrySet()) {
            FileSystemResource fileResource = new FileSystemResource(new File(entry.getValue()));
            if (fileResource.exists()) {
                String filename = fileResource.getFilename();
                messageHelper.addInline(entry.getKey(), fileResource);
            }
        }
        mailSender.send(mimeMessage);
        log.info("【图片邮件】成功发送！to={}", to);
    }
}
