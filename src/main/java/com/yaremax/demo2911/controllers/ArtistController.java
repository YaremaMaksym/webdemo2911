package com.yaremax.demo2911.controllers;

import com.yaremax.demo2911.data.Artist;
import com.yaremax.demo2911.services.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/artists")
@AllArgsConstructor
public class ArtistController {
    private final ArtistService artistService;

    @GetMapping
    public String showArtists(Model model) {
        model.addAttribute("artists", artistService.getArtists());
        return "artists";
    }

    @GetMapping("/{id}")
    public String artistInfo(@PathVariable Integer id, Model model) {
        Optional<Artist> artist = artistService.getArtist(id);
        if(artist.isPresent()) {
            model.addAttribute("artist", artist.get());
            return "artist_info";
        }
        else {
            return "artist_not_found";
        }
    }

}
