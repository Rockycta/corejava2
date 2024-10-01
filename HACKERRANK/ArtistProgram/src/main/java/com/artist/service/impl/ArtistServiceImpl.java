package com.artist.service.impl;

import com.artist.dto.ArtistRequest;
import com.artist.model.Artist;
import com.artist.repository.ArtistRepository;
import com.artist.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    @Override
    public Artist createArtist(ArtistRequest artistRequest) {
        Artist artist = new Artist();
        artist.setFirstName(artistRequest.firstName());
        artist.setLastName(artistRequest.lastName());
        return artistRepository.save(artist);
    }

    @Override
    public List<Artist> getArtists() {
      // return List.of();
        return artistRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Artist getArtistById(Long id) {
        Optional<Artist> artist = artistRepository.findById(id);
        return artist.orElseThrow(() -> new RuntimeException("Artist not found"));
    }

    @Override
    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
}
