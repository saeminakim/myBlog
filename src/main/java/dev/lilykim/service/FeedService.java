package dev.lilykim.service;

import dev.lilykim.dao.DAO;
import dev.lilykim.domain.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedService {

    @Autowired
    private static DAO<Feed> dao;

    public FeedService(DAO<Feed> dao) {
        this.dao = dao;
    }

    public List<Feed> getFeeds() {
        return dao.list();
    }
}
