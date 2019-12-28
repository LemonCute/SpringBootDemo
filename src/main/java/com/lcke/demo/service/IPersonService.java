package com.lcke.demo.service;

import com.lcke.demo.pojo.Person;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * ClassName: vxvxc <br/>
 * Description: <br/>
 * date: 2019/12/27 22:45<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
public interface IPersonService {
    Person findPersonByName(String name);

    void insertIntoPerson(Person person);

    List<Person> getPersonAgeBetween(int min, int max);

    Page<Person> getPersonsByPage(int pageNum, int pageSize);

    Page<Person> getPersonsBySortAge();


}
