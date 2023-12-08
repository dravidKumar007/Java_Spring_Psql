package com.api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@CrossOrigin
@RequestMapping("/rest/nwe")
public class RestApplication {
    private final Jr per;

    public RestApplication(Jr per) {
        this.per = per;
    }


    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @GetMapping
    public List<Person> getpe() {
        return per.findAll();
    }

    @PostMapping
    public Person postpe(@RequestBody Person person) {
        per.save(person);
        return person;
    }

    @PutMapping
    public Optional<Person> putpe(@RequestBody Person person) {
        Person idp = per.findById(person.getId()).orElse(null);
        if (idp != null) {
            if (person.getName() != null)
                idp.setName(person.getName());
            if (person.getAge() != null)
                idp.setAge(person.getAge());
            per.save(idp);
        }
        return per.findById(person.getId());
    }

    @DeleteMapping
    public Person deletepe(@RequestBody Person pers) {
        Person p=per.findById(pers.getId()).orElse(null);
        per.deleteById(pers.getId());
        return p;
    }
    @GetMapping("/{id}")
    public Optional<Person> getpeid(@PathVariable Integer id) {
        return per.findById(id);
    }
}