package com.lcke.demo.dao;

import com.lcke.demo.pojo.Person;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ClassName: dfdfds <br/>
 * Description: <br/>
 * date: 2019/12/27 22:46<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
public interface IPersonRepository extends JpaRepository<Person, Integer> {

    @Select("select * from Person")
    Person findPersonByName(String name);

    @Select(value = "select * from Person")
    List<Person> findPersonByAgeBetween(int min, int max);


}
