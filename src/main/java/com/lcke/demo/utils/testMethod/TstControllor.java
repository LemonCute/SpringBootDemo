package com.lcke.demo.utils.testMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
 */

/**
 * "classpath:/META-INF/resources/",
 * "classpath:/resources/",
 * "classpath:/static/",
 * "classpath:/public/"
 * "/"：当前项目的根路径
 */
@CrossOrigin
@RestController
@RequestMapping("*")
public class TstControllor {

    @Autowired
    SpringBootConfig conn;

    @GetMapping("/u")
    public String index() {
        System.out.println(conn);
//        List<String> configurations = SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(), getBeanClassLoader());
//        List<String> configurations = getCandidateConfigurations(annotationMetadata,attributes);
        return "hello spring boot";
    }

    @PostMapping(path = "/s")
    public String index1() {
        System.out.println(conn);
        return "hello spring boot s";
    }

    @GetMapping("/v")
    public String index2() {
        System.out.println(conn);
        return "hello spring boot post";
    }

    @RequestMapping("/success")
    public String success() {
        ModelMap model = new ModelMap();
        model.addAttribute("hello", "<h1>Hello World</h1>");
        model.addAttribute("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }
}
