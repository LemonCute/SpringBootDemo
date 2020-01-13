package com.lcke.demo.utils.config;

/**
 * ClassName: sadsadasdasdsa <br/>
 * Description: <br/>
 * date: 2020/1/12 13:19<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * HTTP 强制跳转 HTTPS
 *
 * @Author niujinpeng
 * @Date 2019/4/21 17:47
 */
@Configuration
public class Http2Https {

    @Value("${server.port}")
    private int sslPort;
    @Value("${server.http-port}")
    private int httpPort;

    @Bean
    public TomcatServletWebServerFactory servletContainerFactory() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(httpPort);
        connector.setRedirectPort(sslPort);
        tomcat.addAdditionalTomcatConnectors(connector);
        return tomcat;
    }
}