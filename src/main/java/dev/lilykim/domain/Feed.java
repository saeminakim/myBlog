package dev.lilykim.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;
    private String name;
    private String title;
    private String category;
    private long createdTime;
    private long modifiedTime;
    private int delFlag;
}
