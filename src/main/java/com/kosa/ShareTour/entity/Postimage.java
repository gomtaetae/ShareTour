package com.kosa.ShareTour.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="postimages")
@Data

public class Postimage implements Serializable {

    @Id
    @Column(name="postimages_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postimages_id;

    @ManyToOne
    @JoinColumn(name="postings_id")
    private Posting posting_id;

    @Column(name="img")
    private String img;

}
