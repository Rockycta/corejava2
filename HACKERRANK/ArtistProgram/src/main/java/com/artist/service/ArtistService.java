package com.artist.service;

import com.artist.dto.ArtistRequest;
import com.artist.model.Artist;

import java.util.List;

public interface ArtistService {

    Artist createArtist(ArtistRequest artistRequest);

    List<Artist> getArtists();

    Artist getArtistById(Long id);

    void deleteArtist(Long id);

}
