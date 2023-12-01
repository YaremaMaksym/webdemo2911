package com.yaremax.demo2911.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "\"Artist\"")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ArtistId\"", nullable = false)
    private Integer id;

    @Column(name = "\"Name\"", length = 120)
    private String name;

    @OneToMany(mappedBy = "artist")
    private Set<Album> albums = new LinkedHashSet<>();

}