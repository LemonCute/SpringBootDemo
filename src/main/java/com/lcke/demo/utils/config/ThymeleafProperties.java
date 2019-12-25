package com.lcke.demo.utils.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import java.nio.charset.Charset;

@Component
@ConfigurationProperties(prefix = "spring.thymeleaf")
public class ThymeleafProperties {
    //默认编码
    private static final Charset DEFAULT_ENCODING = Charset.forName("UTF-8");
    //文档类型
    private static final MimeType DEFAULT_CONTENT_TYPE = MimeType.valueOf("text/html");
    //模版位置
    public static final String DEFAULT_PREFIX = "classpath:/templates/";
    //模版后缀
    public static final String DEFAULT_SUFFIX = ".html";

    private boolean checkTemplate = true;

    private boolean checkTemplateLocation = true;

    private String prefix = DEFAULT_PREFIX;

    private String suffix = DEFAULT_SUFFIX;

    private String mode = "HTML5";

    private Charset encoding = DEFAULT_ENCODING;

    private MimeType contentType = DEFAULT_CONTENT_TYPE;
    //缓存
    private boolean cache = true;

    private Integer templateResolverOrder;

    private String[] viewNames;

    private String[] excludedViewNames;

    private boolean enabled = true;


}