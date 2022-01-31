package com.eladhakmon.rickandmortyapi.entity.character;

import com.eladhakmon.rickandmortyapi.entity.Info;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Character {
    public Info info;
    public ArrayList<CharacterResult> results;

}
