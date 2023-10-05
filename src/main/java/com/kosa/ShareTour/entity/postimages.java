package com.kosa.ShareTour.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="postimages")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Data

public class postimages implements Serializable {

    @Id
    @Column(name="postimages_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postimages_id;

    @ManyToOne
    @JoinColumn(name="postings_id")
    private postings postings_id;

    @Column(name="img")
    private String img;

}