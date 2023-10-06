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
    private int postimageId;

    @ManyToOne
    @JoinColumn(name="postings_id")
    private Posting posting;

    @Column(name="img")
    private String img;

}
