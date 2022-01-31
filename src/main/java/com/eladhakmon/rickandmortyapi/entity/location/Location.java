package com.eladhakmon.rickandmortyapi.entity.location;

import com.eladhakmon.rickandmortyapi.entity.Info;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Location {

    public Info info;
    public ArrayList<LocationResult> results;
}
