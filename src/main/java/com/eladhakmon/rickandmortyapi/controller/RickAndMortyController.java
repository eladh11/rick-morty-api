package com.eladhakmon.rickandmortyapi.controller;

import com.eladhakmon.rickandmortyapi.entity.character.Character;
import com.eladhakmon.rickandmortyapi.entity.character.CharacterResponse;
import com.eladhakmon.rickandmortyapi.entity.episode.Episode;
import com.eladhakmon.rickandmortyapi.entity.episode.EpisodeResponse;
import com.eladhakmon.rickandmortyapi.entity.location.Location;
import com.eladhakmon.rickandmortyapi.entity.location.LocationResponse;
import com.eladhakmon.rickandmortyapi.service.RickAndMortyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class RickAndMortyController {


    @Autowired
    private RickAndMortyService rickAndMortyService;


    @GetMapping("/character/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
        return rickAndMortyService.findCharacterById(id);
    }


    @GetMapping("/location/{id}")
    public Mono<LocationResponse> getLocationById(@PathVariable String id) {
        return rickAndMortyService.findLocationById(id);
    }


    @GetMapping("/episode/{id}")
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id) {
        return rickAndMortyService.findEpisodeById(id);
    }

    @GetMapping("/episodes")
    public ResponseEntity<Episode> getCharacters() {
        Episode episode = rickAndMortyService.findAllEpisodes();
        return new ResponseEntity<>(episode, HttpStatus.OK);
    }

    @GetMapping("/locations")
    public ResponseEntity<Location> getAllLocations() {
        Location location = rickAndMortyService.findAllLocations();
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @GetMapping("/characters")
    public ResponseEntity<Character> getAllCharacters() {
        Character character = rickAndMortyService.findAllCharacters();
        return new ResponseEntity<>(character, HttpStatus.OK);
    }

//    @GetMapping("/characters")
//    public Flux<ListOfCharacterResponse> getAllCharacters() {
//        return rickAndMortyService.findAllCharacters();
//    }


//    @GetMapping("/episodes")
//    public List<EpisodeResponse> getAllEpisodes() {
//
//        String url = "https://rickandmortyapi.com/api/episode";
//
//        EpisodeResponse[] objects = restTemplate.getForObject(url, EpisodeResponse[].class);
//
//        return Arrays.asList(objects);
//    }

}

