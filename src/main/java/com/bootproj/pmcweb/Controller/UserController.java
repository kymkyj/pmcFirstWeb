package com.bootproj.pmcweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @GetMapping("/page/{name}")
    public String getPage(@PathVariable String name){

        return "user/" + name;
    }
}