package com.kosa.ShareTour.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="comments")
@Data
public class Comment implements Serializable {

    @Id
    @Column(name="comments_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @Column(name="likes")
    private int likes;

    @ManyToOne
    @JoinColumn(name="users_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="postings_id")
    private Posting posting;

}
