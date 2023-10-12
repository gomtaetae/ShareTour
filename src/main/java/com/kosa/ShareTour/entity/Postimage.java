package com.kosa.ShareTour.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="postimages")
@Setter
@Getter
public class Postimage extends BaseEntity {

    @Id
    @Column(name="postimages_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="postings_id")
    private Posting posting;

    @Column(name="img")
    private String img;

}
