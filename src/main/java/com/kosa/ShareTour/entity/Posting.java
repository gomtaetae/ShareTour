package com.kosa.ShareTour.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="postings")
@Data
@ToString(exclude = "member")
public class Posting {

    @Id
    @Column(name="posting_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Lob
    @Column(name="content", columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="members_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "posting", cascade = CascadeType.REMOVE)
    private List<Comment> commentList = new ArrayList<>();

    public void createPosting(String title, String content) {
        Posting posting = new Posting();
        posting.setTitle(title);
        posting.setContent(content);
        posting.setCreatedAt(LocalDateTime.now());
    }

    public void updatePosting(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
