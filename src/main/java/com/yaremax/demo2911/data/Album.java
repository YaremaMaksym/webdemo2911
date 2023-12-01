package com.yaremax.demo2911.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"Album\"")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"AlbumId\"", nullable = false)
    private Integer id;

    @Column(name = "\"Title\"", nullable = false, length = 160)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"ArtistId\"", nullable = false)
    private Artist artist;

}