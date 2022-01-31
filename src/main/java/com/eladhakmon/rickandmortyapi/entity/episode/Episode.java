package com.eladhakmon.rickandmortyapi.entity.episode;

import com.eladhakmon.rickandmortyapi.entity.Info;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Episode {
    public Info info;
    public ArrayList<EpisodeResult> results;

}
