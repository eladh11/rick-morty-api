package com.eladhakmon.rickandmortyapi.entity;

import lombok.Data;

@Data
public class Info {

    public int count;
    public int pages;
    public String next;
    public Object prev;

}
