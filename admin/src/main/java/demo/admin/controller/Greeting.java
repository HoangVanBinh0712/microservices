package demo.admin.controller;

import common.request.User;
import demo.admin.feign.SaleFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "greet")
public class Greeting {

    @Autowired
    private SaleFeignClient saleFeignClient;

    @GetMapping
    public String greet() {
        return "Admin Hello";
    }


    @GetMapping(value = "call-sale")
    public User callSale(String userName, Integer age) {
        return saleFeignClient.printUser(User.builder().userName(userName).age(age).build());
    }

}
