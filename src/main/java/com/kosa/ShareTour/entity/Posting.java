package com.kosa.ShareTour.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="postings")
@Data
public class Posting {

    @Id
    @Column(name="posting_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postingId;

    @Column(name="title", length = 32, nullable = false)
    private String title;

    @Column(name="content", columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdat;

    @PrePersist
    protected void onCreate() {
        createdat = LocalDateTime.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="users_id", nullable = false)
    private User user;



}
