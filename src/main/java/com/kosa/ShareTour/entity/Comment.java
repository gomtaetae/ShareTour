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
    private int comments_id;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="created_at", nullable = false)
    private LocalDateTime created_at;

    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now();
    }

    @Column(name="likes")
    private int likes;

    @ManyToOne
    @JoinColumn(name="users_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name="postings_id")
    private Posting posting_id;

}
