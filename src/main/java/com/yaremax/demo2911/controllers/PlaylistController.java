package com.yaremax.demo2911.controllers;

import com.yaremax.demo2911.data.Playlist;
import com.yaremax.demo2911.services.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/playlists")
@AllArgsConstructor
public class PlaylistController {
    private final PlaylistService playlistService;

    @GetMapping
    public String showPlaylists(Model model) {
        model.addAttribute("playlists", playlistService.getPlaylists());
        return "playlists";
    }

    @GetMapping("/{id}")
    public String showArtistInfo(@PathVariable int id, Model model) {
        Optional<Playlist> playlist = playlistService.getPlaylist(id);
        if(playlist.isPresent()) {
            model.addAttribute("playlist", playlist.get());
            model.addAttribute("availableTracks", playlistService.getAvailableTracks(id));
            return "playlist_info";
        }
        else {
            return "playlist_not_found";
        }
    }

    @DeleteMapping("/{pid}/{tid}")
    public String deleteTrackFromPlaylist(@PathVariable int pid, @PathVariable int tid) {
        playlistService.deleteTrackFromPlaylist(pid, tid);
        return "redirect:/playlists/"+pid;
    }

    @PostMapping("/{pid}/{tid}")
    public String addTrackToPlaylist(@PathVariable int pid, @PathVariable int tid) {
        playlistService.addTrackToPlaylist(pid, tid);
        return "redirect:/playlists/"+pid;
    }
}
