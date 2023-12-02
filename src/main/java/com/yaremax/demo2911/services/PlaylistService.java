package com.yaremax.demo2911.services;

import com.yaremax.demo2911.data.Playlist;
import com.yaremax.demo2911.data.Track;
import com.yaremax.demo2911.data.TrackInfo;
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

    public Optional<Playlist> getPlaylist(int id) {
        return playlistRepository.findById(id);
    }

    public List<TrackInfo> getAvailableTracks(int id) {
        return trackService.findAvailableTracksForPlaylist(id);
    }

    public void deleteTrackFromPlaylist(int pid, int tid) {
        Playlist playlist = getPlaylist(pid).get();
        playlist.getTracks().removeIf(t->t.getId() == tid);
        playlistRepository.save(playlist);
    }

    public void addTrackToPlaylist(int pid, int tid) {
        Playlist playlist = getPlaylist(pid).get();
        Track track = trackService.getTrack(tid).get();
        playlist.getTracks().add(track);
        playlistRepository.save(playlist);
    }
}
