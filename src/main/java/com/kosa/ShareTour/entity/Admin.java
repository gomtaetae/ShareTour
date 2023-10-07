package com.kosa.ShareTour.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="admin")
@Getter
@Setter
@ToString
public class Admin {

    @Id
    @Column(name="admin_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="name", length = 50, nullable = false)
    private String username;

    @Column(name="password", length = 50, nullable = false)
    private String password;

}
