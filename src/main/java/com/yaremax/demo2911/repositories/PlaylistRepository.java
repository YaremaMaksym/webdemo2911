package com.yaremax.demo2911.repositories;

import com.yaremax.demo2911.data.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
}