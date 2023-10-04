package com.kosa.ShareTour.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="postings")
@Getter
@Setter
@ToString

public class Posting {

    @Id
    @Column(name="postings_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postings_id;

    @Column(name="title", length = 32, nullable = false)
    private String title;

    @Column(name="content", columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    @Column(name="created_at", nullable = false)
    private LocalDateTime created_at;

    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now();
    }

}
