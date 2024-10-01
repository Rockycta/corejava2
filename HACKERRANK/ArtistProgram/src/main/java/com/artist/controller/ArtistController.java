package com.artist.controller;

import com.artist.dto.ArtistRequest;
import com.artist.model.Artist;
import com.artist.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    public ResponseEntity<Artist> createArtist(@RequestBody ArtistRequest artistRequest) {
        Artist createdArtist = artistService.createArtist(artistRequest);
     //   System.out.println("MyLog"+createdArtist.getFirstName()+createdArtist.getLastName());
        return new ResponseEntity<>(createdArtist, HttpStatus.CREATED);

    }


    @GetMapping("/{artistId}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long artistId) {
        Artist artist = artistService.getArtistById(artistId);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists() {
        List<Artist> artists = artistService.getArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @DeleteMapping("/{artistId}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long artistId) {
        artistService.deleteArtist(artistId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}