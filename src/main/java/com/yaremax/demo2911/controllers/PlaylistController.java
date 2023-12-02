package com.yaremax.demo2911.controllers;

import com.yaremax.demo2911.data.Artist;
import com.yaremax.demo2911.data.Playlist;
import com.yaremax.demo2911.services.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String showArtistInfo(@PathVariable Integer id, Model model) {
        Optional<Playlist> playlist = playlistService.getPlaylist(id);
        if(playlist.isPresent()) {
            model.addAttribute("playlist", playlist.get());
            return "playlist_info";
        }
        else {
            return "playlist_not_found";
        }
    }
}
