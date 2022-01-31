package com.eladhakmon.rickandmortyapi.service;

import com.eladhakmon.rickandmortyapi.entity.character.Character;
import com.eladhakmon.rickandmortyapi.entity.character.CharacterResponse;
import com.eladhakmon.rickandmortyapi.entity.episode.Episode;
import com.eladhakmon.rickandmortyapi.entity.episode.EpisodeResponse;
import com.eladhakmon.rickandmortyapi.entity.location.Location;
import com.eladhakmon.rickandmortyapi.entity.location.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class RickAndMortyService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    private final WebClient webClient;

    public RickAndMortyService(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<CharacterResponse> findCharacterById(String id) {
        log.info("Character id: [{}]", id);
        return webClient.get().uri("/character/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("invalid id...")))
                .bodyToMono(CharacterResponse.class);
    }


    public Mono<LocationResponse> findLocationById(String id) {
        log.info("Location id: [{}]", id);
        return webClient.get().uri("/location/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("invalid id...")))
                .bodyToMono(LocationResponse.class);
    }


    public Mono<EpisodeResponse> findEpisodeById(String id) {
        log.info("Episode id: [{}]", id);
        return webClient.get().uri("/episode/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("invalid id...")))
                .bodyToMono(EpisodeResponse.class);
    }


    public Episode findAllEpisodes() {
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Episode> response = restTemplate.exchange("https://rickandmortyapi.com/api/episode", HttpMethod.GET,
                entity, Episode.class);

        return response.getBody();

    }


    public Location findAllLocations() {
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Location> response = restTemplate.exchange("https://rickandmortyapi.com/api/location", HttpMethod.GET,
                entity, Location.class);

        return response.getBody();

    }

    public Character findAllCharacters() {
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Character> response = restTemplate.exchange("https://rickandmortyapi.com/api/character", HttpMethod.GET,
                entity, Character.class);

        return response.getBody();

    }


//    public Flux<ListOfCharacterResponse> findAllCharacters() {
//        Flux<ListOfCharacterResponse> res = webClient.get().uri("/character/")
//                .accept(APPLICATION_JSON)
//                .retrieve()
//                .onStatus(HttpStatus::is4xxClientError,
//                        error -> Mono.error(new RuntimeException("invalid id...")))
//                .bodyToFlux(ListOfCharacterResponse.class);
//        log.info("Characters List: " + res.toString());
//        return res;
//    }

}