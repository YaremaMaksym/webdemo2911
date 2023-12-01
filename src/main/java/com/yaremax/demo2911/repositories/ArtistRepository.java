package com.yaremax.demo2911.repositories;

import com.yaremax.demo2911.data.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}