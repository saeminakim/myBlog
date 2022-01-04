package dev.lilykim.dao;

import dev.lilykim.domain.Feed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FeedJdbcDAO implements DAO<Feed> {

    private static final Logger log = LoggerFactory.getLogger(FeedJdbcDAO.class);
    private JdbcTemplate jdbcTemplate;

    RowMapper<Feed> rowMapper = (rs, rowNum) -> {
        Feed feed = new Feed();
        feed.setId(rs.getLong("id"));
        feed.setName(rs.getString("name"));
        feed.setTitle(rs.getString("title"));
        feed.setContent(rs.getString("content"));
        feed.setCategory(rs.getString("category"));
        feed.setCreatedTime(rs.getLong("createdTime"));
        feed.setModifiedTime(rs.getLong("modifiedTime"));
        feed.setDelFlag(rs.getInt("delFlag"));
        return feed;
    };

    public FeedJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Feed> list() {
        String sql = "SELECT * from feed";
//        String sql = "SELECT id, name, title, content, category, createdTime, modifiedTime, delFlag from feed";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void create(Feed feed) {
        String sql = "insert into feed(title, name, content, category, createdTime, modifiedTime, delFlag) values(?, ?, ?, ?, ?, ?, ?)";
        int insert = jdbcTemplate.update(sql, feed.getTitle(), feed.getName(), feed.getContent(), feed.getCategory(), feed.getCreatedTime(), feed.getModifiedTime(), feed.getDelFlag());
        if(insert == 1) {
            log.info("New feed created: " + feed.getTitle());
        }
    }

    @Override
    public Optional<Feed> get(int id) {
        String sql = "SELECT id, name, title, content, category, createdTime, modifiedTime, delFlag from feed where id = ?";
        Feed feed = null;
        try {
            feed = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (DataAccessException ex) {
            log.info("Feed not found: " + id);
        }

        return Optional.ofNullable(feed);
    }

    @Override
    public void update(Feed feed, int id) {
        String sql = "update feed set title = ?, name = ?, content = ?, category = ?, modifiedTime = ?, delFlag = ? where id = ?";
        int update = jdbcTemplate.update(sql, feed.getTitle(), feed.getName(), feed.getContent(), feed.getCategory(), feed.getModifiedTime(), feed.getDelFlag());
        if(update == 1) {
            log.info("Feed updated: " + feed.getTitle());
        }
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from feed where id = ?", id);
    }
}
