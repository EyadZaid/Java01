package com.experis.mongorestapi.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
public class Language {
    @Id
    private String id;
    private String name;
    private String creator;
    private int year;
    private float lastVersion;


    public Language(String name, String creator, int year, float lastVersion) {
        this.name = name;
        this.creator = creator;
        this.year = year;
        this.lastVersion = lastVersion;
    }
}
