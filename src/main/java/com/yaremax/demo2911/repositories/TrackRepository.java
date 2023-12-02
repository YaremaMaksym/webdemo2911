package com.yaremax.demo2911.repositories;

import com.yaremax.demo2911.data.Track;
import com.yaremax.demo2911.data.TrackInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Integer> {
    List<TrackInfo> findByComposerNotNull();

    @Query("select t from Track t where not exists (select 1 from Playlist p where t member of p.tracks and p.id = ?1)")
    List<TrackInfo> findTracksAvailableForPlaylist(Integer id);

}