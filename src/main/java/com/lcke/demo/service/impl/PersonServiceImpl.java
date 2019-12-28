package com.lcke.demo.service.impl;

import com.lcke.demo.dao.IPersonRepository;
import com.lcke.demo.pojo.Person;
import com.lcke.demo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName: bcxbxcb <br/>
 * Description: <br/>
 * date: 2019/12/27 22:46<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@Service
public class PersonServiceImpl implements IPersonService {
    @Autowired
    private IPersonRepository personRepository;

    @Override
    public Person findPersonByName(String name) {
        return personRepository.findPersonByName(name);
    }

    @Override
    public void insertIntoPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public List<Person> getPersonAgeBetween(int min, int max) {
        return personRepository.findPersonByAgeBetween(min, max);
    }

    @Override
    public Page<Person> getPersonsByPage(int pageNum, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNum, pageSize);
        return personRepository.findAll(pageable);
    }

    @Override
    public Page<Person> getPersonsBySortAge() {
        Sort sort = Sort.by(Sort.Direction.ASC, "age");
        Pageable pageable = PageRequest.of(0,5, sort);
        return personRepository.findAll(pageable);
    }


}
