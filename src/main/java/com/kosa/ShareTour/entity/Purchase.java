package com.kosa.ShareTour.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="purchases")
@Data
public class Purchase implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="users_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name="packages_id")
    private Package packageId;

}
