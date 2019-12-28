package com.lcke.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//Id 这个包要特别注意
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * ClassName: asdasdas <br/>
 * Description: <br/>
 * date: 2019/12/27 22:43<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@Entity
@Table
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int age;
    //getter和setter


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
