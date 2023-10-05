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
    private int commentsid;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdat;

    @PrePersist
    protected void onCreate() {
        createdat = LocalDateTime.now();
    }

    @Column(name="likes")
    private int likes;

    @ManyToOne
    @JoinColumn(name="users_id")
    private User userid;

    @ManyToOne
    @JoinColumn(name="postings_id")
    private Posting postingid;

}
