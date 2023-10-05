package com.kosa.ShareTour.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="auctions")
@Data
public class Auction implements Serializable {

    @Id
    @Column(name="auctions_id")
    private int auctionsid;

    @Column(name="finalprice")
    private float finalprice;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User userid;

    @ManyToOne
    @JoinColumn(name="accommodation_id")
    private Accommodation accommodationid;

}
