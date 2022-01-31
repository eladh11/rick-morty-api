package com.eladhakmon.rickandmortyapi.entity.location;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class LocationResult {

    public int id;
    public String name;
    public String type;
    public String dimension;
    public ArrayList<String> residents;
    public String url;
    public Date created;

}
