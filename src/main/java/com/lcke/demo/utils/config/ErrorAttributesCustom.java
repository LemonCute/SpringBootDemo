package com.lcke.demo.utils.config;

/**
 * ClassName: sdsadsadsasa <br/>
 * Description: <br/>
 * date: 2020/1/9 22:15<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 自定义错误信息JSON值
 *
 * @Author niujinpeng
 * @Date 2019/1/7 15:21
 */
@Component
public class ErrorAttributesCustom extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        String code = map.get("status").toString();
        String message = map.get("error").toString();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", code);
        hashMap.put("message", message);
        return hashMap;
    }
}