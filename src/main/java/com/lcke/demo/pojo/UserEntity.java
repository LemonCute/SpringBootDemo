package com.lcke.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.util.StringJoiner;

@TableName(value = "sys_user")
public class UserEntity {
    //value与数据库主键列名一致，若实体类属性名与表主键列名一致可省略value
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private int user_id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private int status;
    private int dept_id;
    private Date create_time;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserEntity.class.getSimpleName() + "[", "]")
                .add("user_id=" + user_id)
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("salt='" + salt + "'")
                .add("email='" + email + "'")
                .add("mobile='" + mobile + "'")
                .add("status=" + status)
                .add("dept_id=" + dept_id)
                .add("create_time=" + create_time)
                .toString();
    }
}
