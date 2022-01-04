package dev.lilykim.controller;

import dev.lilykim.domain.Feed;
import dev.lilykim.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feeds")
public class FeedController {

    @Autowired
    private FeedService feedService;

    @GetMapping("/")
    public List<Feed> getFeeds() {
        return feedService.getFeeds();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Controller test!_!";
    }
}
