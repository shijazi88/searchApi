package com.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;

@SpringBootApplication
@RestController
public class TestApplication implements CommandLineRunner
{

    @Autowired
    private PersonRepository personRepository;


    public static void main(String[] args)
    {
        SpringApplication.run(TestApplication.class, args);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<Person> findAllByRsql(@RequestParam(value = "search") String search)
    {
        Node rootNode = new RSQLParser().parse(search);
        Specification<Person> spec = rootNode.accept(new CustomRsqlVisitor<Person>());
        return personRepository.findAll(spec);
    }


    @Override
    public void run(String... args) throws Exception
    {
        List<Person> poeple = new ArrayList<Person>();
        Person p1 = new Person(1, "Safwan 1Hijazi", "Heath41@hotmail.com", "Regional Configuration Producer", "611-898-6201", "2015-11-06T07:21:25.510Z", true);
        Person p2 = new Person(2, "Safwan 2Hijazi", "Heath42@hotmail.com", "Regional Configuration Producer", "611-898-6201", "2015-11-06T07:21:25.510Z", false);
        Person p3 = new Person(3, "Safwan 3Hijazi", "Heath43@hotmail.com", "Regional Configuration Producer", "611-898-6201", "2015-11-06T07:21:25.510Z", true);
        Person p4 = new Person(4, "Safwan 4Hijazi", "Heath44@hotmail.com", "Regional Configuration Producer", "611-898-6201", "2015-11-06T07:21:25.510Z", true);
        Person p5 = new Person(5, "Safwan 5hHijazi", "Heath45@hotmail.com", "Regional Configuration Producer", "611-898-6201", "2015-11-06T07:21:25.510Z", false);
        Person p6 = new Person(6, "Safwan 6Hijazi", "Heath46@hotmail.com", "Regional Configuration Producer", "611-898-6201", "2015-11-06T07:21:25.510Z", false);
        Person p7 = new Person(7, "Safwans7sd 2Hijazi", "Heath47@hotmail.com", "Regional Configuration Producer", "611-898-6201", "2015-11-06T07:21:25.510Z", true);

        poeple.add(p1);
        poeple.add(p2);
        poeple.add(p3);
        poeple.add(p4);
        poeple.add(p5);
        poeple.add(p6);
        poeple.add(p7);

        personRepository.save(poeple);

    }

}
