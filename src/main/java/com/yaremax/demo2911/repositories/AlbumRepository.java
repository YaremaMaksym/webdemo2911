package com.yaremax.demo2911.repositories;

import com.yaremax.demo2911.data.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}