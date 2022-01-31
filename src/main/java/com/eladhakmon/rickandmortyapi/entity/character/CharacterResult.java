package com.eladhakmon.rickandmortyapi.entity.character;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class CharacterResult {
    public int id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public Origin origin;
    public LocationForCharacter location;
    public String image;
    public ArrayList<String> episode;
    public String url;
    public Date created;
}
