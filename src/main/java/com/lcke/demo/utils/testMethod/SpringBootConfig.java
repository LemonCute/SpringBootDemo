package com.lcke.demo.utils.testMethod;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 将配置文件中的配置的每一个属性值，映射到组件中
 *
 * @ConfigurationProperties: 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定。
 * prefix: 配置文件中的prefix指定的属性下的所有属性与该组件属性一一对应。
 * @ConfigurationProperties: 默认从全局配置文件中获取值
 * <p>
 * 只有这个组件是容器中的组件，容器才能提供@ConfigurationProperties功能。
 */
/**
 * @Conditional扩展注解 作用（判断是否满足当前指定条件）
 *
 * @ConditionalOnJava 系统的java版本是否符合要求
 * @ConditionalOnBean 容器中存在指定Bean
 * @ConditionalOnMissingBean 容器中不存在指定Bean
 * @ConditionalOnExpression 满足SpEL表达式指定
 * @ConditionalOnClass 系统中有指定的类
 * @ConditionalOnMissingClass 系统中没有指定的类
 * @ConditionalOnSingleCandidate 容器中只有一个指定的Bean，或者这个Bean是首选Bean
 * @ConditionalOnProperty 系统中指定的属性是否有指定的值
 * @ConditionalOnResource 类路径下是否存在指定资源文件
 * @ConditionalOnWebApplication 当前是web环境
 * @ConditionalOnNotWebApplication 当前不是web环境
 * @ConditionalOnJndi JNDI存在指定项
 */

/**
 * @Component,@Service,@Controller,@Repository 注解的类，并把这些类纳入进spring容器中管理。
 * 1、@Service用于标注业务层组件
 * 2、@Controller用于标注控制层组件(如struts中的action)
 * 3、@Repository用于标注数据访问组件，即DAO组件.
 * 4、@Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
 */
@Component
@PropertySource(value = {"classpath:application.properties"}, encoding = "UTF-8")
@ConfigurationProperties(prefix = "person", ignoreUnknownFields = true)
@Validated
public class SpringBootConfig implements Serializable {
    private String name;
    @NotNull(message = "age不能为空！")
    private Integer age;
    private List<Object> lists;

    @Value(value = "${person.value}")
    public String value;
    /**
     * ${random.value}
     * ${random.int}
     * ${random.int(max)}
     * ${random.int(min,max)}
     * ${random.long}
     * ${random.long(max)}
     * ${random.long(min,max)}
     * ${random.uuid}
     */
    @Value(value = "${random.int}")
    private int myrandom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", lists=").append(lists);
        sb.append(", value=").append(value);
        sb.append(", myrandom=").append(myrandom);
        sb.append('}');
        return sb.toString();
    }

}
