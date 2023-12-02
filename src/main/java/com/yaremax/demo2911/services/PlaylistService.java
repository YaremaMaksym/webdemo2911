package com.yaremax.demo2911.services;

import com.yaremax.demo2911.data.Playlist;
import com.yaremax.demo2911.repositories.PlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final TrackService trackService;

    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }

    public Optional<Playlist> getPlaylist(Integer id) {
        return playlistRepository.findById(id);
    }
}
