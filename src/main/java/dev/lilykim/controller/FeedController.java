package dev.lilykim.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feed")
public class FeedController {
    @GetMapping("/hello")
    public String hello() {
        return "Controller test!_!";
    }
}
