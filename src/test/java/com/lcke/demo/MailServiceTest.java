package com.lcke.demo;

/**
 * ClassName: sadasdasdas <br/>
 * Description: <br/>
 * date: 2020/1/12 10:29<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */

import com.lcke.demo.utils.tools.MailService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

//创建 Springboot 的单元测试类测试文本邮件，实验中的收信人为了方便，都设置成了自己的邮箱。
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;
    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendSimpleTextMailTest() {
        String to = "hostnow@lcke.xyz";
        String subject = "Springboot 发送简单文本邮件";
        String content = "<p>第一封 Springboot 简单文本邮件</p>";
        mailService.sendSimpleTextMail(to, subject, content);
    }

    @Test
    public void sendHtmlMailTest() throws MessagingException {
        String to = "hostnow@lcke.xyz";
        String subject = "Springboot 发送 HTML 邮件";
        String content = "<h2>Hi~</h2><p>第一封 Springboot HTML 邮件</p>";
        mailService.sendHtmlMail(to, subject, content);
    }

    @Test
    public void sendAttachmentTest() throws MessagingException {
        String to = "hostnow@lcke.xyz";
        String subject = "Springboot 发送 HTML 附件邮件";
        String content = "<h2>Hi~</h2><p>第一封 Springboot HTML 附件邮件</p>";
        String filePath = "pom.xml";
        mailService.sendAttachmentMail(to, subject, content, filePath, filePath);
    }

    @Test
    public void sendImgTest() throws MessagingException {
        String to = "hostnow@lcke.xyz";
        String subject = "Springboot 发送 HTML 图片邮件";
        String content =
                "<h2>Hi~</h2><p>第一封 Springboot HTML 图片邮件</p><br/><img src=\"cid:img01\" /><img src=\"cid:img02;\" />";
        String imgPath = "apple.png";
        Map<String, String> imgMap = new HashMap<>();
        imgMap.put("img01", imgPath);
        imgMap.put("img02", imgPath);
        mailService.sendImgMail(to, subject, content, imgMap);
//        /* 创建html内容，若不创建html标签,则图片会以附件的形式发送，而并非直接以内容显示 */
//        String content = "<html><body>" + text + "<img src=\'cid:" + imgId + "\'></img>" + "</body></html>";
//        helper.setText(content, true);// text：内容，true:为HTML邮件（false则为普通文本邮件）
//        File file = new File(imgPath);// 创建图片文件
//        FileSystemResource resource = new FileSystemResource(file);
//        helper.addInline(imgId, resource);
//        mailSender.send(mimeMessage);// 发送邮件
    }
}