package com.lcke.demo.controller;

import com.lcke.demo.pojo.Person;
import com.lcke.demo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: sdfsdfds <br/>
 * Description: <br/>
 * date: 2019/12/27 22:45<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 * @RestController 是 @RestController 与 @ResponseBody 的结合体。
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private IPersonService personService;

    @RequestMapping("/find")
    public Person findPersonByName(String name){
        return personService.findPersonByName(name);
    }

    @PostMapping("/")
    public String insertIntoPerson(Person person){
        personService.insertIntoPerson(person);
        return "success";
    }
    @GetMapping("/age")
    public List<Person> getPersonAgeBetween(int min, int max){
        return personService.getPersonAgeBetween(min, max);
    }

    @GetMapping("/page")
    public Page<Person> getPersonsByPage(int pageNum, int pageSize){
        return personService.getPersonsByPage(pageNum, pageSize);
    }

    @GetMapping("/sort")
    public Page<Person> getPersonsBySortAge(){
        return personService.getPersonsBySortAge();
    }

}
