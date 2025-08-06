package com.test.boot2.demo.controller;

import com.test.boot2.demo.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/json")
public class JsonController {

    @PostMapping("/user")
    public User getUser() {
        return new User("1", "大明", "abc");
    }

    @PostMapping("/list")
    public List<User> getList() {
        List<User> result = new ArrayList<>();
        User user01 = new User("1", "大明", "abc");
        User user02 = new User("2", "玲玲", "efg");
        result.add(user01);
        result.add(user02);
        return result;
    }

    @PostMapping("/map")
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>();
        User user01 = new User("1", "大明", null);
        map.put("user01", user01);
        map.put("年龄", 20);
        map.put("性别", "男");
        return map;
    }
}
