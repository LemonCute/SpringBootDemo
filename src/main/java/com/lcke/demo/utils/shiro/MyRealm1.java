package com.lcke.demo.utils.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * ClassName: MyRealm1 <br/>
 * Description: 单 Realm 配置
 * 1、自定义 Realm 实现（com.github.zhangkaitao.shiro.chapter2.realm.MyRealm1）：<br/>
 * date: 2020/1/14 15:00<br/>
 ****
 * 以后一般继承 AuthorizingRealm（授权）即可；其继承了 AuthenticatingRealm（即身份验证），而且也间接继承了 CachingRealm（带有缓存实现）。其中主要默认实现如下：
 * org.apache.shiro.realm.text.IniRealm：[users] 部分指定用户名 / 密码及其角色；[roles] 部分指定角色即权限信息；
 * org.apache.shiro.realm.text.PropertiesRealm： user.username=password,role1,role2 指定用户名 / 密码及其角色；role.role1=permission1,permission2 指定角色及权限信息；
 * org.apache.shiro.realm.jdbc.JdbcRealm：通过 sql 查询相应的信息，如 “select password from users where username = ?” 获取用户密码，“select password, password_salt from users where username = ?” 获取用户密码及盐；“select role_name from user_roles where username = ?” 获取用户角色；“select permission from roles_permissions where role_name = ?” 获取角色对应的权限信息；也可以调用相应的 api 进行自定义 sql；
 * JDBC Realm 使用
 * @author smk<br />
 * @since JDK 1.8
 */
public class MyRealm1 implements Realm {
    @Override
    public String getName() {
        return "myrealm1";
    }
    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();  //得到用户名
        String password = new String((char[])token.getCredentials()); //得到密码
        if(!"zhang".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}