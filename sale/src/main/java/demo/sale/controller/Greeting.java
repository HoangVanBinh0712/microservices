package demo.sale.controller;

import common.request.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "greet")
public class Greeting {

    @GetMapping
    public String greet() {
        return "Sale Hello";
    }

    @PostMapping(value = "print-user")
    public User user(@RequestBody User user) {
        return user;
    }

}
