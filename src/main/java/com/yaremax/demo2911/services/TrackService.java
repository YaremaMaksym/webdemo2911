package com.yaremax.demo2911.services;

import com.yaremax.demo2911.data.Track;
import com.yaremax.demo2911.data.TrackInfo;
import com.yaremax.demo2911.repositories.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TrackService {
    private final TrackRepository trackRepository;

    public List<TrackInfo> findAvailableTracksForPlaylist(int playlistId) {
        return trackRepository.findTracksAvailableForPlaylist(playlistId);
    }

    public Optional<Track> getTrack(int tid) {
        return trackRepository.findById(tid);
    }
}
