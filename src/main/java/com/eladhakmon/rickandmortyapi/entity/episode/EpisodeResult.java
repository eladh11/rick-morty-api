package com.eladhakmon.rickandmortyapi.entity.episode;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class EpisodeResult {
    public int id;
    public String name;
    public String air_date;
    public String episode;
    public ArrayList<String> characters;
    public String url;
    public Date created;
}
